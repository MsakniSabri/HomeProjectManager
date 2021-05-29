package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.infrastructure.dao.UserDao
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<UserDao, Long> {
    fun findByEmail(email: String): Optional<UserDao>
}