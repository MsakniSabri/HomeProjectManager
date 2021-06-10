package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.infrastructure.dao.ConversationDao
import org.springframework.data.jpa.repository.JpaRepository

interface ConversationRepository : JpaRepository<ConversationDao, Long> {

    fun findAllByUserId(id: Long): List<ConversationDao>
}
