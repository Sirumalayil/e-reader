package com.example.e_reader.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.e_reader.StoriesListAdapter
import com.example.e_reader.bottomsheet.StoryViewBottomSheet
import com.example.e_reader.databinding.FragmentHomeBinding
import com.example.e_reader.extensions.navigate
import com.example.e_reader.model.Stories
import com.example.e_reader.utils.FragmentCallBack

/**
 * Create by Sirumalayil on 31-01-2023.
 */
class HomeFragment: Fragment() {

    private var binding: FragmentHomeBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initializeAdapter()
    }

    /**
     * Story list will show here as a recycler listview
     * As of now its we are showing dummy data for functionality
     */
    private fun initializeAdapter() {
        val listStories = mutableListOf(
            Stories("Do It Today"),
            Stories("Do It Today"),
            Stories("Do It Today"),
            Stories("Do It Today"),
            Stories("Do It Today")
        )
        val storiesAdapter = StoriesListAdapter(
            object : StoriesListAdapter.StoriesOnClickCallBack {
                override fun onSelectedStory(story: Stories?) {
                    showStoryViewBottomSheet(story)
                }
            }
        )
        binding?.reyclerviewMain?.apply {
            adapter = storiesAdapter
        }
        storiesAdapter.submitList(listStories)
    }

    /**
     * @see showStoryViewBottomSheet will appear as a bottom sheet after
     * user selecting story from list
     */
    private fun showStoryViewBottomSheet(story: Stories?) {
        StoryViewBottomSheet()
            .newInstance(story, object : FragmentCallBack {
                override fun onResult(param1: Any?, param2: Any?, param3: Any?) {
                    showStoryViewScreen(param1 as? Stories)
                }
            })
            .show(activity?.supportFragmentManager!!, StoryViewBottomSheet::class.java.name)
    }

    private fun showStoryViewScreen(stories: Stories?) {
        (activity as? AppCompatActivity)?.navigate(
            fragment = StoryFragment()
        )
    }
}
