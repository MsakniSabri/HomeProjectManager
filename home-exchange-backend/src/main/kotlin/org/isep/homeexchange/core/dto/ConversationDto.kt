package org.isep.homeexchange.core.dto

import org.isep.homeexchange.infrastructure.dao.ConversationDao

data class ConversationDto(
    val id: Long,
    var firstUser: UserDto,
    var secondUser: UserDto,
)

fun ConversationDto.toDao() = ConversationDao(
    id = id,
    firstUser = firstUser.toDao(),
    secondUser = secondUser.toDao(),
)

fun List<ConversationDto>.toDao() = map { it.toDao() }