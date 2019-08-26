package com.belajar.latihanrecyclerview;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private List<Song> songList;

    @NonNull
    @Override
    public SongAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.song_list_item,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull SongAdapter.ViewHolder holder, int position) {
        Song song = songList.get(position);
        holder.tvRank.setText(String.valueOf(song.getRank()));
        holder.tvSongName.setText(song.getName());
        holder.tvSinger.setText(song.getSinger());
        holder.ivAlbumCover.setImageResource(song.getPic());
        holder.tvYear.setText(song.getYear());
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvRank,tvSongName,tvSinger,tvYear;
        public ImageView ivAlbumCover;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvRank = (TextView) itemView.findViewById(R.id.tv_rank);
            tvSongName = (TextView) itemView.findViewById(R.id.tv_song_name);
            tvSinger = (TextView) itemView.findViewById(R.id.tv_singer);
            tvYear = (TextView)  itemView.findViewById(R.id.tv_year);
            ivAlbumCover = (ImageView) itemView.findViewById(R.id.iv_album_cover);

        }
    }

    public SongAdapter(List<Song> songList){
        this.songList = songList;
    }
}
