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
public class page_alumina extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.palumni,container,false);
        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "oswald.ttf");
        ((TextView) v.findViewById(R.id.halumni)).setTypeface(face);
        return v;
    }
}
