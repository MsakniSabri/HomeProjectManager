package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.UserDao

data class UpdateUserDto(
    val id: Long,
    val email: String,
    val phoneNumber: String?,
    val password: String,
    val firstname: String,
    val lastname: String,
    val profilePictureUrl: String?,
    val admin: Boolean,
    val housings: List<HousingDto>
)

fun UpdateUserDto.toDao(): UserDao = UserDao(
    id = id,
    email = email,
    password = password,
    phoneNumber = phoneNumber,
    firstname = firstname,
    lastname = lastname,
    profilePictureUrl = profilePictureUrl,
    admin = admin,
    housings = housings.toDao(),
)