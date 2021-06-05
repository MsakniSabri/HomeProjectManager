package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.PropertyDto
import javax.persistence.*

@Entity
@Table(name = "properties")
data class PropertyDao(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        @Column
        var description: String,

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "housing_id")
        var housing: HousingDao?
)

fun PropertyDao.toPropertyDto() = PropertyDto(
        id,
        description,
)

fun List<PropertyDao>.toPropertyDto() = map { it.toPropertyDto() }