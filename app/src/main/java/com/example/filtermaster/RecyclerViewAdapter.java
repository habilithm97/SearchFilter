package com.example.filtermaster;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<Item> items; // 아이템을 담을 어레이 리스트
    Activity activity;

    public RecyclerViewAdapter(ArrayList<Item> items, Activity activity) {
        this.items = items;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.maple_item, null);
        // ViewHolder viewHolder = new ViewHolder(itemView);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        holder.tv.setText(items.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void filterList(ArrayList<Item> filteredList) {
        // 전달 받은 필터링된 아이템 어레이 리스트로 변경함
        items = filteredList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tv = (TextView)itemView.findViewById(R.id.name);
        }
    }
}
