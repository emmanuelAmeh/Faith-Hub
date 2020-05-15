package com.example.android.faithhub;

import androidx.lifecycle.LiveData;
import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AudioVisualDao {

    //to fetch data rqd to display in each page
    @Query("SELECT * FROM audiovisual_table WHERE speaker >= :speaker LIMIT :size")
    public List<AudioVisual> getAudioVisualByAuthor(String speaker, int size);

    //used to populate db
    @Insert
    public void insertAudioVisual (AudioVisual audioVisual);

    @Update
    void updateAudioVisual (AudioVisual audioVisual);

    @Delete
    void deleteAudioVisual (AudioVisual audioVisual);

    @Query("DELETE FROM audiovisual_table")
    void deleteAllAudioVisuals();

    @Query("SELECT * FROM audiovisual_table ORDER BY id DESC")
    LiveData<List<AudioVisual>> getAllAudioVisuals();

    @Query("SELECT * FROM audiovisual_table ORDER BY id ASC")
    DataSource.Factory<Integer, AudioVisual> getAudioVisualById();
}
