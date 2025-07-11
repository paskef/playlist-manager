package com.paskef.playlistapp.api.service;

import com.paskef.playlistapp.api.dto.album.CreateAlbumDTO;
import com.paskef.playlistapp.api.dto.album.UpdateAlbumDTO;
import com.paskef.playlistapp.api.dto.song.SongResponseDTO;
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

    public Album addAlbum(CreateAlbumDTO albumDTO) {
        Album album = new Album(albumDTO);
        return albumRepository.save(album);
    }

    public Album updateAlbum(int id, UpdateAlbumDTO updateAlbumDTO) {
        Album existingAlbum = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Album with id " + id + " not found"));

        existingAlbum.setArtist(updateAlbumDTO.getArtist());
        existingAlbum.setCoverUrl(updateAlbumDTO.getCoverUrl());
        existingAlbum.setTitle(updateAlbumDTO.getTitle());
        existingAlbum.setReleaseDate(updateAlbumDTO.getReleaseDate());

        return albumRepository.save(existingAlbum);
    }

    public void removeAlbum(int id) {
        if (albumRepository.existsById(id)) {
            albumRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Album with id " + id + " not found!");
        }
    }

    public Album getAlbumById(Integer id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Album with id " + id + " not found!"));
    }

    public List<SongResponseDTO> getSongsByAlbum(Integer id) {
        Album album = albumRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Album with id " + id + " not found!"));

        return album.getSongs().stream()
                .map(SongResponseDTO::new)
                .toList();
    }
}
