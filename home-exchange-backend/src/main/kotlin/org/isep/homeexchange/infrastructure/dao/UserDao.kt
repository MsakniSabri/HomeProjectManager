package org.isep.homeexchange.infrastructure.dao

import org.isep.homeexchange.core.dto.UserDto
import javax.persistence.*

@Entity
@Table(name = "users")
class UserDao(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var email: String,

    @Column(nullable = false)
    var password: String?,

    @Column
    var phoneNumber: String?,

    @Column(nullable = false)
    var firstname: String,

    @Column(nullable = false)
    var lastname: String,

    @Column
    var profilePictureUrl: String?,

    @Column
    var admin: Boolean,

    @OneToMany(mappedBy = "id", orphanRemoval = true)
    var housings: List<HousingDao>,

    )

fun UserDao.toDto(): UserDto = UserDto(
    id = id,
    email = email,
    phoneNumber = phoneNumber,
    firstname = firstname,
    lastname = lastname,
    profilePictureUrl = profilePictureUrl,
    admin = admin,
    housings = housings.toDto()
)
