package com.example.sql.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.sql.App
import com.example.sql.R
import com.example.sql.databinding.FragmentFirstBinding
import com.example.sql.entities.Book
import com.example.sql.entities.Genre

class FirstFragment : Fragment() {
    lateinit var binding: FragmentFirstBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        val genres = mutableListOf(Genre(1,"Classic"),Genre(2,"Horror"),Genre(3, "Fantasy"),
            Genre(4, "Thriller"),Genre(5, "Romance"),Genre(6, "Adventure"))

        App.instance?.getDatabase()?.genreDao()?.addGenre(genres[0],genres[1],genres[2],genres[3],genres[4],genres[5])
        Log.i("GetAllGenres","${App.instance?.getDatabase()?.genreDao()?.getAllGenre()}")

        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            genres)

        binding.spinner.adapter = adapter
        binding.spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {}

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                  val genre = genres[position]
                 addBook(genre.id)
            }
        }

        binding.deleteBtn.setOnClickListener { App.instance?.getDatabase()?.genreDao()?.deleteAllGenre()
            Log.i("GetAllGenres","${App.instance?.getDatabase()?.genreDao()?.getAllGenre()}")
        }
        return binding.root
    }



    fun addBook(genreId: Int){
        binding.addBtn.setOnClickListener {
            val bookName = binding.etBookName.text.toString()
            val bookAuthor = binding.etAuthor.text.toString()
            val bookPublication = binding.etPublication.text.toString()
            val bookPageAmount = binding.etPageAmount.text.toString().toInt()
            val bookAmount = binding.etAmount.text.toString().toInt()
            val bookPlace = binding.etPlace.text.toString()

            val book = Book(0,bookName,bookAuthor,bookPublication,bookPageAmount,bookAmount,bookPlace,genreId)
            App.instance?.getDatabase()?.bookDao()?.addBook(book)
            Log.i("GetAllBooks","${App.instance?.getDatabase()?.bookDao()?.getAllBooks()}")
        }
    }



}