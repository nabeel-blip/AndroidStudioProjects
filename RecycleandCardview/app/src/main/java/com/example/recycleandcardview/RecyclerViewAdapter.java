package com.example.recycleandcardview;

import android.content.Context;
;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{
    private ArrayList<Student> studentList;
    SharedPreferences sharedPreferences;
    public static final String myprefernce = "mypref";
    SharedPreferences sharedPreferences_list;
    public static final String mypreferncelist = "mypreflist";


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

        final Student student = studentList.get(position);
        holder.name.setText(student.getName());
        holder.image.setBackgroundResource(student.getImage());
        holder.rollNO.setText(student.getRollNo());
        holder.cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sharedPreferences = holder.cardView.getContext().getSharedPreferences(myprefernce, Context.MODE_PRIVATE);

                //add to shared prefrance;
                //go to student card view
                Gson gson = new Gson();
                String json = gson.toJson(student);
                Log.d("RVA",json);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("ViewStudent", json);
                editor.apply();
                Log.d("RVA id","val"+R.id.main_fl);

                ((FragmentActivity) view.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fl,new ViewStudentFragment()).commit();

            }
        });
        holder.cardView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {

                new AlertDialog.Builder(view.getContext()).setTitle("Do you want to remove this item")
                        .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                sharedPreferences_list = holder.cardView.getContext().getSharedPreferences(mypreferncelist, Context.MODE_PRIVATE);
                                Gson gson = new Gson();
                                String json = gson.toJson(student);
                                SharedPreferences.Editor editor = sharedPreferences_list.edit();
                                editor.remove(json);
                                editor.apply();
                                Toast.makeText(view.getContext(), "Removed" + student.getName(),Toast.LENGTH_SHORT).show();
                                ((FragmentActivity) view.getContext()).getSupportFragmentManager().beginTransaction().replace(R.id.main_fl, new VeiwStudentListFragment()).commit();

                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).create().show();
                       return true;

                //pop up menu do you want ot delete item
                //get shared pefreance list over here and remove the item from it
                //remove item form normal shared prerence list whone it has been added in the home page after
                //returning from add student
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
