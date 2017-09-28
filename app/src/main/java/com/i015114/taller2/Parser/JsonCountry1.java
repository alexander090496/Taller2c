package com.i015114.taller2.Parser;

import com.i015114.taller2.Models.Country1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 27/09/2017.
 */

public class JsonCountry1 {

    public static List<Country1> getData (String content) throws JSONException {
        JSONArray jsonArray = new JSONArray(content);
        List<Country1> country1List = new ArrayList<>();
        for(int i=0;i<jsonArray.length();i++){
            JSONObject item1 = jsonArray.getJSONObject(i);
            Country1 country1 = new Country1();
            country1.setName(item1.getString("name"));
            country1.setCapital(item1.getString("capital"));
            country1.setAlphacode(item1.getString("alpha3Code"));
            country1.setPopulation(item1.getInt("population"));
            country1.setSubregion(item1.getString("subregion"));
            country1List.add(country1);
        }
        return country1List;
    }


}
