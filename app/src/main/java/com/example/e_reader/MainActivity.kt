package com.example.e_reader

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.e_reader.databinding.ActivityMainBinding
import com.example.e_reader.fragments.HomeFragment

/**
 * Create by Sirumalayil on 01-02-2023.
 */
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)


        if (savedInstanceState == null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container,HomeFragment())
                .commit()
        }
    }
}