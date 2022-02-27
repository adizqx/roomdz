package com.example.sql.dao


import androidx.room.*
import com.example.sql.entities.Book
import com.example.sql.entities.BooksAndGenres

@Dao
interface BookDao {
    @Query("SELECT * FROM Book")
    fun getAllBooks(): List<Book>
    @Insert
    fun addBook(vararg book:Book)
    @Delete
    fun deleteBook(book:Book)
    @Update
    fun updateBook(book: Book)
    @Query("DELETE FROM Book")
    fun deleteAllBooks()
    @Transaction
    @Query("SELECT * FROM Genre")
    fun getBooksAndGenres(): List<BooksAndGenres>
}