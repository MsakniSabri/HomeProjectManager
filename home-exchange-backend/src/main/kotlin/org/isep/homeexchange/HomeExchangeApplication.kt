package org.isep.homeexchange

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class HomeExchangeBackendApplication

fun main(args: Array<String>) {
    runApplication<HomeExchangeBackendApplication>(*args)
}
