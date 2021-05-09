package com.example.testapp.ui.signup

import android.util.Patterns
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.core.Success
import com.example.core.Loading
import com.example.core.Error
import com.example.testapp.R
import com.example.testapp.base.ViewBindingFragment
import com.example.testapp.databinding.FragmentSignUpBinding
import com.example.testapp.utils.gone
import com.example.testapp.utils.show

class SignUpFragment : ViewBindingFragment<FragmentSignUpBinding>() {

    private val viewModel: SignUpViewModel by viewModels()

    override fun resolveBinding(): FragmentSignUpBinding {
        return FragmentSignUpBinding.inflate(layoutInflater)
    }

    override fun onViewReady() {

        viewModel.signUpLiveData.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Success -> {
                    binding.progress.gone()
                    navigateTo(R.id.action_signUpFragment_to_homeFragment)
                }
                is Loading -> {
                    binding.progress.show()
                }
                is Error -> {
                    binding.progress.gone()
                }
            }
        })

        binding.btnSignUp.setOnClickListener {
            it.isEnabled = false
            viewModel.signUp(
                binding.eName.text.toString(),
                binding.eEmail.text.toString()
            )
        }

        binding.eName.doOnTextChanged { _, _, _, _ ->
            handleButtonState()
        }
        binding.eEmail.doOnTextChanged { _, _, _, _ ->
            handleButtonState()
        }
    }

    private fun handleButtonState() {
        binding.btnSignUp.isEnabled =
            !binding.eName.text.isNullOrEmpty() && binding.eEmail.text.isValidEmail()
    }

    private fun CharSequence?.isValidEmail() =
        !this.isNullOrEmpty() && Patterns.EMAIL_ADDRESS.matcher(this).matches()

}