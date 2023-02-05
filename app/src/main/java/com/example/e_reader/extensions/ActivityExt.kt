package com.example.e_reader.extensions

import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.e_reader.R


fun AppCompatActivity.navigate(
    fragment: Fragment
) {
    val rootView: ViewGroup = findViewById(android.R.id.content)
    val container = rootView.findViewById<FrameLayout>(R.id.container)
        ?: throw Throwable("Activity FrameLayout id needs to be \"container\"")

    supportFragmentManager.beginTransaction()
        .add(
            container.id,
            fragment,
            fragment.tag
        )
        .addToBackStack(fragment.javaClass.simpleName)
        .commitAllowingStateLoss()
}