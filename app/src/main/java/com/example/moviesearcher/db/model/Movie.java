package com.example.moviesearcher.db.model;

import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.moviesearcher.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "Movie")
public class Movie {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name="id")
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("link")
    @Expose
    @ColumnInfo(name="link")
    private String link;
    @SerializedName("image")
    @Expose
    @ColumnInfo(name="image")
    private String image;
    @SerializedName("subtitle")
    @Expose
    @ColumnInfo(name="subtitle")
    private String subtitle;
    @SerializedName("pubDate")
    @Expose
    @ColumnInfo(name="pubDate")
    private String pubDate;
    @SerializedName("director")
    @Expose
    @ColumnInfo(name="director")
    private String director;
    @SerializedName("actor")
    @Expose
    @ColumnInfo(name="actor")
    private String actor;
    @SerializedName("userRating")
    @Expose
    @ColumnInfo(name="userRating")
    private String userRating;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActor() {
        return actor;
    }

    public void setActor(String actor) {
        this.actor = actor;
    }

    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView imageView, String imageUrl){
        Glide.with(imageView.getContext())
                .setDefaultRequestOptions(new RequestOptions()
                    .circleCrop())
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView);
    }
}