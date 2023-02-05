package com.example.e_reader.fragments

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.RelativeSizeSpan
import android.text.style.TypefaceSpan
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.example.e_reader.R
import com.example.e_reader.bottomsheet.TextCustomizationBottomSheet
import com.example.e_reader.databinding.FragmentStoryBinding
import com.example.e_reader.utils.FragmentCallBack
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlin.math.max
import kotlin.math.min


class StoryFragment: Fragment() {

    private var binding: FragmentStoryBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentStoryBinding.inflate(inflater, container, false)
        return binding?.root
    }


    @SuppressLint("ClickableViewAccessibility")
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFirstLetterEnlarge()

        customTextViewSelectionCallback()

        onClickListener()

    }

    private fun onClickListener() {
        binding?.cardViewBackNav?.setOnClickListener {
            activity?.supportFragmentManager?.popBackStack()
        }

        binding?.viewTextCustomize?.setOnClickListener {
            showTextCustomizationView()
        }
    }

    /**
     * @see showTextCustomizationView for handling text size, font and theme changing
     * //TODO yet to complete
     */
    private fun showTextCustomizationView() {
        TextCustomizationBottomSheet()
            .newInstance(object : FragmentCallBack {
                override fun onResult(param1: Any?, param2: Any?, param3: Any?) {}
            }).show(
                activity?.supportFragmentManager!!,
                TextCustomizationBottomSheet::class.java.name
            )
    }

    /**
     * @see customTextViewSelectionCallback will handle selection process
     * customSelectionActionModeCallback native selection callback
     */
    private fun customTextViewSelectionCallback() {
        binding?.textStory?.customSelectionActionModeCallback = object : ActionMode.Callback {
            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                menu?.clear()
                showCustomSelectionActionModeAlert(mode)
                return false
            }
            override fun onPrepareActionMode(p0: ActionMode?, menu: Menu?): Boolean { return false }
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean { return true }
            override fun onDestroyActionMode(p0: ActionMode?) { } }
    }

    /**
     * @see mode is the ActionMode for handling user selection and
     * will show custom alert dialog also here based on the selected text content
     */
    private fun showCustomSelectionActionModeAlert(mode: ActionMode?) {
        activity?.let { activity ->
            val view: View = LayoutInflater.from(activity).inflate(
                R.layout.custom_dialog_view,
                activity.findViewById(R.id.custom_alert_dialog) as? ConstraintLayout?
            )
            val dialog = MaterialAlertDialogBuilder(activity, R.style.AlertDialogTheme)
                .setView(view)
                .setCancelable(false)
                .create()
            val close = view.findViewById<ImageView>(R.id.ic_close)
            val textViewSelection = view.findViewById<TextView>(R.id.selected_text)
            close.setOnClickListener {
                dialog.hide()
            }
            if (dialog.window != null){
                dialog.window?.setBackgroundDrawable(ColorDrawable(0))
            }
            dialog.show()
            setSelectionText(textViewSelection)
            mode?.finish()
        }

    }

    /**
     * @see textViewSelection is the textview for displaying user
     * selected text content need to show
     */
    private fun setSelectionText(textViewSelection: TextView?) {
        var min = 0
        var max: Int? = binding?.textStory?.text?.length
        if (binding?.textStory?.isFocused == true) {
            val selStart: Int? = binding?.textStory?.selectionStart
            val selEnd: Int? = binding?.textStory?.selectionEnd
            min = 0.coerceAtLeast(min(selStart!!, selEnd!!))
            max = 0.coerceAtLeast(max(selStart, selEnd))
        }
        // Perform your definition lookup with the selected text
        val selectedText: CharSequence? = binding?.textStory?.text?.subSequence(min, max!!)
        textViewSelection?.text = selectedText
    }

    /**
     *
     */
    @RequiresApi(Build.VERSION_CODES.P)
    private fun setFirstLetterEnlarge() {
        val fLetter = getString(R.string.lorem_ipsum_random).substring(0,1).uppercase()
        val typeface= Typeface.create(ResourcesCompat.getFont(requireActivity(), R.font.lusitana_700), Typeface.NORMAL)
        val spannableString = SpannableString(fLetter +
        getString(R.string.lorem_ipsum_random).substring(1))
        spannableString.setSpan(
            TypefaceSpan(typeface),0,1,Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            RelativeSizeSpan(5f),0,1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
        )
        spannableString.setSpan(
            ForegroundColorSpan(Color.BLACK), 0, 1, 0
        )
        binding?.textStory?.setText(spannableString, TextView.BufferType.SPANNABLE)
    }
}