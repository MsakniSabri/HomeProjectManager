package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.UpdateUserDto
import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.services.UserService
import org.isep.homeexchange.ws.annotations.User
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.server.ResponseStatusException

@RestController
@RequestMapping("users")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun getUserById(@User currentUser: UserDto, @PathVariable id: Long): ResponseEntity<UserDto> = ResponseEntity.ok(userService.getById(id))

    @PutMapping
    fun updateUser(@RequestBody dto: UpdateUserDto): UserDto = userService.update(dto)

    @DeleteMapping("/{id}")
    fun deleteUser(@PathVariable id: Long) = userService.deleteById(id)

}