package com.paskef.playlistapp.api.dto.album;

import com.paskef.playlistapp.model.Album;

import java.time.LocalDate;

public class AlbumInfoDTO {

    private String title;
    private String artist;
    private LocalDate releaseDate;
    private String coverUrl;

    public AlbumInfoDTO(String title, String artist, String coverUrl, LocalDate releaseDate) {
        this.title = title;
        this.artist = artist;
        this.releaseDate = releaseDate;
        this.coverUrl = coverUrl;
    }

    public AlbumInfoDTO(Album album) {
        this.title = album.getTitle();
        this.artist = album.getArtist();
        this.releaseDate = album.getReleaseDate();
        this.coverUrl = album.getCoverUrl();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }
}
