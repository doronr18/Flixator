package com.example.flixator.Module;

import android.graphics.Movie;

import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Moviw {

    String posterPath;
    String title;
    String overview;

    public Moviw(JSONObject jsonObject) throws JSONException {
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
    }

    public static List<Moviw> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        List<Moviw> moviw = new ArrayList<>();
        for (int i = 0; i < movieJsonArray.length(); i++){
            moviw.add(new Moviw(movieJsonArray.getJSONObject(i)));
        }
        return moviw;
    }

    public String getPosterPath() {
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }
}