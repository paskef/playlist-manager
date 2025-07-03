package com.paskef.playlistapp.repository;

import com.paskef.playlistapp.model.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}
