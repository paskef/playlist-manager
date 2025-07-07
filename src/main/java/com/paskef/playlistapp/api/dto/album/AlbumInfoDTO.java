package com.paskef.playlistapp.api.dto.album;

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
