package com.example.movieapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private Context mContext;
    private List<MovieModel> movieList;

    public MyAdapter(Context mContext, List<MovieModel> movieList) {
        this.mContext = mContext;
        this.movieList = movieList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        v = layoutInflater.inflate(R.layout.movie_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MovieModel item = movieList.get(position);


        holder.title.setText(item.getName());


//        Get nested data
        holder.duration.setText(item.getMoreDetails().getDuration());
        holder.category.setText(item.getMoreDetails().getCategory());
        holder.date.setText(item.getMoreDetails().getRelease());

//        Adding glide for show image
        Glide.with(mContext)
                .load(movieList.get(position).getImage())
                .into(holder.img);

//        Rating bar
        holder.ratingBar.setRating((item.getRating())/2);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title, category, date, duration;
        ImageView img;
        RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.txtTitle);
            duration = itemView.findViewById(R.id.txtDuration);
            category = itemView.findViewById(R.id.txtCategory);
            date = itemView.findViewById(R.id.txtDate);
            img = itemView.findViewById(R.id.imageView);
            ratingBar = itemView.findViewById(R.id.ratingBar);


        }
    }


}
