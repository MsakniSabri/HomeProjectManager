package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.HousingDto
import org.isep.homeexchange.core.services.HousingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("housings")
class HousingController(private val housingService: HousingService) {

    @PostMapping
    fun createHousing(@RequestBody dto: HousingDto): HousingDto = housingService.create(dto)

    @GetMapping("/{id}")
    fun getHousingById(@PathVariable id: Long): HousingDto = housingService.getById(id)
}