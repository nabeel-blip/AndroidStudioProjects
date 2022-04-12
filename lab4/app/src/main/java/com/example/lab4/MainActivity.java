package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView name;
    TextView email;
    public static final String myprefernce = "mypref";
    public static final String Name = "nameKey";
    public static final String Email= "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = (TextView) findViewById(R.id.LoginName);
        email = (TextView) findViewById(R.id.Email);
        sharedPreferences = getSharedPreferences(myprefernce, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email, ""));
        }


    }
    public void onClickSave(View view) {
        String n = name.getText().toString();
        String e = email.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, n);
        editor.putString(Email, e);
        editor.commit();
    }

    public void onClickClear(View view) {
        name = (TextView) findViewById(R.id.LoginName);
        email = (TextView) findViewById(R.id.Email);
        name.setText("");
        email.setText("");

    }
    public void onClickGet(View view) {

        name = (TextView) findViewById(R.id.LoginName);
        email = (TextView) findViewById(R.id.Email);
        sharedPreferences = getSharedPreferences(myprefernce, Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name, ""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email, ""));
        }
    }

    public void onClickAdd (View view){
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("myText",myText);
        startActivity(intent);
    }



}