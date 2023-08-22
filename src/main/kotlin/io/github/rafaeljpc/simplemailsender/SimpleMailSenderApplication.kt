package io.github.rafaeljpc.simplemailsender

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleMailSenderApplication

fun main(args: Array<String>) {
    runApplication<SimpleMailSenderApplication>(*args)
}
