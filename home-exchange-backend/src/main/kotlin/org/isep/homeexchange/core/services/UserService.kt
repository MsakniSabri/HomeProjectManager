package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.CreateUserDto
import org.isep.homeexchange.core.dto.LoginDto
import org.isep.homeexchange.core.dto.UserDto

interface UserService {
    fun create(dto: CreateUserDto): UserDto
    fun getById(id: Long): UserDto
    fun getByEmail(email: String): LoginDto
    fun updateUser(dto: UserDto, password: String ?): UserDto
    fun deleteById(id: Long)
    fun deleteAll()
    fun login(dto: LoginDto): Boolean
}