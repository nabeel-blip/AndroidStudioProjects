package com.example.recycleandcardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Student> student;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        student = new ArrayList<>();
        prepareMovie();
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerViewAdapter = new RecyclerViewAdapter(student);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(recyclerViewAdapter);

    }

    private void prepareMovie() {
        student.add(new Student("Nabeel Hassan Khan","CS",0,"18F0242"));
        student.add(new Student("Buhamad Shanawaz Bashir","BBA",0,"18F7945"));
        student.add(new Student("Arman Gandalf","BBA",0,"18F1067"));
        student.add(new Student("Eustachys Kenta","EE",0,"18F3066"));
        student.add(new Student("Ji-Min Grimwald","MBA",0,"18F6785"));
    }
}
