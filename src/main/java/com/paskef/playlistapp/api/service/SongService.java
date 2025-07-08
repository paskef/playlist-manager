package com.paskef.playlistapp.api.service;

import com.paskef.playlistapp.exception.EntityNotFoundException;
import com.paskef.playlistapp.model.Album;
import com.paskef.playlistapp.model.Song;
import com.paskef.playlistapp.repository.AlbumRepository;
import com.paskef.playlistapp.repository.SongRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final AlbumRepository albumRepository;

    public SongService(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song addSong(Song song, Integer albumId){
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new EntityNotFoundException("Album with id " + albumId + " not found!"));
        song.setAlbum(album);
        return songRepository.save(song);
    }

    public void removeSong(int id){
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Song with id " + id + " not found!");
        }

    }

    public Song updateSong(int id, Song newSong, Integer albumId) {
        Song existingSong = songRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Song with id " + id + " not found!"));

        existingSong.setTitle(newSong.getTitle());
        existingSong.setDuration(newSong.getDuration());
        existingSong.setLiked(newSong.getLiked());
        existingSong.setGender(newSong.getGender());

        if (albumId != null) {
            Album album = albumRepository.findById(albumId)
                    .orElseThrow(() -> new EntityNotFoundException("Album with id " + albumId + " not found!"));
            existingSong.setAlbum(album);
        }

        return songRepository.save(existingSong);
    }


    public Song getSongById(int id) {
        return songRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Song with id " + id + " not found!"));
    }


}
