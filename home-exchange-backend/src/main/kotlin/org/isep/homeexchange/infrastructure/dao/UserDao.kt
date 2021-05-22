package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.UserDto
import javax.persistence.*

@Entity()
@Table(name = "users")
class UserDao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,

    )

fun UserDao.toDto(): UserDto = UserDto(
    id = id
)