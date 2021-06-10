package org.isep.homeexchange.core.services.impl

import org.isep.homeexchange.core.dto.ConversationDto
import org.isep.homeexchange.core.dto.MessageDto
import org.isep.homeexchange.core.dto.toDao
import org.isep.homeexchange.core.services.ConversationService
import org.isep.homeexchange.core.services.MessageService
import org.isep.homeexchange.core.services.UserService
import org.isep.homeexchange.infrastructure.dao.ConversationDao
import org.isep.homeexchange.infrastructure.dao.MessageDao
import org.isep.homeexchange.infrastructure.dao.toConversationDto
import org.isep.homeexchange.infrastructure.dao.toMessageDto
import org.isep.homeexchange.infrastructure.repository.ConversationRepository
import org.isep.homeexchange.infrastructure.repository.MessageRepository
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import java.util.*

@Service
class MessageServiceImpl(
    private val messageRepository: MessageRepository,
    private val userService: UserService,
    private val conversationService: ConversationService,
) : MessageService {

    override fun create(dto: MessageDto
    ): MessageDto {
        val authorDto = userService.getById(dto.author.id)
        val conversationDto = conversationService.getById(dto.conversation.id)
        val messageDao = dto.toDao()
        messageDao.author = authorDto.toDao()
        messageDao.conversation = conversationDto.toDao()

        return messageRepository.save(messageDao).toMessageDto()
    }

    override fun getById(id: Long): MessageDto {
        val message: Optional<MessageDao> = messageRepository.findById(id)

        if (message.isEmpty) {
            throw ResponseStatusException(HttpStatus.NOT_FOUND, "Messsage doesn't exist")
        }


        return message.get().toMessageDto()
    }

    override fun getAllMessagesByUserId(id: Long): List<MessageDto> {
        val messageDao: List<MessageDao> = messageRepository.findAllByUserId(id)

        return messageDao.toMessageDto()
    }

    override fun delete(id: Long) {
        messageRepository.deleteById(id);
    }
}