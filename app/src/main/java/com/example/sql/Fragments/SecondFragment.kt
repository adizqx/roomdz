package com.example.sql.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sql.Adapter.BookAdapter
import com.example.sql.App
import com.example.sql.R
import com.example.sql.database.AppDatabase
import com.example.sql.databinding.FragmentSecondBinding
import com.example.sql.entities.Book


class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding
    private val adapter: BookAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val db = App.instance?.getDatabase()?.bookDao()

        binding.RecyclerView.adapter = BookAdapter(db!!.getAllBooks())
        adapter?.notifyDataSetChanged()
        binding.RecyclerView.layoutManager = GridLayoutManager(context,3)

//        binding.deleteAllBtn.setOnClickListener {
//            val builder = AlertDialog.Builder(requireContext())
//            builder.setPositiveButton("Yes") { _, _ ->
//                App.instance?.getDatabase()?.bookDao()?.deleteAllBooks()
//                Toast.makeText(requireContext(), "All books deleted successfully", Toast.LENGTH_SHORT).show()
//            }
//            builder.setNegativeButton("No"){_,_->}
//            builder.setTitle("Delete all")
//            builder.setMessage("Do you want to delete all books?")
//            builder.create().show()
//        }
    }



}