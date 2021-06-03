package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.CreateUserDto
import org.isep.homeexchange.core.dto.LoginDto
import org.isep.homeexchange.core.dto.UserDto

interface AuthService {
    fun register(dto: CreateUserDto): UserDto
    fun login(dto: LoginDto): UserDto
}