package org.isep.homeexchange.core.dto

data class LoginDto(
    val email: String,
    val hashedPassword: String,
)