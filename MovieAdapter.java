package com.example.flixator.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.flixator.Module.Moviw;
import com.example.flixator.R;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.Viewholder>{

    Context context;
    List<Moviw> moviw;

    public MovieAdapter(Context context, List<Moviw> moviw) {
        this.context = context;
        this.moviw = moviw;
    }

    @NonNull
    @Override
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d("MovieAdapter", "onCreateViewholder");
        View movieView = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false);
        return new Viewholder(movieView);
    }

    @Override
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        Log.d("MovieAdapter", "onBindViewHolder" + position);
        Moviw moviw = this.moviw.get(position);
        holder.bind(moviw);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder{

        TextView TvTitle;
        TextView TvOverview;
        ImageView ivPoster;

        public Viewholder(@NonNull View itemView) {
            super(itemView);
            TvTitle = itemView.findViewById(R.id.TvTitle);
            TvOverview = itemView.findViewById(R.id.TvOverview);
            ivPoster = itemView.findViewById(R.id.ivPoster);
        }

        public void bind(Moviw moviw) {
            TvTitle.setText(moviw.getTitle());
            TvOverview.setText(moviw.getOverview());
            Glide.with(context).load(moviw.getPosterPath()).into(ivPoster);
        }
    }
}
