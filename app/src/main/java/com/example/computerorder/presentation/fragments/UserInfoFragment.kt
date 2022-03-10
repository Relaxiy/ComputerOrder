package com.example.computerorder.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.computerorder.R
import com.example.computerorder.domain.models.User
import com.example.computerorder.presentation.ext.dialog
import com.example.computerorder.presentation.ext.openFragment
import com.example.computerorder.presentation.viewModels.DataSharedViewModel
import kotlinx.android.synthetic.main.fragment_user_info.*
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class UserInfoFragment : Fragment(R.layout.fragment_user_info) {

    companion object {
        const val TAG = "UserInfoFragment"
        fun newInstance() = UserInfoFragment()
    }

    private val dataSharedViewModel: DataSharedViewModel by sharedViewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initFields()
    }

    private fun initFields() {
        toOsFragment.setOnClickListener {
            if (firstNameInput.text.isEmpty() ||
                lastNameInput.text.isEmpty() ||
                phoneNumberInput.text.isEmpty() ||
                phoneNumberInput.text.toString().length < 7
            ) {
                requireActivity().dialog()
            } else {
                val user = createUser()
                dataSharedViewModel.setUser(user)
                requireActivity().apply {
                    openFragment(
                        ChangeOperationSystemFragment.TAG,
                        ChangeOperationSystemFragment.newInstance(),
                        R.id.container
                    )
                }
            }
        }
    }

    private fun createUser(): User {
        return User(
            firstName = firstNameInput.text.toString(),
            lastName = lastNameInput.text.toString(),
            phoneNumber = phoneNumberInput.text.toString()
        )
    }
}