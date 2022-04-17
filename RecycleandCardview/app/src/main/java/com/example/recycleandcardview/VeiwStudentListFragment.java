package com.example.recycleandcardview;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VeiwStudentListFragment extends Fragment {

    View view;
    ArrayList<Student> studentList;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_student_list, container, false);
        studentList = new ArrayList<>();
        prepareStudent();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(studentList));

    return view;
    }

    private void prepareStudent() {
        studentList.add(new Student("alovae human","CS",0,"18F0242"));
        studentList.add(new Student("Buhamad Shanawaz Bashir","BBA",0,"18F7945"));
        studentList.add(new Student("Arman Gandalf","BBA",0,"18F1067"));
        studentList.add(new Student("Eustachys Kenta","EE",0,"18F3066"));
        studentList.add(new Student("Ji-Min Grimwald","MBA",0,"18F6785"));
    }
}

