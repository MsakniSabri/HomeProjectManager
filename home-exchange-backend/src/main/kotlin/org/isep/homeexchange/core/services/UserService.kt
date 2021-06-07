package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.UpdateUserDto
import org.isep.homeexchange.core.dto.UserDto

interface UserService {
    fun getById(id: Long): UserDto
    fun getByEmail(email: String): UserDto
    fun update(dto: UpdateUserDto): UserDto
    fun deleteById(id: Long)
}