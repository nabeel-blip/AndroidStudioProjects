package com.example.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class FollowFragment extends Fragment  implements View.OnClickListener {
    View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_follow ,container,false);
        Button upButton = (Button) view.findViewById(R.id.follow_framgment_b1);
        upButton.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {

        Intent intent = new Intent(view.getContext(),MainActivity2.class);
        startActivity(intent);

    }
}
