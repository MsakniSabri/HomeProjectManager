package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.PropertyDto
import org.isep.homeexchange.core.services.PropertyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("properties")
class PropertyController(private val propertyService: PropertyService) {
    
}