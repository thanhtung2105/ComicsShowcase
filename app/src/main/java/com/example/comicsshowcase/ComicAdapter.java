package com.example.comicsshowcase;

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

import java.util.ArrayList;
import java.util.List;

public class ComicAdapter extends RecyclerView.Adapter<ComicAdapter.ViewHolder> {
    Context context;
   List<ComicModel> comicList;
    onClick_comicItem onClick_comicItem;
    public interface onClick_comicItem{
        void onClick(ComicModel comicModel);
    }

    public ComicAdapter(Context context, List<ComicModel> comicList, onClick_comicItem onClick_comicItem) {
        this.context = context;
        this.comicList = comicList;
        this.onClick_comicItem = onClick_comicItem;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.comic_item,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final ComicModel comicModel=comicList.get(position);
        holder.comic_name.setText(comicModel.getComic_name());
        Glide.with(context).load(comicModel.getComic_img()).into(holder.comic_img);
        Log.i("tag","onBindViewHolder 1 "+comicModel.getComic_img());
        holder.comic_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick_comicItem.onClick(comicModel);
            }
        });
    }

    @Override
    public int getItemCount() {
        return comicList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView comic_img;
        TextView comic_name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            comic_img = itemView.findViewById(R.id.comic_img);
            comic_name = itemView.findViewById(R.id.comic_name);
        }
    }

}
