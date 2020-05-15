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
public interface PublicationDao {

    //to fetch data rqd to display in each page
    @Query("SELECT * FROM publication_table WHERE author >= :author LIMIT :size")
    public List<Publication> getPublicationByAuthor(String author, int size);

    //used to populate db
    @Insert
    public void insertPublication(Publication publication);

    @Update
    void updatePublication(Publication publication);

    @Delete
    void deletePublication(Publication publication);

    @Query("DELETE FROM publication_table")
    void deleteAllPublication();

    @Query("SELECT * FROM publication_table ORDER BY id DESC")
    LiveData<List<Publication>> getAllPublication();

    @Query("SELECT * FROM publication_table ORDER BY id ASC")
    DataSource.Factory<Integer, Publication> getPublicationById();

}
