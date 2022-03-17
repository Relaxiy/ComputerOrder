package com.example.recycler.fragment

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler.R
import com.example.recycler.models.Assign
import com.example.recycler.reycler.BaseAdapter
import com.example.recycler.reycler.assignRecycler.AssignAdapter
import com.example.recycler.viewModel.AssignViewModel
import com.example.recycler.viewModel.RecyclerFragmentViewModel

class RecyclerFragment : Fragment(R.layout.fragment_recycler) {
    companion object {
        const val TAG = "RecyclerFragment"
        fun newInstance() = RecyclerFragment()
    }

    private val recyclerFragmentViewModel = RecyclerFragmentViewModel()

    private val assignViewModel = AssignViewModel()
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