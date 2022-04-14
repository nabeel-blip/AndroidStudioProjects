package com.example.linkshelf;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddLinkFragment extends Fragment {
    SharedPreferences sharedPreferences;
    public static final String myprefernce = "mypref";
    View view;

    TextView textView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =  inflater.inflate(R.layout.fragment_add_link, container,false) ;
        sharedPreferences = getContext().getSharedPreferences(myprefernce, Context.MODE_PRIVATE);
        Button add_link_bt1 = (Button) view.findViewById(R.id.add_link_bt1);
        Button add_link_bt2 = (Button) view.findViewById(R.id.add_link_bt2);

        textView = (TextView) view.findViewById(R.id.add_link_pt1);
        add_link_bt1.setOnClickListener(new AddLink());
        add_link_bt2.setOnClickListener(new GoBackHome());

        return view;
    }

    class AddLink implements View.OnClickListener{
        public void onClick(View view) {
            String t = textView.getText().toString();
            textView.setText("");
            if(t.equals("") ){
                return;
            }
            if( sharedPreferences.contains(t)){
                Toast.makeText(getContext(),"link already exists",Toast.LENGTH_SHORT).show();
                return;
            }
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(t, t);
            editor.apply();
            Toast.makeText(getContext(),"link has been added ",Toast.LENGTH_SHORT).show();

        }
    }
    class GoBackHome implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.fragment_layout, new HomeFragment()).commit();
        }
    }
}
