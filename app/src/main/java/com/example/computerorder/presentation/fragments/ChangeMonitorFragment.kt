package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.computerorder.R
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.presentation.ext.dialog
import com.example.computerorder.presentation.ext.openFragment
import com.example.computerorder.presentation.models.TypeObj
import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import kotlinx.android.synthetic.main.fragment_change_monitor.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChangeMonitorFragment : Fragment(R.layout.fragment_change_monitor) {

    companion object {
        const val TAG = "ChangeMonitorFragment"
        fun newInstance() = ChangeMonitorFragment()
    }

    private val dataSharedViewModel: DataSharedViewModel by sharedViewModel()

    private fun setItem(monitor: Any) {
        val monitorSet = monitor as Monitor
        monitorInput.setText(monitorSet.monitorTitle)
        dataSharedViewModel.setMonitor(monitor)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initField()
    }

    private fun initField() {
        monitorInput.setOnClickListener {
            val bottomFragment = ItemsBottomFragment.newInstance(TypeObj.MONITOR) { monitor ->
                setItem(monitor)
            }
            bottomFragment.show(
                requireActivity().supportFragmentManager,
                ItemsBottomFragment.TAG
            )
        }

        toAccessoryFragment.setOnClickListener {
            if (monitorInput.text.isEmpty()) {
                requireActivity().dialog()
            } else {
                requireActivity().apply {
                    openFragment(
                        ChangeAccessoryFragment.TAG,
                        ChangeAccessoryFragment.newInstance(),
                        R.id.container
                    )
                }
            }
        }
    }

}