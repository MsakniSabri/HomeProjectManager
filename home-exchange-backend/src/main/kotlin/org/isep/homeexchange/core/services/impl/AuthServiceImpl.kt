package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.CreateUserDto
import org.isep.homeexchange.core.dto.LoginDto
import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.AuthService
import org.isep.homeexchange.infrastructure.dao.toUserDto
import org.isep.homeexchange.infrastructure.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.server.ResponseStatusException

@Service
@Transactional
class AuthServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
) : AuthService {

    override fun register(dto: CreateUserDto): UserDto {
        if (userRepository.existsByEmail(dto.email)) {
            throw ResponseStatusException(HttpStatus.CONFLICT, "Email already used")
        }

        val userDao = dto.toDao()
        userDao.password = passwordEncoder.encode(dto.password)

        return userRepository.save(userDao).toUserDto()
    }

    override fun login(dto: LoginDto): UserDto {
        val user = userRepository.findByEmail(dto.email)

        if (user.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Account doesn't exist")
        }

        if (!passwordEncoder.matches(dto.password, user.get().password)) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED, "Password doesn't match")
        }

        return user.get().toUserDto()
    }
}