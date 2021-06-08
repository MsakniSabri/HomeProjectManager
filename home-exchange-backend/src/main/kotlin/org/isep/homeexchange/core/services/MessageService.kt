package org.isep.homeexchange.core.services

import org.isep.homeexchange.core.dto.MessageDto
import java.time.LocalDate

interface MessageService {
    fun create(dto: MessageDto): MessageDto
    fun getById(id: Long): MessageDto
    fun getAllMessagesByUserId(id: Long): List<MessageDto>
    fun delete(id: Long)
}