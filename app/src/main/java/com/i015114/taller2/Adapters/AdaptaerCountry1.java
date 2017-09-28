package com.i015114.taller2.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.i015114.taller2.Models.Country1;
import com.i015114.taller2.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 27/09/2017.
 */

public class AdaptaerCountry1 extends RecyclerView.Adapter<AdaptaerCountry1.ViewHolder> {
    List<Country1> country1List=new ArrayList<>();
    Context context1;
    // Constructor de la clase
    public AdaptaerCountry1(List<Country1> country1List, Context context1) {
        this.country1List = country1List;
        this.context1 = context1;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
// Configuracion del ViewAdapter
// Obtener la vista (item.xml)
        View item1 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item1, parent, false);
// Pasar la vista (item.xml) al ViewHolder
        ViewHolder viewHolder = new ViewHolder(item1);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
// Encargado de trabajar con el item.xml y sus componentes
        holder.textViewName.setText(country1List.get(position).getName());
        holder.textViewCapital.setText(country1List.get(position).getCapital());
        holder.textViewAlphs.setText(country1List.get(position).getAlphacode());
        holder.textViewpopulation.setText(country1List.get(position).getPopulation());
        holder.textViewsubregion.setText(country1List.get(position).getSubregion());
    }
    @Override
    public int getItemCount() {
        return country1List.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView textViewName;
        TextView textViewCapital;
        TextView textViewAlphs;
        TextView textViewpopulation;
        TextView textViewsubregion;

        public ViewHolder(View item1) {
            super(item1);
            textViewName = (TextView) item1.findViewById(R.id.id_tv_item_namecountry);
            textViewCapital = (TextView) item1.findViewById(R.id.id_tv_item_namecapital);
            textViewAlphs = (TextView) item1.findViewById(R.id.id_tv_item_nameabbreviation);
            textViewpopulation=(TextView) item1.findViewById(R.id.id_tv_item_poblacion);
            textViewsubregion=(TextView)item1.findViewById(R.id.id_tv_item_subregion);
        }
    }
}
