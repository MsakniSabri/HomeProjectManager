package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.PropertyDto

interface PropertyService {
    fun create(id: Long, dto: PropertyDto): PropertyDto
    fun getById(id: Long): PropertyDto
    fun setDescription(id: Long, description: String): PropertyDto
    fun delete(id: Long)
}