package com.paskef.playlistapp.api.service;

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
        Album album = albumRepository.findById(albumId).orElse(null); // lançar exception dps
        song.setAlbum(album);
        return songRepository.save(song);
    }

    public void removeSong(int id){
        songRepository.deleteById(id);
    }

    public Song updateSong(int id, Song newsong, Integer albumId) {
        Song existingSong = songRepository.findById(id).orElse(null);
        Album album = albumRepository.findById(albumId).orElse(null);
        if (existingSong != null) {
            existingSong.setTitle(newsong.getTitle());
            existingSong.setDuration(newsong.getDuration());
            existingSong.setLiked(newsong.getLiked());

            if (album != null) {
                existingSong.setAlbum(album);
            }

            return songRepository.save(existingSong);
        }
        return null;
    }
}
