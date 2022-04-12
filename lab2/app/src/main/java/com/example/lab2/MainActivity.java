package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onClick(View view){
        EditText editText = findViewById(R.id.editText1);
        String myText = editText.getText().toString();
        Intent intent = new Intent(this,MainActivity2.class);
        intent.putExtra("myText",myText);
        startActivity(intent);

    }
}