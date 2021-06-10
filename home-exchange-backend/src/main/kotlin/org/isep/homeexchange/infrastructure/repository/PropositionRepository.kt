package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.infrastructure.dao.PropositionDao
import org.springframework.data.jpa.repository.JpaRepository

interface PropositionRepository : JpaRepository<PropositionDao, Long> {

    fun findAllByAccepted(accepted: Boolean): List<PropositionDao>
}
