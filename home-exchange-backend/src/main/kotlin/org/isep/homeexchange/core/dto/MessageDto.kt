package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.MessageDao

data class MessageDto(
    val id: Long,
    var author: UserDto,
    var conversation: ConversationDto,
)

fun MessageDto.toDao() = MessageDao(
    id = id,
    author = author.toDao(),
    conversation = conversation.toDao()
)

fun List<MessageDto>.toDao() = map { it.toDao() }