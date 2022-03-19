package com.example.recycler.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.R
import com.example.recycler.domain.models.Assign
import com.example.recycler.presentation.reycler.BaseAdapter
import com.example.recycler.presentation.reycler.assignRecycler.AssignAdapter
import com.example.recycler.presentation.viewModel.AssignViewModel
import com.example.recycler.presentation.viewModel.RecyclerFragmentViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class RecyclerFragment : Fragment(R.layout.fragment_recycler) {
    companion object {
        const val TAG = "RecyclerFragment"
        fun newInstance() = RecyclerFragment()
    }

    private val recyclerFragmentViewModel: RecyclerFragmentViewModel by viewModel()

    private val assignViewModel: AssignViewModel by viewModel()

    private val recycler by lazy {
        view?.findViewById<RecyclerView>(R.id.main_recycler)
    }

    private val adapter by lazy {
        BaseAdapter { adapter, assign ->
            initAssignRecycler(adapter, assign)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initAssignRecycler(assignAdapter: AssignAdapter, assign: Assign) {
        assignViewModel.setItem(assign)
        assignViewModel.items.observe(viewLifecycleOwner) {
            assignAdapter.setItems(it)
        }
    }

    private fun initRecycler() {
        recycler?.adapter = adapter
        recyclerFragmentViewModel.items.observe(viewLifecycleOwner) {
            adapter.setItems(it)
        }
    }
}