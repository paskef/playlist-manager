package com.paskef.playlistapp.api.service;

import com.paskef.playlistapp.api.dto.playlist.CreatePlaylistDTO;
import com.paskef.playlistapp.api.dto.playlist.UpdatePlaylistDTO;
import com.paskef.playlistapp.exception.EntityNotFoundException;
import com.paskef.playlistapp.model.Playlist;
import com.paskef.playlistapp.model.Song;
import com.paskef.playlistapp.model.User;
import com.paskef.playlistapp.repository.PlaylistRepository;
import com.paskef.playlistapp.repository.SongRepository;
import com.paskef.playlistapp.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;
    private final UserRepository userRepository;
    private final SongRepository songRepository;

    public PlaylistService(PlaylistRepository playlistRepository, UserRepository userRepository, SongRepository songRepository) {
        this.playlistRepository = playlistRepository;
        this.userRepository = userRepository;
        this.songRepository = songRepository;
    }

    public List<Playlist> getAllPlaylists(){
        return playlistRepository.findAll();
    }

    public void removePlaylist(int id) {
        if (playlistRepository.existsById(id)) {
            playlistRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Playlist with id " + id + " not found!");
        }
    }
    public Playlist addPlaylist(CreatePlaylistDTO dto){
        Playlist playlist = new Playlist(dto);
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new EntityNotFoundException("User with id " + dto.getUserId() + " not found!"));
        playlist.setUser(user);

        if (dto.getSongIds() != null && !dto.getSongIds().isEmpty()) {
            List<Song> songs = new ArrayList<>();
            for (Integer songId : dto.getSongIds()) {
                Song song = songRepository.findById(songId)
                        .orElseThrow(() -> new EntityNotFoundException("Song with id " + songId + " not found!"));
                songs.add(song);
            }
            playlist.setSongs(songs);
        }
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(int id, UpdatePlaylistDTO dto) {
        Playlist existingPlaylist = playlistRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Playlist with id " + id + " not found!"));

        existingPlaylist.setName(dto.getName());
        existingPlaylist.setCoverUrl(dto.getCoverUrl());

        if (dto.getSongIds() != null) {
            List<Song> songs = new ArrayList<>();
            for (Integer songId : dto.getSongIds()) {
                Song song = songRepository.findById(songId)
                        .orElseThrow(() -> new EntityNotFoundException("Song with id " + songId + " not found!"));
                songs.add(song);
            }
            existingPlaylist.setSongs(songs);
        }

        return playlistRepository.save(existingPlaylist);
    }

}
