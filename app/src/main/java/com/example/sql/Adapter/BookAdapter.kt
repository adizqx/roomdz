package com.example.sql.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.sql.Fragments.SecondFragmentDirections
import com.example.sql.R
import com.example.sql.entities.Book

class BookAdapter(var array:List<Book>):RecyclerView.Adapter<BookAdapter.BookViewHolder>() {
    class BookViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
         var bookName: TextView = itemView.findViewById(R.id.bookName)
         var author: TextView = itemView.findViewById(R.id.author)
         var pubDate: TextView = itemView.findViewById(R.id.pubDate)
         var pageAmount: TextView = itemView.findViewById(R.id.pageAmount)
         var amount: TextView = itemView.findViewById(R.id.amount)
         var place: TextView = itemView.findViewById(R.id.place)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
       return BookViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book,parent,false))
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
      val item = array[position]
        holder.bookName.text = item.bookName
        holder.author.text = item.author
        holder.pubDate.text = item.publicationDate
        holder.pageAmount.text = item.pageAmount.toString()
        holder.amount.text = item.amount.toString()
        holder.place.text = item.place

        holder.itemView.setOnClickListener {
                val action = SecondFragmentDirections.actionSecondFragmentToUpdateFragment(item)
            holder.itemView.findNavController().navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}