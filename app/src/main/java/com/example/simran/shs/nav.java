package com.example.simran.shs;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewFlipper;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class nav extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    CarouselView carouselView, carouselView2;
    ViewFlipper vf;
    int[] sampleImages = {R.drawable.shs0, R.drawable.shs2, R.drawable.shs1};
    int[] sampleImages2 = {R.drawable.f1, R.drawable.f2, R.drawable.f3};
    int[] changefonts = {R.id.vis, R.id.facilities, R.id.tshs, R.id.curpage};
    private int lid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        //getSupportActionBar().setIcon(R.drawable.ic_shs);

        vf = (ViewFlipper)findViewById(R.id.vf);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(imageListener);
        carouselView2 = (CarouselView) findViewById(R.id.carouselView2);
        carouselView2.setPageCount(sampleImages2.length);

        carouselView2.setImageListener(imageListener2);



        TextView tv;
        Typeface face = Typeface.createFromAsset(getAssets(),
                "oswald.ttf");
        for(int i = 0; i < changefonts.length; i++) {
            tv = (TextView) findViewById(changefonts[i]);
            tv.setTypeface(face);
        }

    }

    ImageListener imageListener2= new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages2[position]);
        }
    };

    ImageListener imageListener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(sampleImages[position]);
        }
    };

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }



    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        if (item.isChecked()) item.setChecked(false);
        else item.setChecked(true);
        lid = item.getItemId();
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                Fragment frag = new page_about();
                if (lid == R.id.nav_home) {
                    getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.argb(0, 0, 0, 0)));
                    vf.setDisplayedChild(0);

                } else if (lid == R.id.nav_about) {
                    vf.setDisplayedChild(1);
                    getSupportActionBar().setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.nbgrad, null));
                    frag = new page_about();
                    ((TextView) findViewById(R.id.curpage)).setText("ABOUT");

                } else if (lid == R.id.nav_timings) {
                    vf.setDisplayedChild(1);
                    getSupportActionBar().setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.nbgrad, null));
                    frag = new page_timing();
                    ((TextView) findViewById(R.id.curpage)).setText("TIMINGS");

                } else if (lid == R.id.nav_alumni) {
                    vf.setDisplayedChild(1);
                    getSupportActionBar().setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.nbgrad, null));
                    frag = new page_alumina();
                    ((TextView) findViewById(R.id.curpage)).setText("ALUMNI");
                } else if (lid == R.id.nav_contact) {
                    vf.setDisplayedChild(1);
                    getSupportActionBar().setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.nbgrad, null));
                    frag = new page_contact();
                    ((TextView) findViewById(R.id.curpage)).setText("CONTACT");
                } else if (lid == R.id.website) {
                    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                    drawer.closeDrawers();
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.shskanpur.com/"));
                    startActivity(browserIntent);
                }


                FragmentManager fragm = getSupportFragmentManager();
                fragm.beginTransaction().replace(R.id.fragholder, frag).commit();
            }
        }, 250);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawers();
        return true;
    }
}
