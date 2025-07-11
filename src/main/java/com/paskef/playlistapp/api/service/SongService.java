package com.paskef.playlistapp.api.service;

import com.paskef.playlistapp.api.dto.album.AlbumInfoDTO;
import com.paskef.playlistapp.api.dto.song.CreateSongDTO;
import com.paskef.playlistapp.api.dto.song.UpdateSongDTO;
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

    public Song addSong(CreateSongDTO songDTO, Integer albumId) {
        Album album = albumRepository.findById(albumId).orElseThrow(() -> new EntityNotFoundException("Album with id " + albumId + " not found!"));
        Song song = new Song(songDTO, album);
        return songRepository.save(song);
    }

    public void removeSong(int id){
        if (songRepository.existsById(id)) {
            songRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Song with id " + id + " not found!");
        }

    }

    public Song updateSong(int id, UpdateSongDTO updateSongDTO, Integer albumId) {
        Song existingSong = songRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Song with id " + id + " not found!"));

        existingSong.setTitle(updateSongDTO.getTitle());
        existingSong.setDuration(updateSongDTO.getDuration());
        existingSong.setGender(updateSongDTO.getGender());
        existingSong.setLiked(updateSongDTO.isLiked());

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

    public AlbumInfoDTO getAlbumInfoBySongId(int id) {
        Song song = songRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Song with id " + id + " not found!"));
        Album album = song.getAlbum();
        return new AlbumInfoDTO(album.getTitle(), album.getArtist(), album.getCoverUrl(), album.getReleaseDate() );
    }
}
