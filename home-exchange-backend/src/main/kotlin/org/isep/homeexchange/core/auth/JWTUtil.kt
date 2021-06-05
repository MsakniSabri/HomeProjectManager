package org.isep.homeexchange.core.auth

import io.jsonwebtoken.*
import org.isep.homeexchange.core.dto.UserDto
import org.isep.homeexchange.core.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException

@Component
class JWTUtil {
    @Autowired
    private lateinit var userService: UserService

    private val SECRET_KEY: String = "secretKey"

    fun sign(user: UserDto): String {
        return Jwts.builder()
            .setIssuer(user.id.toString())
            .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
            .compact()
    }

    fun verify(token: String?): UserDto {
        try {
            if (token?.isBlank() == true) {
                throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
            }

            val body = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).body

            return userService.getById(body.issuer.toLong())
        } catch (ex: JwtException) {
            throw ResponseStatusException(HttpStatus.UNAUTHORIZED)
        }
    }
}