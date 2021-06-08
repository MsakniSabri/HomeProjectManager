package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.MessageDto
import javax.persistence.*

@Entity
@Table(name = "message")
data class MessageDao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var author: UserDao?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "conversation_id")
        var conversation: ConversationDao?,
)

fun MessageDao.toMessageDto() = MessageDto(
        id,
        author = author!!.toUserDto(),
        conversation = conversation!!.toConversationDto()
)

fun List<MessageDao>.toMessageDto() = map { it.toMessageDto() }