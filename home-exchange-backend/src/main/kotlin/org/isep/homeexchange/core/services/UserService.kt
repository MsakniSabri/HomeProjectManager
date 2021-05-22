package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.UserDto

interface UserService {
    fun getById(id: Long): UserDto
}