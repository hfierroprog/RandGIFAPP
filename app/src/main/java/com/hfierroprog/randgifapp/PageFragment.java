package com.hfierroprog.randgifapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.google.gson.JsonObject;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import org.json.JSONException;
import org.json.JSONObject;

public class PageFragment extends android.support.v4.app.Fragment{

    private View view;
    private ImageView imgGIF;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.page_fragment_layout, container, false);

        imgGIF = view.findViewById(R.id.imgGIF);

        Ion.with(getContext())
                .load("https://api.giphy.com/v1/gifs/random?api_key=UTvzNeIbjkDQnzhmx3PwFrMZVT6INkfI&tag=&rating=G")
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {

                        JsonObject jsonObject = result.getAsJsonObject("data");

                        try {
                            JSONObject JSON = new JSONObject(jsonObject.toString());

                            String link = JSON.getString("fixed_height_small_url");


                            Glide
                                    .with(getContext())
                                    .load(link)
                                    .fitCenter()
                                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                                    .into(imgGIF);


                        } catch (JSONException e1) {
                            e1.printStackTrace();
                        }
                    }
                });


        return view;
    }

}
