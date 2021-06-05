package org.isep.homeexchange.ws.handlers

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.ResponseStatusException

@ControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(ResponseStatusException::class)
    fun responseStatusException(e: ResponseStatusException): ResponseEntity<String> {
        return ResponseEntity.status(e.status).body(e.reason)
    }
}