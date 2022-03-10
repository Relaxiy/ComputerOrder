package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.presentation.amountRecycler.AmountAdapter
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

    private val amountAdapter by lazy {
        AmountAdapter { editText ->
            openBottomFragment(editText)
        }
    }

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.monitorRecycler)
    }

    private fun initRecycler() {
        recycler?.adapter = amountAdapter
        dataSharedViewModel.amount.observe(viewLifecycleOwner) { amount ->
            amountAdapter.setAmount(amount)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun setItem(monitor: Any, editText: EditText) {
        val monitorSet = monitor as Monitor
        editText.setText(monitorSet.monitorTitle)
        dataSharedViewModel.setMonitor(monitorSet.monitorTitle)
        initField()
    }

    private fun openBottomFragment(editText: EditText) {
        val bottomFragment = ItemsBottomFragment.newInstance(TypeObj.MONITOR) { monitor ->
            setItem(monitor, editText)
        }
        bottomFragment.show(
            requireActivity().supportFragmentManager,
            ItemsBottomFragment.TAG
        )
    }

    private fun initField() {
        toAccessory.setOnClickListener {
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