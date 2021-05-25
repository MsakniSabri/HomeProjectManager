package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.services.UserService
import org.isep.homeexchange.infrastructure.dao.UserDao
import org.isep.homeexchange.infrastructure.dao.toDto
import org.isep.homeexchange.infrastructure.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class UserServiceImpl(private val userRepository: UserRepository) : UserService {
    override fun getById(id: Long): UserDto {
        val user: Optional<UserDao> = userRepository.findById(id);

        if (user.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
        }

        return user.get().toDto()
    }
}