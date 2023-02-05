package com.example.e_reader

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e_reader.databinding.RecyclerviewStoriesViewLayoutBinding
import com.example.e_reader.model.Stories

/**
 * Create by Sirumalayil on 02-02-2023.
 */
class StoriesListAdapter(val callback: StoriesOnClickCallBack?):
    ListAdapter<Stories, StoriesListAdapter.StoriesListViewHolder>(StoriesDiffCallback()) {


    private class StoriesDiffCallback : DiffUtil.ItemCallback<Stories>() {
        override fun areItemsTheSame(oldItem: Stories, newItem: Stories) =
            oldItem.storyname == newItem.storyname

        override fun areContentsTheSame(oldItem: Stories, newItem: Stories) =
            oldItem == newItem

    }

    inner class StoriesListViewHolder(
        val binding: RecyclerviewStoriesViewLayoutBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindView(story: Stories?) {
            binding.storyName.text = story?.storyname
            binding.storyView.setOnClickListener {
                callback?.onSelectedStory(story)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesListViewHolder =
        StoriesListViewHolder(
            RecyclerviewStoriesViewLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: StoriesListViewHolder, position: Int) {
        val story = getItem(position)
        holder.bindView(story)
    }

    interface StoriesOnClickCallBack {
        fun onSelectedStory(story: Stories?)
    }
}