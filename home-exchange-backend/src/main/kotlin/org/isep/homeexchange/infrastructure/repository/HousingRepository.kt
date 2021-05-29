package org.isep.homeexchange.infrastructure.repository

import org.isep.homeexchange.core.dto.HousingDto
import org.isep.homeexchange.infrastructure.dao.HousingDao
import org.isep.homeexchange.infrastructure.dao.UserDao
import org.springframework.data.jpa.repository.JpaRepository

interface HousingRepository : JpaRepository<HousingDao, Long> {
    fun findByUserId(id: Long): List<HousingDao>
}
