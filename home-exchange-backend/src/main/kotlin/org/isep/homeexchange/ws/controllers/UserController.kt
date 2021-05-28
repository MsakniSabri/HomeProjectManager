package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.HousingDto
import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.services.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}") //✔️
    fun getUserById(@PathVariable id: Long): UserDto = userService.getById(id)

    @PostMapping //✔️
    fun createUSer(@RequestBody dto: UserDto): UserDto = userService.create(dto, "123")

    @PutMapping //✔️
    fun updateUser(@RequestBody dto: UserDto): UserDto = userService.updateUser(dto, "245")

    @DeleteMapping("/{id}") //✔️
    fun deleteUser(@PathVariable id: Long) = userService.deleteById(id)

    @DeleteMapping //✔️
    fun deleteAll() = userService.deleteAll()
}