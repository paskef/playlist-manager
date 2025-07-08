package com.paskef.playlistapp.api.dto.playlist;

import com.paskef.playlistapp.api.dto.song.SongResponseDTO;

import java.util.List;

public class PlaylistResponseDTO {
    private int id;
    private String name;
    private String coverUrl;
    private List<SongResponseDTO> songs;

    public PlaylistResponseDTO(int id, String name, String coverUrl, List<SongResponseDTO> songs) {
        this.id = id;
        this.name = name;
        this.coverUrl = coverUrl;
        this.songs = songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public List<SongResponseDTO> getSongs() {
        return songs;
    }

    public void setSongs(List<SongResponseDTO> songs) {
        this.songs = songs;
    }
}
