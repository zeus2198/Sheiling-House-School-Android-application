package com.example.simran.shs;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by simra on 10/18/2016.
 */

public class page_contact extends Fragment implements OnMapReadyCallback {
    private View v;
    private GoogleMap mMap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(v == null) {
            v = inflater.inflate(R.layout.pcontact, container, false);
        }
        if(mMap == null){
            SupportMapFragment mapFrag = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            mapFrag.getMapAsync(this);
        }


        Typeface face = Typeface.createFromAsset(getActivity().getAssets(),
                "oswald.ttf");
        ((TextView) v.findViewById(R.id.hcontact)).setTypeface(face);
        ((TextView) v.findViewById(R.id.hcontact2)).setTypeface(face);
        ((TextView) v.findViewById(R.id.hcontact3)).setTypeface(face);
        ((TextView) v.findViewById(R.id.hcontact4)).setTypeface(face);


        ImageButton ib = (ImageButton) v.findViewById(R.id.imageButton);
        ib.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/SheilingHouse/?rf=367679716575426"));
                startActivity(browserIntent);
            }
        });

        return v;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng school= new LatLng(26.484309, 80.326474);
        mMap.addMarker(new MarkerOptions().position(school).title("Sheiling House School"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(school, 18));
    }


}
