package com.br.api.api.domain.dtos


data class UserRequest(
    val email: String,
    val password: String,
    val fullName: String
)
