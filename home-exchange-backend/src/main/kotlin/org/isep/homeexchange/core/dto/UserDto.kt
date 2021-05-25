package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.UserDao

data class UserDto(
    val id: Long,
    val email: String,
    val phoneNumber: String?,
    val firstname: String,
    val lastname: String,
    val profilePictureUrl: String?,
    val admin: Boolean,
    val
    housings: List<HousingDto>
) {
}

fun UserDto.toDao(): UserDao = UserDao(
    id = id,
    email = email,
    password = null,
    phoneNumber = phoneNumber,
    firstname = firstname,
    lastname = lastname,
    profilePictureUrl = profilePictureUrl,
    admin = admin,
    housings = housings.toDao(),
)

