package com.paskef.playlistapp.repository;

import com.paskef.playlistapp.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}
