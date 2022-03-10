package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.computerorder.R
import com.example.computerorder.presentation.ext.dialog
import com.example.computerorder.presentation.ext.openFragment
import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import kotlinx.android.synthetic.main.fragment_change_amount_graphic_card.*
import kotlinx.android.synthetic.main.fragment_change_amount_monitor.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChangeAmountMonitorFragment : Fragment(R.layout.fragment_change_amount_monitor) {
    companion object {
        const val TAG = "ChangeAmountMonitorFragment"
        fun newInstance() = ChangeAmountMonitorFragment()
    }

    private val dataSharedViewModel: DataSharedViewModel by sharedViewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initField()
    }

    private fun initField() {
        toMonitors.setOnClickListener {
            if (monitorsAmount.text.isEmpty()) {
                requireActivity().dialog()
            } else if (monitorsAmount.text.toString().toInt() == 0) {
                requireActivity().apply {
                    openFragment(
                        ChangeAccessoryFragment.TAG,
                        ChangeAccessoryFragment.newInstance(),
                        R.id.container
                    )
                }
            } else {
                dataSharedViewModel.setAmount(monitorsAmount.text.toString().toInt())
                requireActivity().apply {
                    openFragment(
                        ChangeMonitorFragment.TAG,
                        ChangeMonitorFragment.newInstance(),
                        R.id.container
                    )
                }
            }
        }
    }
}