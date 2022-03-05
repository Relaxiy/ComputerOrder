package com.example.computerorder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.computerorder.presentation.ext.openFragment
import com.example.computerorder.presentation.fragments.UserInfoFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()

        openFragment(UserInfoFragment.TAG, UserInfoFragment.newInstance(), R.id.container)
    }
}