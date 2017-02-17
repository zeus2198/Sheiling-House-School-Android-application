package com.example.simran.shs;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by simra on 10/18/2016.
 */
public class page_timing extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ptimings,container,false);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "oswald.ttf");
        ((TextView) v.findViewById(R.id.htiming)).setTypeface(face);
        ((TextView) v.findViewById(R.id.h1)).setTypeface(face);
        ((TextView) v.findViewById(R.id.h2)).setTypeface(face);
        ((TextView) v.findViewById(R.id.h3)).setTypeface(face);
        ((TextView) v.findViewById(R.id.h4)).setTypeface(face);
        return v;
    }
}
