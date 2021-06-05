package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.LoginDto
import org.isep.homeexchange.core.services.HashService
import org.isep.homeexchange.core.services.UserService
import org.mindrot.jbcrypt.BCrypt
import org.springframework.stereotype.Service

@Service
class HashServiceImpl(
    private val userService: UserService,
): HashService{

    override fun hashPassword(password: String): String {
        return BCrypt.hashpw(password, BCrypt.gensalt(47))
    }

    override fun verifyPassword(dto: LoginDto): Boolean {
        val userDto: LoginDto = userService.getByEmail(dto.email)
        return BCrypt.checkpw(userDto.password, dto.password)
    }


}