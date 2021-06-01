package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.infrastructure.dao.ExchangedDao
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangedRepository : JpaRepository<ExchangedDao, Long> {
}
