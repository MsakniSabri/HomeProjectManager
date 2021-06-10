package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.infrastructure.dao.MessageDao
import org.springframework.data.jpa.repository.JpaRepository

interface MessageRepository : JpaRepository<MessageDao, Long> {

    fun findAllByUserId(id: Long): List<MessageDao>
}
