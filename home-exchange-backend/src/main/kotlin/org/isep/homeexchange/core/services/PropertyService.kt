package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.PropertyDto

interface PropertyService {
    fun create(id: Long, dto: PropertyDto): PropertyDto
    fun delete(id: Long)
}