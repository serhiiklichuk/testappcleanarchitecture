package com.example.testapp.ui.signup

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.Loading
import com.example.core.Result
import com.example.domain.model.SignUpModel
import com.example.domain.usecases.ISignUpUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val signUpUseCase: ISignUpUseCase
) : ViewModel() {

    private val signUpMutableLiveData = MutableLiveData<Result<Unit>>()
    val signUpLiveData: LiveData<Result<Unit>>
        get() = signUpMutableLiveData

    fun signUp(username: String, password: String) {
        signUpMutableLiveData.value = Loading
        viewModelScope.launch {
            signUpMutableLiveData.setValue(signUpUseCase.signUpUser(SignUpModel(username, password)))
        }
    }
}