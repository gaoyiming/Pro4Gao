package com.pro4gao;

import android.nfc.Tag;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.pro4gao.activity.SearchActivity;
import com.pro4gao.api.BaseBean;
import com.pro4gao.api.RetroApi;
import com.pro4gao.base.BaseActivity;

import java.io.IOException;
import java.util.HashMap;

import retrofit.Call;
import retrofit.Callback;
import retrofit.GsonConverterFactory;
import retrofit.JacksonConverterFactory;
import retrofit.Response;
import retrofit.Retrofit;

public class MainActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String BASE_URL = "http://124.207.115.50:8011/mobile/";
    public static final String TAG ="MainActivity" ;
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void initWidget() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//                intent2Activity(SearchActivity.class);
                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();

                RetroApi retroApi = retrofit.create(RetroApi.class);
                HashMap<String, String> stringStringHashMap = new HashMap<>();
                stringStringHashMap.put("keyword","足疗");
              //  final Call login = retroApi.login(stringStringHashMap);
                Call<BaseBean> stringCall = retroApi.HotWord();
                stringCall.enqueue(new Callback<BaseBean>() {
                    @Override
                    public void onResponse(Response<BaseBean> response, Retrofit retrofit) {
                        BaseBean body = response.body();
                        Object data = body.getData();
                        String s = response.toString();
                    }

                    @Override
                    public void onFailure(Throwable t) {
                        Log.e("Error", t.getMessage());
                    }
                });
//                new Thread(){
//                    @Override
//                    public void run() {
//                        super.run();
//                        Object body = null;
//                        try {
//
//                            body = login.execute().body();
//                        } catch (IOException e) {
//                            e.printStackTrace();
//                        }
//                        Log.e(TAG,body.toString());
//                    }
//                }.start();

//                login.enqueue(new Callback() {
//                    @Override
//                    public void onResponse(Response response, Retrofit retrofit) {
//                        int statusCode = response.code();
//                        Object body = response.body();
//                        Log.e(statusCode + "", body.toString());
//                    }
//
//                    @Override
//                    public void onFailure(Throwable t) {
//                        Log.e("", t.toString());
//                    }
//                });
            }
});


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void initData() {

    }

    @Override
    public void widgetClick() {

    }
//    private void netPost() {
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RetroApi retroApi = retrofit.create(RetroApi.class);
//        HashMap<String, String> stringStringHashMap = new HashMap<>();
//        stringStringHashMap.put("keyword","足疗");
//        Call login = retroApi.login(stringStringHashMap, new Callback() {
//            @Override
//            public void onResponse(Response response, Retrofit retrofit) {
//                int statusCode = response.code();
//                Object body = response.body();
//                Log.e(statusCode + "", body.toString());
//            }
//
//            @Override
//            public void onFailure(Throwable t) {
//                Log.e("", t.toString());
//            }
//        });
//    }

}
