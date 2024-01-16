package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button login;
    TextView  Healthcare,welcome,sign_up;
    EditText username;
    EditText password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editTextText);
        password=findViewById(R.id.editTextNumberPassword);
        login=findViewById(R.id.button);
        Healthcare =findViewById(R.id.textView);
        welcome=findViewById(R.id.textView4);
        sign_up=findViewById(R.id.textView3);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username11= username.getText().toString();
                String password11 = password.getText().toString();
                database db = new database (getApplicationContext(),"patil",null,1);
                if(username.length()==0 || password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill the all detalis ",Toast.LENGTH_LONG).show();
                }else{
                    if(db.login(username11,password11)==1){
                        Toast.makeText(MainActivity.this, "Login is Successfully", Toast.LENGTH_SHORT).show();
                        SharedPreferences sharedPreferences= getSharedPreferences("shared", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor=sharedPreferences.edit();
                        //to save our data with key and value
                        editor.apply();
                        startActivities(new Intent[]{new Intent(MainActivity.this,second_page.class)});
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Login falied,please check your username and password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(MainActivity.this, regisiter.class)});
            }
        });
    }
}