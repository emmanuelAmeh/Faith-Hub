package com.example.android.faithhub;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "audiovisual_table")
public class AudioVisual {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String speaker;
    private String title;
    private String series;
    private String summary;
    private String imageSrc;
    private long dateCreated;
    private int duration;
    private int size;
    private boolean audio;
    private boolean video;

    public AudioVisual(String speaker, String title, String series, String summary, String imageSrc, long dateCreated, int duration,
                       int size, boolean audio, boolean video) {
        this.speaker = speaker;
        this.title = title;
        this.series = series;
        this.summary = summary;
        this.imageSrc = imageSrc;
        this.dateCreated = dateCreated;
        this.duration = duration;
        this.size = size;
        this.audio = audio;
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(long dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isAudio() {
        return audio;
    }

    public void setAudio(boolean audio) {
        this.audio = audio;
    }

    public boolean isVideo() {
        return video;
    }

    public void setVideo(boolean video) {
        this.video = video;
    }
}
