package com.example.sql.Fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.sql.Adapter.BookAdapter
import com.example.sql.App
import com.example.sql.R
import com.example.sql.databinding.FragmentUpdateBinding
import com.example.sql.entities.Book


class UpdateFragment : Fragment() {
lateinit var binding: FragmentUpdateBinding
private val args by navArgs<UpdateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentUpdateBinding.inflate(inflater, container, false)

        val pageAmount = args.book.pageAmount.toString()
        val amount = args.book.pageAmount.toString()
        binding.changeBookName.setText(args.book.bookName)
        binding.changeAuthor.setText(args.book.author)
        binding.changePublication.setText(args.book.publicationDate)
        binding.changePageAmount.setText(pageAmount)
        binding.changeAmount.setText(amount)
        binding.changePlace.setText(args.book.place)

        binding.editBtn.setOnClickListener {
            val changeBookName = binding.changeBookName.text.toString()
            val changeAuthor = binding.changeAuthor.text.toString()
            val changePublication = binding.changePublication.text.toString()
            val changePageAmount = binding.changePageAmount.text.toString().toInt()
            val changeAmount = binding.changeAmount.text.toString().toInt()
            val changePlace = binding.changePlace.text.toString()

            val updateBook = Book(args.book.id,changeBookName,changeAuthor,changePublication,changePageAmount,changeAmount,changePlace,args.book.genreId)
            App.instance?.getDatabase()?.bookDao()?.updateBook(updateBook)
            Log.i("GetAllBooksFrom","${App.instance?.getDatabase()?.bookDao()?.getAllBooks()}")
            Toast.makeText(requireContext(), "Updated successfully", Toast.LENGTH_SHORT).show()
        }

        binding.deleteBtn.setOnClickListener {
            val builder = AlertDialog.Builder(requireContext())
            builder.setPositiveButton("Yes") { _, _ ->
                App.instance?.getDatabase()?.bookDao()?.deleteBook(args.book)
                Toast.makeText(requireContext(), "${args.book.bookName}deleted successfully", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_updateFragment_to_secondFragment)
            }
            builder.setNegativeButton("No"){_,_->}
            builder.setTitle("Delete ${args.book.bookName}")
            builder.setMessage("Do you want to delete ${args.book.bookName}?")
            builder.create().show()
        }

        return binding.root
    }


}