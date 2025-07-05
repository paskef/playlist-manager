package com.paskef.playlistapp.api.dto.playlist;

import jakarta.validation.constraints.*;
import java.util.List;

public class UpdatePlaylistDTO {

    @NotBlank(message = "Playlist name can't be blank!")
    private String name;

    @NotBlank(message = "Cover URL can't be blank!")
    private String coverUrl;

    private List<Integer> songIds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<Integer> getSongIds() {
        return songIds;
    }

    public void setSongIds(List<Integer> songIds) {
        this.songIds = songIds;
    }
}