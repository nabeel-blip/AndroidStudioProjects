package com.example.recycleandcardview;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

public class ViewStudentFragment extends Fragment {
    SharedPreferences sharedPreferences;
    public static final String myprefernce = "mypref";
    View view;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_view_student, container, false);
        //get from student to view from shared preference
        sharedPreferences = getActivity().getSharedPreferences(myprefernce, Context.MODE_PRIVATE);

        Gson gson = new Gson();
        String json = sharedPreferences.getString("ViewStudent", "");
        Student student = gson.fromJson(json, Student.class);

        TextView textView = view.findViewById(R.id.View_studet_tv_X);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new VeiwStudentListFragment()).commit();
            }
        });
        RecyclerView studentAttributes =  view.findViewById(R.id.Student_card_RV);
        studentAttributes.setLayoutManager(new LinearLayoutManager(getActivity()));
        view.findViewById(R.id.View_studet_IV_pfp).setBackgroundResource(student.getImage());
        studentAttributes.setAdapter(new RecyclerViewStudentCardAdapter(student));
        return view;
    }

}