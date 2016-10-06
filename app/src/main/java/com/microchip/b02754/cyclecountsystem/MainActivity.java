package com.microchip.b02754.cyclecountsystem;

import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    //Explicit
    private Button signInButton ,signUpButton ,synButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bind Widget
        signInButton = (Button) findViewById(R.id.button);
        signUpButton = (Button) findViewById(R.id.button2);
        synButton = (Button) findViewById(R.id.button3);

        //Sign Up Controller
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,SignUpActivity.class));
            }// onclick
        });

        //Check Internet

        if (checkInternet()) {
            //Internet ok
            Toast.makeText(this,"Can connect internet",Toast.LENGTH_SHORT).show();
        } else {
            //Internet fail
            //Toast.makeText(this,"Can not connect internet",Toast.LENGTH_SHORT).show();
            MyAlert myAlert = new MyAlert(MainActivity.this,R.drawable.kon48,"Internet fail","Cannot Connected Internet.");
            myAlert.myDialog();
        }
    } // Main Method

    private boolean checkInternet() {
        try {
            boolean bolInternet = false;
            ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
            NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();


            if ((networkInfo != null)&&(networkInfo.isConnected())) {
                bolInternet = true;
            }

            Log.d("6octV2","bolInter ==>" + bolInternet);
            return bolInternet;
        } catch (Exception e) {
            return false;
        }


    }


} //Main
