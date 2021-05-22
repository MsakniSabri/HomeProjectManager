package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.UserDao

data class UserDto(val id: Long) {
}

fun UserDto.toDao(): UserDao = UserDao(
    id = id
)