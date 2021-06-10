package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.services.ConversationService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("conversations")
class ConversationController(private val conversationService: ConversationService) {
    
}