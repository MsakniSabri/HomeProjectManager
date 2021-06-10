package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.ConversationDto
import javax.persistence.*

@Entity
@Table(name = "conversation")
data class ConversationDao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var firstUser: UserDao?,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        var secondUser: UserDao?,
)

fun ConversationDao.toConversationDto() = ConversationDto(
        id,
        firstUser = firstUser!!.toUserDto(),
        secondUser = secondUser!!.toUserDto(),
)

fun List<ConversationDao>.toConversationDto() = map { it.toConversationDto() }