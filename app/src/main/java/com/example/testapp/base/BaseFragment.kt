package com.example.testapp.base

import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
abstract class BaseFragment : Fragment() {

    fun navigateTo(id: Int) {
        Navigation.findNavController(requireView()).navigate(id)
    }
}