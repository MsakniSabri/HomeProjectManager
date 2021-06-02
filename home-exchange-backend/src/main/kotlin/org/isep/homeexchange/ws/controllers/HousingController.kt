package org.isep.homeexchange.ws.controllers

import org.isep.homeexchange.core.dto.CreateHousingDto
import org.isep.homeexchange.core.dto.HousingDto
import org.isep.homeexchange.core.dto.PropertyDto
import org.isep.homeexchange.core.services.HousingService
import org.isep.homeexchange.core.services.PropertyService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("housings")
class HousingController(
    private val housingService: HousingService,
    private val propertyService: PropertyService)
{

    @PostMapping //✔️
    fun createHousing(@RequestBody dto: CreateHousingDto): HousingDto = housingService.create(dto)

    @GetMapping("/{id}") //✔️
    fun getHousingById(@PathVariable id: Long): HousingDto = housingService.getById(id)

    @GetMapping("/user/{userId}") //?? One to many de User --> devrait avoir 3 maisons, qu'une seule apparait
    fun getHousingByUser(@PathVariable userId: Long): List<HousingDto> = housingService.getByUsers(userId)

    @GetMapping //✔️
    fun getAllHousings(): List<HousingDto> = housingService.getAll()

    @PutMapping //?? Ne modifie pas dans la bdd
    fun updateHousing(@RequestBody dto: HousingDto): HousingDto = housingService.updateHousing(dto)

    @DeleteMapping("/{id}") //✔️
    fun deleteHousingById(@PathVariable id: Long) = housingService.deleteById(id)

    @DeleteMapping //✔️
    fun deleteAllHousing() = housingService.deleteAll()

    @PostMapping("/{id}/property")
    fun addProperty(@PathVariable id: Long, @RequestBody dto: PropertyDto) = propertyService.create(id, dto)
}