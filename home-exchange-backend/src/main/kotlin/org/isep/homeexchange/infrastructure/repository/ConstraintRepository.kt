package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.infrastructure.dao.ConstraintDao
import org.springframework.data.jpa.repository.JpaRepository

interface ConstraintRepository : JpaRepository<ConstraintDao, Long> {
}
