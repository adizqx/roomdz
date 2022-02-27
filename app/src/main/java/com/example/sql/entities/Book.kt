package com.example.sql.entities

import android.os.Parcelable
import androidx.room.*
import kotlinx.android.parcel.Parcelize
import java.security.acl.Owner

@Parcelize
@Entity(
    foreignKeys = [ForeignKey(
        entity = Genre::class,
        parentColumns = ["id"],
        childColumns = ["genreId"]
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
) : Parcelable


@Entity
data class Genre(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "genreName") var genreName: String
){
    override fun toString(): String {
        return genreName
    }
}

data class BooksAndGenres(
    @Embedded val genre: Genre,
    @Relation(
        parentColumn = "id",
        entityColumn = "genreId"
    )
    val book: List<Book>
)


