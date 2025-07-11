package com.paskef.playlistapp.api.controller;

import com.paskef.playlistapp.api.dto.album.AlbumInfoDTO;
import com.paskef.playlistapp.api.dto.song.*;
import com.paskef.playlistapp.api.service.SongService;
import com.paskef.playlistapp.model.Song;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/song")
public class SongController {

    private final SongService songService;

    public SongController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping
    public ResponseEntity<List<SongResponseDTO>> getAllSongs() {
        List<Song> songs = songService.getAllSongs();
        List<SongResponseDTO> response = songs.stream()
                .map(song -> new SongResponseDTO(song))
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongResponseDTO> getSongById(@PathVariable int id) {
        Song song = songService.getSongById(id);
        SongResponseDTO response = new SongResponseDTO(song);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/album")
    public ResponseEntity<AlbumInfoDTO> getAlbumInfoBySongId(@PathVariable int id) {
        AlbumInfoDTO album = songService.getAlbumInfoBySongId(id);
        return ResponseEntity.ok(album);
    }

    @PostMapping
    public ResponseEntity<SongResponseDTO> addSong(@RequestBody CreateSongDTO songDTO,
                                                   @RequestParam Integer albumId) {
        Song created = songService.addSong(songDTO, albumId);
        SongResponseDTO response = new SongResponseDTO(created);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SongResponseDTO> updateSong(@PathVariable int id,
                                                      @RequestBody UpdateSongDTO updateSongDTO,
                                                      @RequestParam Integer albumId) {
        Song updated = songService.updateSong(id, updateSongDTO, albumId);
        SongResponseDTO response = new SongResponseDTO(updated);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeSong(@PathVariable int id) {
        songService.removeSong(id);
        return ResponseEntity.noContent().build();
    }
}