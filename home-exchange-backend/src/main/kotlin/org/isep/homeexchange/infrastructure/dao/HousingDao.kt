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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    var user: UserDao?
)

fun HousingDao.toDto() = HousingDto(
    id,
    description,
    userId = user!!.id
)

fun List<HousingDao>.toDto() = map { it.toDto() }