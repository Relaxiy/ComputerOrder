package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.computerorder.R
import com.example.computerorder.domain.models.GraphicCard
import com.example.computerorder.domain.models.Monitor
import com.example.computerorder.domain.models.OperationSystem
import com.example.computerorder.presentation.models.TypeObj
import com.example.computerorder.presentation.recycler.GeneralAdapter
import com.example.computerorder.presentation.viewModels.ItemsBottomFragmentViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ItemsBottomFragment(
    private val type: TypeObj,
    private val send: (item: Any) -> Unit
) : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_bottom, container, false)

    companion object {
        const val TAG = "ItemsBottomFragment"
        fun newInstance(type: TypeObj, send: (Any) -> Unit) = ItemsBottomFragment(type, send)
    }

    private fun saveText(item: Any) {
        send(item)
        dismiss()
    }

    private val itemsBottomFragmentViewModel: ItemsBottomFragmentViewModel by viewModel()

    private val recycler by lazy { view?.findViewById<RecyclerView>(R.id.bottom_recycle) }

    private val graphicCardAdapter = object : GeneralAdapter<GraphicCard>({ graphicCard ->
        saveText(graphicCard)
    }) {
        override fun getLayoutId(position: Int, obj: GraphicCard): Int =
            R.layout.fragment_change_graphic_card
    }

    private val operationSystemAdapter = object : GeneralAdapter<OperationSystem>({ operationSystem ->
        saveText(operationSystem)
    }) {
        override fun getLayoutId(position: Int, obj: OperationSystem): Int =
            R.layout.fragment_change_operation_system
    }


    private val monitorAdapter = object : GeneralAdapter<Monitor>({ monitor ->
        saveText(monitor)
    }) {
        override fun getLayoutId(position: Int, obj: Monitor): Int =
            R.layout.fragment_change_monitor
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        when (type) {
            TypeObj.OPERATION_SYSTEM -> operationSystemObserve()
            TypeObj.GRAPHIC_CARD -> graphicCardObserve()
            TypeObj.MONITOR -> monitorObserve()
        }
    }

    private fun operationSystemObserve() {
        recycler?.adapter = operationSystemAdapter
        itemsBottomFragmentViewModel.operationSystem.observe(viewLifecycleOwner) {
            operationSystemAdapter.setItems(it)
        }
    }

    private fun graphicCardObserve() {
        recycler?.adapter = graphicCardAdapter
        itemsBottomFragmentViewModel.graphicCard.observe(viewLifecycleOwner) {
            graphicCardAdapter.setItems(it)
        }
    }

    private fun monitorObserve() {
        recycler?.adapter = monitorAdapter
        itemsBottomFragmentViewModel.monitors.observe(viewLifecycleOwner) {
            monitorAdapter.setItems(it)
        }
    }

}