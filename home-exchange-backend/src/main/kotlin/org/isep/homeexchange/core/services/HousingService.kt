package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.HousingDto

interface HousingService {
    fun create(dto: HousingDto): HousingDto
    fun getById(id: Long): HousingDto
}