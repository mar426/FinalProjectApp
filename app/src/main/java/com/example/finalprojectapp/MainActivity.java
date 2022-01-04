package com.example.finalprojectapp;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.finalprojectapp.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final String SERVER = "http://10.0.2.2:3000/users/getUsers";
    private static final String SERVER_POST = "http://10.0.2.2:3000/users/addUser";

    private TextView tvServerResponse;
    private TextView PostServerResponse;
    private EditText lastName;
    private EditText firstName;
    private EditText userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GET:
        tvServerResponse = findViewById(R.id.textView);
        Button contactServerButton = findViewById(R.id.button);
        contactServerButton.setOnClickListener(onButtonClickListener);

        //POST:
        PostServerResponse = findViewById(R.id.textView1);
        Button postServerButton = findViewById(R.id.button1);
        postServerButton.setOnClickListener(postButtonClickListener);
        lastName=findViewById(R.id.editTextLastName);
        firstName=findViewById(R.id.editTextName);
        userID=findViewById(R.id.editTextID);

    }

    View.OnClickListener onButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HttpCall httpCall = new HttpCall();
            httpCall.setMethodtype(HttpCall.GET);
            httpCall.setUrl(SERVER);
            HashMap<String,String> params = new HashMap<>();
            params.put("name","James Bond");
            httpCall.setParams(params);
            new HttpRequest(){
                @Override
                public void onResponse(String response) {
                    super.onResponse(response);
                    tvServerResponse.setText("Get:"+response);
                }
            }.execute(httpCall);
        }
    };

    View.OnClickListener postButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            HttpCall httpCallPost = new HttpCall();
            httpCallPost.setMethodtype(HttpCall.POST);
            httpCallPost.setUrl(SERVER_POST);
            HashMap<String,String> params = new HashMap<>();
            params.put("userID","123");
            params.put("firstName","Lio");
            params.put("lastName","Mar");
            httpCallPost.setParams(params);
            Log.d("params:", String.valueOf(params));
            new HttpRequest(){
                @Override
                public void onResponse(String response) {
                    super.onResponse(response);
                    PostServerResponse.setText("Post:" +response);
                }
            }.execute(httpCallPost);
        }
    };
}
