package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserDto {
        return userService.getById(id);
    }
}