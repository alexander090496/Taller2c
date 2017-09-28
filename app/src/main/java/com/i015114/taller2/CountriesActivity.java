package com.i015114.taller2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.i015114.taller2.Adapters.AdaptaerCountry1;
import com.i015114.taller2.Adapters.AdapterCountry;
import com.i015114.taller2.Connection.HttpManager;
import com.i015114.taller2.Models.Country;
import com.i015114.taller2.Models.Country1;
import com.i015114.taller2.Parser.JsonCountry;
import com.i015114.taller2.Parser.JsonCountry1;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class CountriesActivity extends AppCompatActivity {
    ProgressBar progressBar;
    Button button;
    RecyclerView recyclerView;
    List<Country1>country1List;
    AdaptaerCountry1 adaptaerCountry1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countries);

        progressBar = (ProgressBar) findViewById(R.id.id_pb_item);
        button = (Button) findViewById(R.id.id_btn_listcountries);
        recyclerView = (RecyclerView) findViewById(R.id.id_rv_item);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    public void processData(){
        adaptaerCountry1 = new AdaptaerCountry1(country1List, getApplicationContext());
        recyclerView.setAdapter(adaptaerCountry1);
    }
    public Boolean isOnLine(){
// Hacer llamado al servicio de conectividad utilizando el ConnectivityManager
        ConnectivityManager connectivityManager = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
// Obtener el estado de la conexion a internet en el dispositivo
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
// Validar el estado obtenido de la conexion
        if (networkInfo != null){
            return true;
        }else {
            return false;
        }
    }

    public void loadData(View view){
        if (isOnLine()){
            TaskCountry1 taskCountry1 = new TaskCountry1();
            taskCountry1.execute("https://restcountries.eu/rest/v2/lang/es");
        }else {
            Toast.makeText(this, "Sin conexion", Toast.LENGTH_SHORT).show();
        }
    }

    public class TaskCountry1 extends AsyncTask<String, String, String> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }
        @Override
        protected String doInBackground(String... strings) {
            String content = null;

            try {
                content = HttpManager.getData(strings[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return content;

        }
        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
        }
        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            try {
                country1List= JsonCountry1.getData(s);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            processData();
            progressBar.setVisibility(View.GONE);
        }
    }



}
