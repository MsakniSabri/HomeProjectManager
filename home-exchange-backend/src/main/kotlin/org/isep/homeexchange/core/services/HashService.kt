package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.LoginDto

interface HashService {
    fun hashPassword(password: String): String
    fun verifyPassword(dto: LoginDto): Boolean
}