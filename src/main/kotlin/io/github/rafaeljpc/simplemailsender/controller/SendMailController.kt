package io.github.rafaeljpc.simplemailsender.controller

import io.github.rafaeljpc.simplemailsender.config.MailConfig
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/mail")
class SendMailController
@Autowired
constructor(
        private val mailSender: JavaMailSender,
        private val mailConfig: MailConfig,
) {

    @PostMapping
    fun post(
            message: String,
            @RequestParam("destination") destination: String,
            @RequestParam("subject") subject: String = "Subject",
    ) {
        val mailMsg = SimpleMailMessage()

        mailMsg.from = mailConfig.from
        mailMsg.setTo(*(destination.split(",").toTypedArray()))
        mailMsg.subject = subject
        mailMsg.text = message

        mailSender.send(mailMsg)
    }
}
