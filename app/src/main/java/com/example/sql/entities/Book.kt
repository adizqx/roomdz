package com.example.sql.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Genre::class,
        parentColumns = ["id"],
        childColumns = ["genreId"],
        onDelete = ForeignKey.CASCADE,
        onUpdate = ForeignKey.CASCADE
    )]
)
data class Book(
    @PrimaryKey(autoGenerate = true) var id: Int,
    @ColumnInfo(name = "bookName") var bookName: String,
    @ColumnInfo(name = "author") var author: String,
    @ColumnInfo(name = "publicationDate") var publicationDate: String,
    @ColumnInfo(name = "pageAmount") var pageAmount: Int,
    @ColumnInfo(name = "amount") var amount: Int,
    @ColumnInfo(name = "place") var place: String,
    @ColumnInfo(name = "genreId") var genreId: Int
)

@Entity
data class Genre(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "genreName") var genreName: String
)

