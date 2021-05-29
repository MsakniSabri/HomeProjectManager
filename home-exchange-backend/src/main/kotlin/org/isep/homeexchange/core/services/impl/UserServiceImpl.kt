package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.CreateUserDto
import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.dto.toDao
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

    override fun create(dto: CreateUserDto): UserDto {
        val userDao = dto.toDao()

        return userRepository.save(userDao).toDto()
    }

    override fun getById(id: Long): UserDto {
        val user: Optional<UserDao> = userRepository.findById(id);

        if (user.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
        }

        return user.get().toDto()
    }

    override fun updateUser(dto: UserDto, password: String?): UserDto {
        val userDao = dto.toDao()

        if(!password.isNullOrEmpty()){
            userDao.password = password
        }else{
            val user: Optional<UserDao> = userRepository.findById(userDao.id)
            if (user.isEmpty) {
                throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
            }
            userDao.password = user.get().password
        }

        return userRepository.save(userDao).toDto()
    }

    override fun deleteById(id: Long) {
        val user: Optional<UserDao> = userRepository.findById(id)

        if(user.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "User doesn't exist")
        }

        userRepository.deleteById(id)
    }

    override fun deleteAll() {
        userRepository.deleteAll()
    }
}