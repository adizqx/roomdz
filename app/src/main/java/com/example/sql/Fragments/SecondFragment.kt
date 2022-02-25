package com.example.sql.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.sql.Adapter.BookAdapter
import com.example.sql.App
import com.example.sql.R
import com.example.sql.database.AppDatabase
import com.example.sql.databinding.FragmentSecondBinding
import com.example.sql.entities.Book


class SecondFragment : Fragment() {
    lateinit var binding: FragmentSecondBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val value = arguments?.getString("key") as Book

        val db = App.instance?.getDatabase()?.bookDao()

        binding.RecyclerView.adapter = BookAdapter(db!!.getAllBooks())
        binding.RecyclerView.layoutManager = GridLayoutManager(context,3)
    }


}