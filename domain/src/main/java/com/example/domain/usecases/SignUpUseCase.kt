package com.example.domain.usecases

import com.example.core.Result
import com.example.data.ISignUpRepository
import com.example.domain.model.SignUpModel
import com.example.domain.toDataModel
import javax.inject.Inject

class SignUpUseCase @Inject constructor(private val repository: ISignUpRepository) : ISignUpUseCase {

    override suspend fun signUpUser(model: SignUpModel): Result<Unit> {
        return repository.signUpUser(model.toDataModel())
    }
}