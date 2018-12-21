package com.example.anuo.myseven;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {
    private List<Novel> novelList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        CardView cardView;

        public ViewHolder(View view) {
            super(view);
            textView = (TextView) view.findViewById(R.id.txt_list);
            cardView = (CardView) view.findViewById(R.id.view_list);
        }
    }

    public ListAdapter(List<Novel> list) {
        novelList = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Novel novel = novelList.get(position);
        holder.textView.setText(novel.getTitle());
    }

    @Override
    public int getItemCount() {
        return novelList.size();
    }
}
