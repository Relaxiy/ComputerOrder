package com.example.computerorder.presentation.ext

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import com.example.computerorder.presentation.dialog.LoginDialog

fun FragmentActivity.openFragment(tag: String, fragment: Fragment, fragmentId: Int) {
    supportFragmentManager
        .beginTransaction()
        .replace(fragmentId, fragment, tag)
        .addToBackStack(tag)
        .commit()
}

fun FragmentActivity.dialog() {
    val myDialogFragment = LoginDialog()
    val manager = supportFragmentManager
    myDialogFragment.show(manager, "myDialog")
}

