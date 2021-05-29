package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.CreateUserDto
import org.isep.homeexchange.core.dto.UserDto

interface UserService {
    fun create(dto: CreateUserDto): UserDto
    fun getById(id: Long): UserDto
    fun updateUser(dto: UserDto, password: String ?): UserDto
    fun deleteById(id: Long)
    fun deleteAll()
}