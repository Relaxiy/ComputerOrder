package com.example.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recycler.presentation.ext.openFragment
import com.example.recycler.presentation.fragment.RecyclerFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        openFragment(RecyclerFragment.TAG, RecyclerFragment.newInstance(), R.id.container)
    }
}