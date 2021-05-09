package com.example.data

import com.example.core.Result
import com.example.data.models.SignUpModel

interface ISignUpRepository {
    suspend fun signUpUser(model: SignUpModel): Result<Unit>
}