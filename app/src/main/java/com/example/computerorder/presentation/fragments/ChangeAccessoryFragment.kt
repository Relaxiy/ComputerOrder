package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.computerorder.R
import com.example.computerorder.domain.models.Accessory
import com.example.computerorder.presentation.ext.openFragment
import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import kotlinx.android.synthetic.main.fragment_change_accessory.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChangeAccessoryFragment : Fragment(R.layout.fragment_change_accessory) {

    companion object {
        const val TAG = "ChangeAccessoryFragment"
        fun newInstance() = ChangeAccessoryFragment()
    }

    private val dataSharedViewModel: DataSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFields()
    }

    private fun initFields() {
        toAllData.setOnClickListener {
            var mouseTitle: String? = null
            var keyBoardTitle: String? = null
            var webCumTitle: String? = null
            if (mouseCheckBox.isChecked) {
                mouseTitle = mouseOutput.text.toString()
            }
            if (keyboardCheckBox.isChecked) {
                keyBoardTitle = keyboardOutput.text.toString()
            }
            if (webCamCheckBox.isChecked) {
                webCumTitle = webCumOutput.text.toString()
            }

            dataSharedViewModel.setAccessory(
                createAccessory(
                    mouseTitle,
                    keyBoardTitle,
                    webCumTitle
                )
            )

            requireActivity().apply {
                openFragment(
                    ShowAllDataFragment.TAG,
                    ShowAllDataFragment.newInstance(),
                    R.id.container
                )
            }
        }
    }

    private fun createAccessory(
        mouseTitle: String?,
        keyBoardTitle: String?,
        webCumTitle: String?
    ): Accessory {
        return Accessory(
            mouse = mouseTitle,
            keyBoard = keyBoardTitle,
            webCum = webCumTitle
        )
    }

}