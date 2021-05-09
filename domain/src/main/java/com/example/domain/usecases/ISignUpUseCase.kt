package com.example.domain.usecases

import com.example.core.Result
import com.example.domain.model.SignUpModel

interface ISignUpUseCase {
    suspend fun signUpUser(model: SignUpModel): Result<Unit>
}