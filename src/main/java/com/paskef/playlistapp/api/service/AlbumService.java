package com.paskef.playlistapp.api.service;

import com.paskef.playlistapp.exception.EntityNotFoundException;
import com.paskef.playlistapp.model.Album;
import com.paskef.playlistapp.repository.AlbumRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album addAlbum(Album album){
        return albumRepository.save(album);
    }

    public Album updateAlbum(int id, Album newAlbum) {
        Album existingAlbum = albumRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Album with id " + id + " not found"));

            existingAlbum.setArtist(newAlbum.getArtist());
            existingAlbum.setCoverUrl(newAlbum.getCoverUrl());
            existingAlbum.setTitle(newAlbum.getTitle());
            existingAlbum.setReleaseDate(newAlbum.getReleaseDate());
            return albumRepository.save(existingAlbum);

    }
    public void removeAlbum(int id){
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Album with id " + id + " not found!");
        }
    }
}
