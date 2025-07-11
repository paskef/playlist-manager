package com.paskef.playlistapp.model;

import com.paskef.playlistapp.api.dto.song.CreateSongDTO;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "songs")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int duration;
    private String gender;
    private boolean liked = false;

    @ManyToOne
    @JoinColumn(name = "album_id")
    private Album album;

    @ManyToMany (mappedBy = "songs")
    private List<Playlist> playlists;

    public Song() {
    }

    public Song(String title, int duration, String gender, boolean liked, Album album) {
        this.title = title;
        this.duration = duration;
        this.gender = gender;
        this.liked = liked;
        this.album = album;
    }

    public Song(CreateSongDTO dto, Album album) {
        this.title = dto.getTitle();
        this.duration = dto.getDuration();
        this.gender = dto.getGender();
        this.liked = dto.isLiked();
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean getLiked() {
        return liked;
    }

    public void setLiked(boolean liked){
        this.liked = liked;
    }

    public int getDuration() { return duration; }

    public void setDuration(int duration) { this.duration = duration; }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}




