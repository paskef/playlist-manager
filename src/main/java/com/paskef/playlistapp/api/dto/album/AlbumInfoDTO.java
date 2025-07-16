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

    public String getArtist() {
        return artist;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }


    public String getCoverUrl() {
        return coverUrl;
    }

}
