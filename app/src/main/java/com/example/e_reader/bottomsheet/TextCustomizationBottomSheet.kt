package com.example.e_reader.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.e_reader.R
import com.example.e_reader.databinding.LayoutTextCustomizationBottomsheetBinding
import com.example.e_reader.utils.FragmentCallBack
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
/**
 * Create by Sirumalayil on 05-02-2023.
 */
class TextCustomizationBottomSheet: BottomSheetDialogFragment() {

    private var binding: LayoutTextCustomizationBottomsheetBinding? = null
    private var callback: FragmentCallBack? = null

    fun newInstance(callback: FragmentCallBack) = TextCustomizationBottomSheet().apply {

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LayoutTextCustomizationBottomsheetBinding.inflate(
            layoutInflater,container,false
        )
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun getTheme(): Int = R.style.CustomBottomSheetDialogTheme
}