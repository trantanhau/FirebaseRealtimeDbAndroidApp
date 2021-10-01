package com.example.firebasedemo;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

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
        vh.txt_option.setOnClickListener(event -> {
            PopupMenu popupMenu = new PopupMenu(context, vh.txt_option);
            popupMenu.inflate(R.menu.option_menu);
            popupMenu.setOnMenuItemClickListener(item -> {
                switch (item.getItemId()) {
                    case R.id.menu_edit:
                        Intent intent = new Intent(context, MainActivity.class);
                        intent.putExtra("EDIT", String.valueOf(user));
                        context.startActivity(intent);
                        break;
                    case R.id.menu_remove:
                        DAOUser dao = new DAOUser();
                        dao.remove(user.getKey()).addOnSuccessListener(success -> {
                            Toast.makeText(context, "User has been removed", Toast.LENGTH_SHORT).show();
                            notifyItemRemoved(position);
                        }).addOnFailureListener(error -> {
                            Toast.makeText(context, "" + error.getMessage(), Toast.LENGTH_SHORT).show();
                        });
                }
                return false;
            });
            popupMenu.show();
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
