package com.paskef.playlistapp.api.dto.song;

import com.paskef.playlistapp.api.dto.album.AlbumInfoDTO;
import com.paskef.playlistapp.exception.EntityNotFoundException;
import com.paskef.playlistapp.model.Song;

public class SongResponseDTO {

    private String title;
    private int duration;
    private String gender;
    private boolean liked;
    private AlbumInfoDTO album;

    public SongResponseDTO(Song song) {
        this.title = song.getTitle();
        this.duration = song.getDuration();
        this.gender = song.getGender();
        this.liked = song.getLiked();
        if (song.getAlbum() != null) {
            this.album = new AlbumInfoDTO(song.getAlbum().getTitle(), song.getAlbum().getArtist(), song.getAlbum().getCoverUrl(), song.getAlbum().getReleaseDate());
        } else {
            throw new EntityNotFoundException("Album not found for song: " + song.getTitle());
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }

    public AlbumInfoDTO getAlbum() {
        return album;
    }

    public void setAlbum(AlbumInfoDTO album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return "SongResponseDTO{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                ", gender='" + gender + '\'' +
                ", liked=" + liked +
                ", album=" + (album != null
                ? ("title='" + album.getTitle() + '\'' +
                ", artist='" + album.getArtist() + '\'' +
                ", coverUrl='" + album.getCoverUrl() + '\'' +
                ", releaseDate=" + album.getReleaseDate())
                : "null") +
                '}';
    }



}
