package com.paskef.playlistapp.api.controller;

import com.paskef.playlistapp.api.dto.album.*;
import com.paskef.playlistapp.api.dto.song.SongResponseDTO;
import com.paskef.playlistapp.api.service.AlbumService;
import com.paskef.playlistapp.model.Album;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/album")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping
    public ResponseEntity<AlbumInfoDTO> createAlbum(@RequestBody CreateAlbumDTO dto) {
        Album created = albumService.addAlbum(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(new AlbumInfoDTO(created));
    }

    @GetMapping
    public ResponseEntity<List<AlbumInfoDTO>> getAllAlbums() {
        List<Album> albums = albumService.getAllAlbums();
        List<AlbumInfoDTO> response = albums.stream()
                .map(AlbumInfoDTO::new)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlbumInfoDTO> getAlbumById(@PathVariable Integer id) {
        Album album = albumService.getAlbumById(id);
        return ResponseEntity.ok(new AlbumInfoDTO(album));
    }

    @GetMapping("/{id}/songs")
    public ResponseEntity<List<SongResponseDTO>> getSongsByAlbum(@PathVariable Integer id) {
        List<SongResponseDTO> songs = albumService.getSongsByAlbum(id);
        return ResponseEntity.ok(songs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumInfoDTO> updateAlbum(@PathVariable Integer id,
                                                    @RequestBody UpdateAlbumDTO updateAlbumDTO) {
        Album updated = albumService.updateAlbum(id, updateAlbumDTO);
        return ResponseEntity.ok(new AlbumInfoDTO(updated));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Integer id) {
        albumService.removeAlbum(id);
        return ResponseEntity.noContent().build();
    }
}
