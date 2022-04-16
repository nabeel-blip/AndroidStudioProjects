package com.example.recycleandcardview;

import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private ArrayList<Student> studentList;

    RecyclerViewAdapter(ArrayList<Student> list){
        this.studentList = list;
    }
    @Override
    public RecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_adapter_layout,parent,false);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Log.d("frstview","Value:"+position);

        final Student student = studentList.get(position);
        holder.name.setText(student.getName());
        holder.image.setBackgroundResource(student.getImage());
        holder.rollNO.setText(student.getRollNo());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.cardView.getContext(),ViewStudent.class);
                intent.putExtra("student",student);
                holder.cardView.getContext().startActivity(intent);
            }
        });
    }
    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView rollNO;
        private ImageView image;
        private CardView cardView;
        public MyViewHolder(View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            image = itemView.findViewById(R.id.image);
            rollNO = itemView.findViewById(R.id.RollNo);
            cardView = itemView.findViewById(R.id.carView);


            };
        }
    }
