package com.paskef.playlistapp.api.dto.playlist;

public class PlaylistSummaryDTO {
    private int id;
    private String name;
    private String coverUrl;
    private int songsCount; // TODO: implement in controller


    public PlaylistSummaryDTO(int id, String name, String coverUrl, int songsCount) {
        this.id = id;
        this.name = name;
        this.coverUrl = coverUrl;
        this.songsCount = songsCount;
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

    public int getSongsCount() {
        return songsCount;
    }

    public void setSongsCount(int songsCount) {
        this.songsCount = songsCount;
    }
}
