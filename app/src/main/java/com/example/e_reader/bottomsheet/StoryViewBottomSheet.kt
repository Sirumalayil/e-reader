package com.example.e_reader.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_reader.R
import com.example.e_reader.databinding.LayoutStoryviewBottomsheetBinding
import com.example.e_reader.model.Content
import com.example.e_reader.model.Story
import com.example.e_reader.utils.FragmentCallBack
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
 * Create by Sirumalayil on 03-02-2023.
 */
class StoryViewBottomSheet: BottomSheetDialogFragment() {

    private var binding: LayoutStoryviewBottomsheetBinding? = null
    private var callback: FragmentCallBack? = null
    private var story: Story? = null

    fun newInstance(story: Story?, callback: FragmentCallBack) = StoryViewBottomSheet().apply {
        this.callback = callback
        this.story = story
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutStoryviewBottomsheetBinding.inflate(
            inflater,container,false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setViewData()

        binding?.btnReadNow?.setOnClickListener {
            dismissAllowingStateLoss()
            callback?.onResult(story)
        }
    }

    private fun setViewData() {
        binding?.storyTitle?.text = story?.ChapterTitleEnglish
        binding?.textStoryContent?.text = getContent()
    }

    private fun getContent(): String? {
        return story?.contentsLex?.joinToString(",") { it.Content.English }
    }


    override fun getTheme(): Int = R.style.CustomBottomSheetDialogTheme
}