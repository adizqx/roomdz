package com.example.sql.dao


import androidx.room.*
import com.example.sql.entities.Book

@Dao
interface BookDao {
    @Query("SELECT * FROM Book")
    fun getAllBooks(): List<Book>
    @Insert
    fun addBook(vararg book:Book)
    @Delete
    fun deleteBook(book:Book)
}