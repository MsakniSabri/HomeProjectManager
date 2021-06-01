package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.ExchangedDto

interface ExchangedService {
    fun create(housing_id: Long, user_id: Long, dto: ExchangedDto): ExchangedDto
    fun getByUsers(user_id: Long): List<ExchangedDto>
    fun delete(id: Long)
}