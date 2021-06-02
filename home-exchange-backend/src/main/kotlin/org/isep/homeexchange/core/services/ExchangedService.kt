package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.ExchangedDto

interface ExchangedService {
    fun create(housingId: Long, userId: Long, dto: ExchangedDto): ExchangedDto
    fun getByUsers(userId: Long): List<ExchangedDto>
    fun delete(id: Long)
}