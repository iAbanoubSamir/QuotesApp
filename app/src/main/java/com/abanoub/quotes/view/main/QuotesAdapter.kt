package com.abanoub.quotes.view.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.abanoub.domain.model.Result
import com.abanoub.quotes.databinding.QuoteItemBinding

class QuotesAdapter() :
    ListAdapter<Result, QuotesAdapter.QuotesViewHolder>(CategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuotesViewHolder {
        val itemBinding =
            QuoteItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return QuotesViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class QuotesViewHolder(private val itemBinding: QuoteItemBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(quote: Result) {
            itemBinding.quoteContent.text = quote.content
            itemBinding.quoteAuthor.text = quote.author
        }
    }

    class CategoryDiffCallback : DiffUtil.ItemCallback<Result>() {
        override fun areItemsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem._id == newItem._id
        }

        override fun areContentsTheSame(
            oldItem: Result,
            newItem: Result
        ): Boolean {
            return oldItem == newItem
        }
    }
}