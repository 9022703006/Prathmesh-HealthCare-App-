package com.example.myapplication;

import static android.opengl.ETC1.isValid;

import androidx.appcompat.app.AppCompatActivity;
import java.util.*;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class regisiter extends AppCompatActivity {
    TextView heading,regisiter,login;
    EditText username;
    EditText Email;
    EditText password;
    EditText confire_password;
    Button register_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_regisiter);
        heading=findViewById(R.id.textView5);
        regisiter=findViewById(R.id.textView6);
        login=findViewById(R.id.textView7);
        username=findViewById(R.id.editTextText2);
        Email=findViewById(R.id.editTextText3);
        password=findViewById(R.id.editTextTextPassword);
        confire_password=findViewById(R.id.editTextTextPassword3);
        register_button=findViewById(R.id.button2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivities(new Intent[]{new Intent(regisiter.this,MainActivity.class)});
            }
        });

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username1= username.getText().toString();
                String password1= password.getText().toString();
                String Email1 = Email.getText().toString();
                String comfire_password1 = confire_password.getText().toString();
                database db = new database(getApplicationContext(),"patil",null,1);
                if(username1.length()==0||password1.length()==0||Email1.length()==0||comfire_password1.length()==0){
                    Toast.makeText(regisiter.this, "Please fill the all details.", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password1.compareTo(comfire_password1)==0){
                        if(fun_register_code(password1)){
                            db.regisiter(username1,Email1,password1);
                            Toast.makeText(regisiter.this, "Record insert ", Toast.LENGTH_SHORT).show();
                            startActivities(new Intent[]{ new Intent(regisiter.this,MainActivity.class)});
                        }
                        else{
                            Toast.makeText(regisiter.this, "Password must be least 8 Charcters and number", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(regisiter.this, "Password and confirm password did not match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean fun_register_code(String password_here){
        int f1=0,f2=0,f3=0;
        if(password_here.length()<8){
            return false;
        }else{
            for(int p=0;p<password_here.length();p++){
                if(Character.isLetter(password_here.charAt(p))){
                    f1=1;
                }
            }
            for(int r=0;r<password_here.length();r++){
                if(Character.isDigit(password_here.charAt(r))){
                    f2=1;
                }
            }
            for(int s=0;s<password_here.length();s++){
                char c = password_here.charAt(s);
                if(c>33&&c<=46||c==64){
                    f3=1;
                }
            }
        }
        if(f1==1&&f2==1&&f3==1){
          return true;
        }
        return false;
    }
}