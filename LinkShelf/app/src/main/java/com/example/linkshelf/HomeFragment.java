package com.example.linkshelf;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    View view;
    Button home_bt1 ;
    Button home_bt2 ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,container,false);


        if(view == null) {
            Toast.makeText(getContext(),"no view found for home fragment",Toast.LENGTH_SHORT).show();
            return null;
        }
        home_bt1 = (Button) view.findViewById(R.id.home_bt1);
        home_bt2 = (Button) view.findViewById(R.id.home_bt2);


        home_bt1.setOnClickListener(new AddLinkClicked());
        home_bt2.setOnClickListener(new ViewImageClicked());
        //home_bt3.setOnClickListener(new ViewLinksClicked());
        return view;
    }

     class AddLinkClicked implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //go to add link fragment

            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new AddLinkFragment()).commit();
        }
    }
     class ViewImageClicked implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            //go to view image fragment
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new ViewImageFragment()).commit();
        }

    }



}
