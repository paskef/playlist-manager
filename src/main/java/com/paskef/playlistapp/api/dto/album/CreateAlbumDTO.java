package com.paskef.playlistapp.api.dto.album;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.paskef.playlistapp.model.Song;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public class CreateAlbumDTO {

    @NotBlank(message = "Title can't be blank!")
    private String title;
    @NotBlank(message = "Artist can't be blank!")
    private String artist;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Release date is required!")
    @Past(message = "Release date must be in the past!")
    private LocalDate releaseDate;


    @Pattern(regexp = "^https?://", message = "Must be a valid URL!")
    private String coverUrl;

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
