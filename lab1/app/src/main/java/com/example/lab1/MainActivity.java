package com.example.lab1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public void btnClick(View view){

        EditText dollarAmount= (EditText) findViewById(R.id.dAmount);
        String dollarString = dollarAmount.getText().toString();
        Float dollarValue = Float.parseFloat(dollarString);
        Float pkrValue = (float) (177.24*dollarValue);
        Toast.makeText(this,"PKR =" + pkrValue,Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("18F0242-cycle","onCreate invoked");
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d("18F0242-cycle","onStart invoked");
    }
    @Override
    protected void onResume() {
        super.onResume();
        Log.d("18F0242-cycle","onResume invoked");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("18F0242-cycle","onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("18F0242-cycle","onStop invoked");
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("18F0242-cycle","onRestart invoked");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("18F0242-cycle","onDestroy invoked");
    }


}