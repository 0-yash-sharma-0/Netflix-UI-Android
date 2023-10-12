package com.example.netflixcustomadapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerContactAdapter extends RecyclerView.Adapter<RecyclerContactAdapter.ViewHolder> {

    Context context;
    ArrayList<TvShowModel> tvShow;
    OnNoteListener onNoteListener;

    RecyclerContactAdapter(Context context , ArrayList<TvShowModel> tvShow , OnNoteListener onNoteListener){
        this.context = context;
        this.tvShow = tvShow;
        this.onNoteListener = onNoteListener;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.tv_show_layout,parent,false);
       ViewHolder viewHolder = new ViewHolder(view , onNoteListener);



        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
     final TvShowModel temp = tvShow.get(position);
     holder.imgTvShow.setImageResource(tvShow.get(position).image);


    }

    @Override
    public int getItemCount() {
        return tvShow.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
       ImageView imgTvShow;
       OnNoteListener onNoteListener;


        public ViewHolder(@NonNull View itemView , OnNoteListener onNoteListener) {
            super(itemView);
            imgTvShow = itemView.findViewById(R.id.imgTv);
            this.onNoteListener =onNoteListener;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if(onNoteListener !=null){
                onNoteListener.onNoteClick(view ,getAdapterPosition());
            }

        }


    }
    public interface OnNoteListener{
      void onNoteClick(View v , int position);
    }
}
