package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.computerorder.R
import com.example.computerorder.presentation.ext.dialog
import com.example.computerorder.presentation.ext.openFragment
import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import kotlinx.android.synthetic.main.fragment_change_amount_graphic_card.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChangeAmountGraphicCardFragment : Fragment(R.layout.fragment_change_amount_graphic_card) {

    companion object {
        const val TAG = "ChangeAmountGraphicCardFragment"
        fun newInstance() = ChangeAmountGraphicCardFragment()
    }

    private val dataSharedViewModel: DataSharedViewModel by sharedViewModel()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initField()
    }

    private fun initField() {
        toGraphicCards.setOnClickListener {
            if (graphicCardsAmount.text.isEmpty()) {
                requireActivity().dialog()
            } else if (graphicCardsAmount.text.toString().toInt() == 0) {
                requireActivity().apply {
                    openFragment(
                        ChangeAmountMonitorFragment.TAG,
                        ChangeAmountMonitorFragment.newInstance(),
                        R.id.container
                    )
                }
            } else {
                dataSharedViewModel.setAmount(graphicCardsAmount.text.toString().toInt())
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