package com.example.recycleandcardview;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ViewStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_view_student);
        TextView textView = findViewById(R.id.View_studet_tv_X);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        RecyclerView studentAttributes = findViewById(R.id.Student_card_RV);
        studentAttributes.setLayoutManager(new LinearLayoutManager(this));
        Student temp = intent.getParcelableExtra("student");
        Log.d("tett",temp.getName());
        studentAttributes.setAdapter(new RecyclerViewStudentCardAdapter(intent.getParcelableExtra("student")));
    }

}