package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.ConversationDto
import java.time.LocalDate

interface ConversationService {
    fun create(dto: ConversationDto): ConversationDto
    fun getById(id: Long): ConversationDto
    fun getAllConversaionsByUserId(id: Long): List<ConversationDto>
    fun delete(id: Long)
}