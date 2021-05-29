package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.LoginDto

interface HashService {
    fun hashingPassword(password: String): String
    fun checkPassword(dto: LoginDto): Boolean
}