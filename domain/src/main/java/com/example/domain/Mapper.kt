package com.example.domain

import com.example.domain.model.SignUpModel

fun SignUpModel.toDataModel() = com.example.data.models.SignUpModel(
    name = this.name,
    email = this.email
)