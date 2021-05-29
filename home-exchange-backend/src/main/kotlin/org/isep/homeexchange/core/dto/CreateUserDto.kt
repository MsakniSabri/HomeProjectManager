package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.UserDao

data class CreateUserDto(
    val id: Long,
    val email: String,
    val password: String,
    val phoneNumber: String?,
    val firstname: String,
    val lastname: String,
) {
}

fun CreateUserDto.toDao(): UserDao = UserDao(
    id = id,
    email = email,
    password = password,
    phoneNumber = phoneNumber,
    firstname = firstname,
    lastname = lastname,
    profilePictureUrl = null,
    admin = false,
    housings = emptyList(),
)