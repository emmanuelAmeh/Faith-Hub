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
    private String audioSrc;
    private String videoSrc;
    private long dateCreated;
    private int duration;
    private int audioSize;
    private int videoSize;

    public AudioVisual(String speaker, String title, String series, String summary, String imageSrc, String audioSrc, String videoSrc, long dateCreated, int duration, int audioSize, int videoSize) {
        this.speaker = speaker;
        this.title = title;
        this.series = series;
        this.summary = summary;
        this.imageSrc = imageSrc;
        this.audioSrc = audioSrc;
        this.videoSrc = videoSrc;
        this.dateCreated = dateCreated;
        this.duration = duration;
        this.audioSize = audioSize;
        this.videoSize = videoSize;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getSpeaker() {
        return speaker;
    }

    public String getTitle() {
        return title;
    }

    public String getSeries() {
        return series;
    }

    public String getSummary() {
        return summary;
    }

    public String getImageSrc() {
        return imageSrc;
    }

    public String getAudioSrc() {
        return audioSrc;
    }

    public String getVideoSrc() {
        return videoSrc;
    }

    public long getDateCreated() {
        return dateCreated;
    }

    public int getDuration() {
        return duration;
    }

    public int getAudioSize() {
        return audioSize;
    }

    public int getVideoSize() {
        return videoSize;
    }
}
