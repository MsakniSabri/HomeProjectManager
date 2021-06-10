package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.HousingDto
import javax.persistence.*

@Entity
@Table(name = "housings")
data class HousingDao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0,

    @Column
    var description: String,

    @Column
    var title: String,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserDao?,

    @OneToMany(mappedBy = "id", orphanRemoval = true)
    var properties: List<PropertyDao>,

    @OneToMany(mappedBy = "id", orphanRemoval = true)
    var images: List<ImageDao>,

    @Column(name = "user_id", insertable = false, updatable = false)
    var userId: Long

)

fun HousingDao.toHousingDto() = HousingDto(
    id,
    title,
    description,
    userId = userId,
    properties = properties.toUserDto(),
    images = images.toImageDto(),
)

fun List<HousingDao>.toHousingDto() = map { it.toHousingDto() }