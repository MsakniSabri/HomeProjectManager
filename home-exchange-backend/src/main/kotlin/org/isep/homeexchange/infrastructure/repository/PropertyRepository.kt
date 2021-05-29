package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.infrastructure.dao.PropertyDao
import org.springframework.data.jpa.repository.JpaRepository

interface PropertyRepository : JpaRepository<PropertyDao, Long> {
}
