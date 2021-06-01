package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.ImageDto
import javax.persistence.*

@Entity
@Table(name = "images")
data class ImageDao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column
    var imageAddress: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "housing_id")
    var housing: HousingDao?
)

fun ImageDao.toUserDto() = ImageDto(
    id,
    imageAddress,
    housingId = housing!!.id
)

fun List<ImageDao>.toUserDto() = map { it.toUserDto() }