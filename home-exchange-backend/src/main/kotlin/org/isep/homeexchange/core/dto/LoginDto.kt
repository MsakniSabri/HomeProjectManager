package org.isep.homeexchange.core.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class LoginDto(
    @JsonProperty("email") val email: String,
    @JsonProperty("password") val password: String?
)