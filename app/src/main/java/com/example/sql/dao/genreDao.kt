package com.example.sql.dao

import androidx.room.*
import com.example.sql.entities.Genre

@Dao
interface genreDao {
    @Query("SELECT * FROM Genre")
    fun getAllGenre(): List<Genre>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addGenre(vararg genre: Genre)

    @Delete
    fun deleteGenre(genre: Genre)

    @Update
    fun updateGenre(genre: Genre)
}