package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.computerorder.R
import com.example.computerorder.domain.models.OperationSystem
import com.example.computerorder.presentation.ext.dialog
import com.example.computerorder.presentation.ext.openFragment
import com.example.computerorder.presentation.models.TypeObj
import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import kotlinx.android.synthetic.main.fragment_change_operation_system.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChangeOperationSystemFragment : Fragment(R.layout.fragment_change_operation_system) {

    companion object {
        const val TAG = "OperationSystemFragment"
        fun newInstance() = ChangeOperationSystemFragment()
    }

    private val dataSharedViewModel: DataSharedViewModel by sharedViewModel()

    private fun setItem(operationSystem: Any) {
        val operationSystemSet = operationSystem as OperationSystem
        operationSystemInput.setText(operationSystemSet.operationSystemTitle)
        dataSharedViewModel.setOperationSystem(operationSystemSet)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initField()
    }

    private fun initField() {
        operationSystemInput.setOnClickListener {
            val bottomFragment =
                ItemsBottomFragment.newInstance(TypeObj.OPERATION_SYSTEM) { operationSystem ->
                    setItem(operationSystem)
                }
            bottomFragment.show(
                requireActivity().supportFragmentManager,
                ItemsBottomFragment.TAG
            )
        }

        toGraphicCardFragment.setOnClickListener {
            if (operationSystemInput.text.isEmpty()) {
                requireActivity().dialog()
            } else {
                requireActivity().apply {
                    openFragment(
                        ChangeGraphicCardFragment.TAG,
                        ChangeGraphicCardFragment.newInstance(),
                        R.id.container
                    )
                }
            }
        }
    }
}