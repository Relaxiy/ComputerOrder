package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R
import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.presentation.amountRecycler.AmountAdapter
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
        initRecycler()
    }

    private val amountAdapter by lazy {
        AmountAdapter { editText ->
            openBottomFragment(editText)
        }
    }

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.graphicCardRecycler)
    }


    private fun initRecycler() {
        recycler?.adapter = amountAdapter
        dataSharedViewModel.amount.observe(viewLifecycleOwner) { amount ->
            amountAdapter.setAmount(amount)
        }
    }

    private fun setItem(graphicCard: Any, editText: EditText) {
        val graphicCardSet = graphicCard as GraphicCard
        editText.setText(graphicCardSet.graphicCardTitle)
        dataSharedViewModel.setGraphicCard(graphicCardSet.graphicCardTitle)
        initField()
    }

    private fun openBottomFragment(editText: EditText) {
        val bottomFragment =
            ItemsBottomFragment.newInstance(TypeObj.GRAPHIC_CARD) { graphicCard ->
                setItem(graphicCard, editText)
            }
        bottomFragment.show(
            requireActivity().supportFragmentManager,
            ItemsBottomFragment.TAG
        )
    }

    private fun initField() {
        toAmountMonitors.setOnClickListener {
            requireActivity().apply {
                openFragment(
                    ChangeAmountMonitorFragment.TAG,
                    ChangeAmountMonitorFragment.newInstance(),
                    R.id.container
                )
            }
        }
    }
}