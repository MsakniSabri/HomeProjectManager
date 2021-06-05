package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.auth.JWTUtil
import org.isep.homeexchange.core.dto.CreateUserDto
import org.isep.homeexchange.core.dto.LoginDto
import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.services.AuthService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import javax.servlet.http.Cookie
import javax.servlet.http.HttpServletResponse

@RestController
class AuthController(
    private val authService: AuthService,
    private val jwtUtil: JWTUtil
) {
    @PostMapping("/login")
    fun login(@RequestBody dto: LoginDto, response: HttpServletResponse): ResponseEntity<String> {
        val user = authService.login(dto)

        val token = jwtUtil.sign(user)

        val cookie = Cookie("token", token)
        cookie.isHttpOnly = true

        response.addCookie(cookie)

        return ResponseEntity.ok().build()
    }

    @PostMapping("/register")
    fun register(@RequestBody dto: CreateUserDto): ResponseEntity<UserDto> =
        ResponseEntity.ok(authService.register(dto))

}