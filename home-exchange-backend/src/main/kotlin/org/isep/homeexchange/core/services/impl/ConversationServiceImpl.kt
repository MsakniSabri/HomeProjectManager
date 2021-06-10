package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.ConversationDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.ConversationService
import org.isep.homeexchange.core.services.UserService
import org.isep.homeexchange.infrastructure.dao.ConversationDao
import org.isep.homeexchange.infrastructure.dao.toConversationDto
import org.isep.homeexchange.infrastructure.repository.ConversationRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class ConversationServiceImpl(
    private val conversationRepository: ConversationRepository,
    private val userService: UserService,
) : ConversationService {

    override fun create(dto: ConversationDto
    ): ConversationDto {
        val firstUserDto = userService.getById(dto.firstUser.id)
        val secondUserDto = userService.getById(dto.secondUser.id)
        val conversationDao = dto.toDao()
        conversationDao.firstUser = firstUserDto.toDao()
        conversationDao.secondUser = secondUserDto.toDao()

        return conversationRepository.save(conversationDao).toConversationDto()
    }

    override fun getById(id: Long): ConversationDto {
        val conversation: Optional<ConversationDao> = conversationRepository.findById(id)

        if (conversation.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Conversation doesn't exist")
        }


        return conversation.get().toConversationDto()
    }

    override fun getAllConversaionsByUserId(id: Long): List<ConversationDto> {
        val conversationDao: List<ConversationDao> = conversationRepository.findAllByUserId(id)

        return conversationDao.toConversationDto()
    }

    override fun delete(id: Long) {
        conversationRepository.deleteById(id);
    }
}