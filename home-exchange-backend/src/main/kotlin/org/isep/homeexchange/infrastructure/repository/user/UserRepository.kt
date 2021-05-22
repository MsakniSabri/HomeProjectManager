package org.isep.homeexchange.infrastructure.repository.user

import org.isep.homeexchange.infrastructure.dao.UserDao
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserDao, Long> {
}