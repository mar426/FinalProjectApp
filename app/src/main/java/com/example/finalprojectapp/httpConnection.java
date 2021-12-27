package com.example.finalprojectapp;

import android.os.AsyncTask;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class httpConnection extends AsyncTask<Void, Void, String> {

    private static final String SERVER = "http://10.0.2.2:3000/";

    @Override
    protected String doInBackground(Void... voids) {
        //define url address:
        URL myUrl = null;
        try {
            myUrl = new URL(SERVER);
            //open connection:
            //HttpURLConnection connection =(HttpURLConnection) myUrl.openConnection();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
       return null;
    }
}
