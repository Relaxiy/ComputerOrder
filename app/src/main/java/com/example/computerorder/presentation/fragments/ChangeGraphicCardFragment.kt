package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.computerorder.R
import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.presentation.ext.dialog
import com.example.computerorder.presentation.ext.openFragment
import com.example.computerorder.presentation.models.TypeObj
import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import kotlinx.android.synthetic.main.fragment_change_graphic_card.*
import kotlinx.android.synthetic.main.fragment_change_operation_system.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ChangeGraphicCardFragment : Fragment(R.layout.fragment_change_graphic_card) {

    companion object {
        const val TAG = "GraphicCardChangeFragment"
        fun newInstance() = ChangeGraphicCardFragment()
    }

    private val dataSharedViewModel: DataSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initField()
    }

    private fun setItem(graphicCard: Any) {
        val graphicCardSet = graphicCard as GraphicCard
        graphicCardInput.setText(graphicCardSet.graphicCardTitle)
        dataSharedViewModel.setGraphicCard(graphicCardSet)
    }

    private fun initField() {
        graphicCardInput.setOnClickListener {
            val bottomFragment =
                ItemsBottomFragment.newInstance(TypeObj.GRAPHIC_CARD) { graphicCard ->
                    setItem(graphicCard)
                }
            bottomFragment.show(
                requireActivity().supportFragmentManager,
                ItemsBottomFragment.TAG
            )
        }

        toMonitorFragment.setOnClickListener {
            if (graphicCardInput.text.isEmpty()) {
                requireActivity().dialog()
            } else {
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