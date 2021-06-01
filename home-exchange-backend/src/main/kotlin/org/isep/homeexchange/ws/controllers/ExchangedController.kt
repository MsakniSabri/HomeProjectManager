package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.services.ExchangedService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("exchanged")
class ExchangedController(private val exchangedService: ExchangedService) {
    
}