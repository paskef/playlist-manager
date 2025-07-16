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

    public String getName() {
        return name;
    }


    public String getCoverUrl() {
        return coverUrl;
    }

    public List<SongResponseDTO> getSongs() {
        return songs;
    }

}
