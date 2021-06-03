package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.UserService
import org.isep.homeexchange.infrastructure.dao.UserDao
import org.isep.homeexchange.infrastructure.dao.toUserDto
import org.isep.homeexchange.infrastructure.repository.UserRepository
import org.springframework.http.HttpStatus
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun getById(id: Long): UserDto {
        val user: Optional<UserDao> = userRepository.findById(id);

        if (user.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
        }

        return user.get().toUserDto()
    }

    override fun getByEmail(email: String): UserDto {
        val user: Optional<UserDao> = userRepository.findByEmail(email)

        if (user.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
        }

        return user.get().toUserDto()
    }

    override fun update(dto: UserDto, password: String?): UserDto {
        val userDao = dto.toDao()

        if (!password.isNullOrEmpty()) {
            userDao.password = passwordEncoder.encode(password)
        } else {
            val user: Optional<UserDao> = userRepository.findById(userDao.id)
            if (user.isEmpty) {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
            }
            userDao.password = user.get().password
        }

        return userRepository.save(userDao).toUserDto()
    }

    override fun deleteById(id: Long) {
        val user: Optional<UserDao> = userRepository.findById(id)

        if (user.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
        }

        userRepository.deleteById(id)
    }

}