package com.hfierroprog.randgifapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class PageFragment extends android.support.v4.app.Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.page_fragment_layout, container, false);

        TextView txtEdit = (TextView) view.findViewById(R.id.txtEdit);

        Bundle bundle = getArguments();

        int pos = bundle.getInt("count");

        txtEdit.setText("numero: "+pos);

        return view;
    }
}
