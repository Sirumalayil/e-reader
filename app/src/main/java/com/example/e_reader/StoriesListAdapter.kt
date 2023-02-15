package com.example.e_reader

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.e_reader.databinding.RecyclerviewStoriesViewLayoutBinding
import com.example.e_reader.model.Stories
import com.example.e_reader.model.Story

/**
 * Create by Sirumalayil on 02-02-2023.
 */
class StoriesListAdapter(val callback: StoriesOnClickCallBack?):
    ListAdapter<Story, StoriesListAdapter.StoriesListViewHolder>(StoriesDiffCallback()) {


    private class StoriesDiffCallback : DiffUtil.ItemCallback<Story>() {
        override fun areItemsTheSame(oldItem: Story, newItem: Story) =
            oldItem.ChapterTitle == newItem.ChapterTitle

        override fun areContentsTheSame(oldItem: Story, newItem: Story) =
            oldItem == newItem

    }

    inner class StoriesListViewHolder(
        val binding: RecyclerviewStoriesViewLayoutBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bindView(story: Story?) {
            binding.storyName.text = story?.ChapterTitleEnglish
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
        fun onSelectedStory(story: Story?)
    }
}