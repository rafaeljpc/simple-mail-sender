package io.github.rafaeljpc.simplemailsender.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.JavaMailSenderImpl

@Configuration
class MailConfig(
        @Value("\${spring.mail.host}") private val host: String,
        @Value("\${spring.mail.port}") private val port: Int,
        @Value("\${spring.mail.username}") private val username: String,
        @Value("\${spring.mail.password}") private val password: String,
        @Value("\${spring.mail.properties.mail.smtp.auth}") private val auth: Boolean,
        @Value("\${spring.mail.properties.mail.smtp.starttls.enable}")
        private val starttls: Boolean,
        @Value("\${spring.mail.properties.mail.smtp.starttls.required}")
        private val starttlsRequire: Boolean,
        @Value("\${spring.mail.properties.mail.from}") val from: String,
) {

    @Bean
    fun mailSender(): JavaMailSender {
        val mailSender = JavaMailSenderImpl()

        mailSender.host = this.host
        mailSender.port = this.port
        mailSender.username = this.username
        mailSender.password = this.password

        val props = mailSender.javaMailProperties

        props.putAll(mapOf(
            "mail.transport.protocol" to "smtp",
            "mail.smtp.auth" to this.auth.toString(),
            "mail.smtp.starttls.enable" to this.starttls.toString(),
            "mail.smtp.starttls.required" to this.starttlsRequire.toString(),
            "mail.debug" to "true",
        ))

        return mailSender
    }
}
