package com.paskef.playlistapp.api.service;

import com.paskef.playlistapp.exception.EntityNotFoundException;
import com.paskef.playlistapp.model.Playlist;
import com.paskef.playlistapp.repository.PlaylistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    public PlaylistService(PlaylistRepository playlistRepository) {
        this.playlistRepository = playlistRepository;
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

    public Playlist addPlaylist(Playlist playlist){
        return playlistRepository.save(playlist);
    }

    public Playlist updatePlaylist(int id, Playlist playlistUpdated) {
        Playlist existingPlaylist = playlistRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Playlist with id " + id + " not found!"));

            existingPlaylist.setName(playlistUpdated.getName());
            existingPlaylist.setCoverUrl(playlistUpdated.getCoverUrl());
            existingPlaylist.setSongs(playlistUpdated.getSongs());

            return playlistRepository.save(existingPlaylist);

    }
}
