package com.example.testapp.ui.home

import com.example.testapp.base.BaseFragment
import com.example.testapp.base.ViewBindingFragment
import com.example.testapp.databinding.FragmentHomeBinding

class HomeFragment : ViewBindingFragment<FragmentHomeBinding>() {

    override fun onViewReady() {
        // nothing
    }

    override fun resolveBinding(): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }
}