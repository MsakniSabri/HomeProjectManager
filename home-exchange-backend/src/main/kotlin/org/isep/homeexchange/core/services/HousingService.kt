package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.CreateHousingDto
import org.isep.homeexchange.core.dto.HousingDto

interface HousingService {
    fun create(dto: CreateHousingDto): HousingDto
    fun getById(id: Long): HousingDto
    fun getByUsers(user_id: Long): List<HousingDto>
    fun getAll(): List<HousingDto>
    fun updateHousing(dto: HousingDto): HousingDto
    fun deleteById(id: Long)
    fun deleteAll()
}