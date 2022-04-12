package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    public static final String myprefernce = "mypref";
    ArrayList<String> myitems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences(myprefernce, Context.MODE_PRIVATE);
        ListView myListView = findViewById(R.id.myListView);


        // get data form shared preference and put it in the array for ListView
        ArrayList<String> myitems = new ArrayList<>();
        Map<String,?> keys = sharedPreferences.getAll();
        for(Map.Entry<String,?> entry : keys.entrySet()){
            myitems.add(entry.getValue().toString());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, myitems);
        myListView.setAdapter(arrayAdapter);


        myListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int item, long l) {

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Do you want to remove this item")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                //remove from list
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.remove(myitems.get(item));
                                editor.commit();
                                myitems.remove(item);
                                arrayAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();

                return false;
            }
        });
    }

    public void onClickAdd(View view){
        Intent intent = new Intent(this,addToList.class);
        startActivity(intent);
    }
}