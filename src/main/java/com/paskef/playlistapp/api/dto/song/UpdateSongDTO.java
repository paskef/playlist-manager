package com.paskef.playlistapp.api.dto.song;

import jakarta.validation.constraints.*;

public class UpdateSongDTO {

    @NotBlank(message = "Title can't be blank!")
    private String title;

    @Min(value = 1, message = "Song should be at least 1 second!")
    private int duration;

    @NotBlank(message = "Gender can't be blank!")
    private String gender;

    private boolean liked;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
