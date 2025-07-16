package com.paskef.playlistapp.api.dto.song;

import com.paskef.playlistapp.api.dto.album.AlbumInfoDTO;
import com.paskef.playlistapp.exception.EntityNotFoundException;
import com.paskef.playlistapp.model.Song;

public class SongResponseDTO {

    private final int id;
    private final String title;
    private final int duration;
    private final String gender;
    private final boolean liked;
    private final AlbumInfoDTO album;

    public SongResponseDTO(Song song) {
        this.id = song.getId();
        this.title = song.getTitle();
        this.duration = song.getDuration();
        this.gender = song.getGender();
        this.liked = song.getLiked();
        if (song.getAlbum() != null) {
            this.album = new AlbumInfoDTO(
                    song.getAlbum().getTitle(),
                    song.getAlbum().getArtist(),
                    song.getAlbum().getCoverUrl(),
                    song.getAlbum().getReleaseDate()
            );
        } else {
            this.album = null;
        }
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public String getGender() {
        return gender;
    }

    public boolean isLiked() {
        return liked;
    }

    public AlbumInfoDTO getAlbum() {
        return album;
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
