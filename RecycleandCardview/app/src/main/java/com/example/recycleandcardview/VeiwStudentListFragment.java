package com.example.recycleandcardview;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Map;

public class VeiwStudentListFragment extends Fragment {

    View view;
    ArrayList<Student> studentList;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    SharedPreferences sharedPreferences;
    public static final String myprefernce = "mypref";
    SharedPreferences sharedPreferences_list;
    public static final String mypreferncelist = "mypreflist";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_student_list, container, false);
        studentList = new ArrayList<>();
        sharedPreferences = getActivity().getSharedPreferences(myprefernce, Context.MODE_PRIVATE);
        sharedPreferences_list = getActivity().getSharedPreferences(mypreferncelist, Context.MODE_PRIVATE);

        get_from_add_student_fragment();
        get_data();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(new RecyclerViewAdapter(studentList));
        view.findViewById(R.id.student_list_bt_add_student).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((FragmentActivity) view.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, new AddStudentFragment()).commit();

            }
        });

        return view;
    }

    private void prepareStudent() {
        studentList.add(new Student("alovae human", "CS", 0, "18F0242"));
        studentList.add(new Student("Buhamad Shanawaz Bashir", "BBA", 0, "18F7945"));
        studentList.add(new Student("Arman Gandalf", "BBA", 0, "18F1067"));
        studentList.add(new Student("Eustachys Kenta", "EE", 0, "18F3066"));
        studentList.add(new Student("Ji-Min Grimwald", "MBA", 0, "18F6785"));

    }

    private void get_data() {
        Map<String, ?> keys = sharedPreferences_list.getAll();

        for (Map.Entry<String, ?> entry : keys.entrySet()) {
            Gson gson = new Gson();
            String json = entry.getValue().toString();
            Student student = gson.fromJson(json, Student.class);
            studentList.add(student);
        }
    }

    private void get_from_add_student_fragment() {
        Gson gson = new Gson();
        String json = sharedPreferences.getString("NewStudent", "");
        if (!json.equals("")) {
            SharedPreferences.Editor editorlist = sharedPreferences_list.edit();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.remove("NewStudent");
            editorlist.putString(json, json);
            editorlist.apply();
            //Student student = gson.fromJson(json, Student.class);
            //studentllist.add(student)

        }

    }
}
