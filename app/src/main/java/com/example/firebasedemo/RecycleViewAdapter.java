package com.example.firebasedemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    ArrayList<User> list = new ArrayList<>();

    public RecycleViewAdapter(Context ctx) {
        this.context = ctx;
    }

    public void setItems(ArrayList<User> users) {
        list.addAll(users);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        UserViewHolder vh = (UserViewHolder) holder;
        User user = list.get(position);
        vh.txt_name.setText(user.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
