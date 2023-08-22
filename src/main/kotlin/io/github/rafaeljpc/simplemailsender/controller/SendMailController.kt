package io.github.rafaeljpc.simplemailsender.controller

import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mail")
class SendMailController {

    @PostMapping
    fun post(message: String) {

    }
}