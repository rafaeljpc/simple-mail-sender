package io.github.rafaeljpc.simplemailsender

import org.springframework.beans.factory.annotation.Value

class MailConfig(
        @Value("\${spring.mail.host}") private val host: String,
        @Value("\${spring.mail.port}") private val port: Int,
        @Value("\${spring.mail.username}") private val username: String,
        @Value("\${spring.mail.password}") private val password: String,
        @Value("\${spring.mail.properties.mail.smtp.auth}") private val auth: Boolean,
        @Value("\${spring.mail.properties.mail.smtp.starttls.enable}") private val starttls: Boolean,
) {


}