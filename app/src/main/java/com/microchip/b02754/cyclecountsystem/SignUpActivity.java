package com.microchip.b02754.cyclecountsystem;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

public class SignUpActivity extends AppCompatActivity {
    // Explicit
    private EditText nameEditText, idCardEditText, userEditText,
            passwordEditText, rePasswordEditText;
    private Button button;

    private String nameString, idCardString ,userString ,passwordString ,rePasswordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        //Bind widget

        nameEditText = (EditText) findViewById(R.id.editText);
        idCardEditText = (EditText) findViewById(R.id.editText2);
        userEditText = (EditText) findViewById(R.id.editText2);
        passwordEditText = (EditText) findViewById(R.id.editText4);
        rePasswordEditText = (EditText) findViewById(R.id.editText5);
        button = (Button) findViewById(R.id.button4);

        //Sign Up Control
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Get value from Edit Text
                nameString = nameEditText.getText().toString().trim();
                idCardString = idCardEditText.getText().toString().trim();
                userString = userEditText.getText().toString().trim();
                passwordString = passwordEditText.getText().toString().trim();
                rePasswordString = rePasswordEditText.getText().toString().trim();

                //Check Space
                if (nameString.equals("") || idCardString.equals("") ||
                        userString.equals("")|| passwordString.equals("")||
                        rePasswordString.equals("")) {
                    //Have Space
                    MyAlert myAlert = new MyAlert(SignUpActivity.this,R.drawable.doremon48,"มีช่องว่าง","Please enter all"   );
                    myAlert.myDialog();

                } else if (!passwordString.equals(rePasswordString)) {
                    // Password False
                    MyAlert myAlert = new MyAlert(SignUpActivity.this,R.drawable.nobita48,"Password Fail","Please try again");
                    myAlert.myDialog();
                } else {
                    // Password True

                    MyConstant myConstant = new MyConstant();
                    AddNawUser addNawUser = new AddNawUser(SignUpActivity.this);
                    addNawUser.execute(myConstant.getUrlAddUser());

                }

            }// onClick
        });

    } // Main Method

    //Asy ต้องอยู่ ใน Activity
    private class AddNawUser extends AsyncTask<String, Void, String> {
        //Explicit
        private Context context;

        public AddNawUser(Context context) {
            this.context = context;
        }

        @Override

        protected String doInBackground(String... params) {
            try {
                OkHttpClient okHttpClient = new OkHttpClient();
                RequestBody requestBody = new FormEncodingBuilder()
                        .add("isAdd", "true")
                        .add("Name", nameString)
                        .add("ID_card", idCardString)
                        .add("User", userString)
                        .add("Password", passwordString)
                        .add("Position", "0")
                        .add("Status", "0")
                        .build();

                Request.Builder builder = new Request.Builder();
                Request request = builder
                        .url(params[0])
                        .post(requestBody)
                        .build();
                Response response = okHttpClient.newCall(request).execute();
                return response.body().string();


            } catch (Exception e) {
                Log.d("6octV1", "e doInBack ==> " + e.toString());
                return null;
            }
        } //doInBack

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Log.d("6octV1", "Result ==> " + s);
            if (Boolean.parseBoolean(s)){
                finish(); // Close screen back to parent screen

            }else
            {
                Toast.makeText(context,"Can not save data",Toast.LENGTH_SHORT).show();
            }



        } //onPost


    } // AddNewUser Class





}  // Main Class
