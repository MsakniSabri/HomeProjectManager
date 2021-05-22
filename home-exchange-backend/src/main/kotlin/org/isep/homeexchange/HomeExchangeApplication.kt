package org.isep.homeexchange

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HomeExchangeBackendApplication

fun main(args: Array<String>) {
    runApplication<HomeExchangeBackendApplication>(*args)
}
