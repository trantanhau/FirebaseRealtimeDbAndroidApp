package com.example.firebasedemo;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView txt_name, txt_option;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_option = itemView.findViewById(R.id.txt_option);
    }
}
