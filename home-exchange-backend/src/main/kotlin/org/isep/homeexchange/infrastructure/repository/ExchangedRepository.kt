package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.infrastructure.dao.ExchangedDao
import org.isep.homeexchange.infrastructure.dao.HousingDao
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangedRepository : JpaRepository<ExchangedDao, Long> {
    fun findByUserId(id: Long): List<ExchangedDao>
}
