package com.example.recycleandcardview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewStudentCardAdapter extends RecyclerView.Adapter<RecyclerViewStudentCardAdapter.StudentCardViewHolder>{
     Student content;
    public RecyclerViewStudentCardAdapter(Student content) {
        this.content = content;
    }

    @NonNull
    @Override
    public StudentCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recylerveiw_student_card,parent,false);
        return new StudentCardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentCardViewHolder holder, int position) {

       switch (position){
            case 0:
                holder.textview1.setText("Name");
                holder.textview2.setText(content.getName());
            break;

            case 1:
                holder.textview1.setText("RollNo");
                holder.textview2.setText(content.getRollNo());
                break;
            case 2:
                holder.textview1.setText("Deparment");
                holder.textview2.setText(content.getDepartment());
                break;
        }
    }
    @Override
    public int getItemCount()   {
        return 3;
    }
    public class StudentCardViewHolder extends RecyclerView.ViewHolder{
        private TextView textview1;
        private TextView textview2;

        public StudentCardViewHolder(@NonNull View itemView) {
            super(itemView);
            textview1  = itemView.findViewById(R.id.studentCard_tv_heading);
            textview2  = itemView.findViewById(R.id.studentCard_tv_description);
        }
    }

}




