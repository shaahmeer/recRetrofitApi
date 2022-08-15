package com.example.recretrofit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class recadapter extends RecyclerView.Adapter<recadapter.myviewholder> {
    public recadapter(List<model> data) {
        this.data = data;
    }

    List<model> data;







    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rowlayout,parent,false);
      myviewholder vh = new myviewholder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {

          // holder.t1.setText(data.get(position).getUserid());
       // holder.t2.setText(data.get(position).getId());
       holder.t3.setText(data.get(position).getTitle());
        holder.t4.setText(data.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class myviewholder extends RecyclerView.ViewHolder {

        TextView t1,t2,t3,t4;
        public myviewholder(@NonNull View itemView) {


            super(itemView);
            t1 = itemView.findViewById(R.id.userId);
            t2 = itemView.findViewById(R.id.id);
            t3 = itemView.findViewById(R.id.title);
            t4 = itemView.findViewById(R.id.body);
        }
    }
}
