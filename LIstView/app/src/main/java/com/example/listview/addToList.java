package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class addToList extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String myprefernce = "mypref";
    TextView tasktoadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_list);

        sharedPreferences = getSharedPreferences(myprefernce, Context.MODE_PRIVATE);
        tasktoadd = (TextView) findViewById(R.id.taskToadd);

    }

    public void onClickAdd(View view){
        String t = tasktoadd.getText().toString();
        Log.d(t,"");
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(t, t);
        editor.commit();

        tasktoadd.setText("");
        Toast.makeText(addToList.this,"task have been added",Toast.LENGTH_SHORT).show();


    }

    public void onClickBack(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

}