package com.paskef.playlistapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.paskef.playlistapp.model.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {
}
