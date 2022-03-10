package com.example.computerorder.presentation.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.computerorder.R
import com.example.computerorder.presentation.models.Order
import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import kotlinx.android.synthetic.main.fragment_all_data.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class ShowAllDataFragment : Fragment(R.layout.fragment_all_data) {

    companion object {
        const val TAG = "ShowAllDataFragment"
        fun newInstance() = ShowAllDataFragment()
    }

    private val dataSharedViewModel: DataSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFields()
        order()
    }

    @SuppressLint("SetTextI18n")
    private fun initFields() {
        dataSharedViewModel.accessory.observe(viewLifecycleOwner) {
            dataSharedViewModel.apply {
                nameUserTV.text = "${user.value?.firstName} ${user.value?.lastName}"
                phoneNumberTV.text = user.value?.phoneNumber
                operationSystemTV.text = operationSystem.value?.operationSystemTitle.toString()
                graphicCardTV.text = graphicCards.value.toString()
                monitorTV.text = monitors.value.toString()
                mouseTV.text = accessory.value?.mouse
                keyboardTV.text = accessory.value?.keyBoard
                webCumTV.text = accessory.value?.webCum
            }
        }
    }

    private fun order() {
        orderButton.setOnClickListener {
            sendEmail(createOrderObject())
        }
    }

    private fun sendEmail(order: Order) {
        val intent = Intent(Intent.ACTION_SEND).apply {
            order.apply {
                data = Uri.parse("mailto:")
                type = "text/plain"
                putExtra(Intent.EXTRA_SUBJECT, userName)
                putExtra(
                    Intent.EXTRA_TEXT,
                    order.toString()
                )
            }
        }
        startActivity(Intent.createChooser(intent, "Choose Email Client"))
    }

    private fun createOrderObject(): Order {
        dataSharedViewModel.apply {
            return Order(
                userName = "${user.value?.firstName} ${user.value?.lastName}",
                phoneNumber = user.value?.phoneNumber,
                operationSystem = operationSystem.value?.operationSystemTitle.toString(),
                graphicCard = graphicCards.value.toString(),
                monitor = monitors.value.toString(),
                mouse = accessory.value?.mouse,
                keyBoard = accessory.value?.keyBoard,
                webCum = accessory.value?.webCum
            )
        }
    }
}