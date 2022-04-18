package com.example.recycleandcardview;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class AddStudentFragment extends Fragment {
    public static final int PICK_IMAGE = 1;
    SharedPreferences sharedPreferences;
    public static final String myprefernce = "mypref";
    Student student;
    View view;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {

            sharedPreferences = getActivity().getSharedPreferences(myprefernce, Context.MODE_PRIVATE);
            view =  inflater.inflate(R.layout.fragment_add_student, container, false);
            view.findViewById(R.id.add_studet_IV_pfp).setBackgroundResource(R.drawable.images);
            student = new Student();
           view.findViewById(R.id.add_studnet_bt_add_phote).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View view) {
                   
                   Intent intent = new Intent();
                   intent.setType("image/*");
                   intent.setAction(Intent.ACTION_GET_CONTENT);
                   startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);

               }

           });
           view.findViewById(R.id.add_studnet_bt_add_student).setOnClickListener(new View.OnClickListener() {
               @Override
               public void onClick(View viewLocal) {
                   Log.d("mytext","did run");

                   EditText editText = getActivity().findViewById(R.id.add_studnet_pt_name);
                   String myText = editText.getText().toString();
                   student.setName(myText);
                    Log.d("mytext",myText);

                   editText = getActivity().findViewById(R.id.add_studnet_pt_deparment);
                   myText = editText.getText().toString();
                   student.setDepartment(myText);
                   Log.d("mytext",myText);

                   editText = getActivity().findViewById(R.id.add_studnet_pt_rollno);
                   myText = editText.getText().toString();
                   student.setRollNo(myText);

                   Gson gson = new Gson();
                   String json = gson.toJson(student);
                   SharedPreferences.Editor editor = sharedPreferences.edit();
                   editor.putString("NewStudent", json);
                   editor.apply();
                   Log.d("mytext",json);

                   ((FragmentActivity) viewLocal.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new VeiwStudentListFragment()).commit();

               }
           });
            return view;
        }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data)
    {

        if (requestCode == PICK_IMAGE) {
            //TODO: action
            InputStream inputStream = null;
            try {
                inputStream = getContext().getContentResolver().openInputStream(data.getData());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                student.setImage( (MediaStore.Images.Media.getBitmap(getContext().getContentResolver(), data.getData()));
            } catch (IOException e) {
                e.printStackTrace();
            }
            );
        }
    }
}





