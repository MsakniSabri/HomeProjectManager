package org.isep.homeexchange.core.dto

import com.fasterxml.jackson.annotation.JsonProperty
import org.isep.homeexchange.infrastructure.dao.UserDao

data class CreateUserDto(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String,
    @JsonProperty("phoneNumber") val phoneNumber: String?,
    @JsonProperty("firstname") val firstname: String,
    @JsonProperty("lastname") val lastname: String,
)

fun CreateUserDto.toDao(): UserDao = UserDao(
    email = email,
    password = password,
    phoneNumber = phoneNumber,
    firstname = firstname,
    lastname = lastname,
    profilePictureUrl = null,
    admin = false,
    housings = emptyList(),
)