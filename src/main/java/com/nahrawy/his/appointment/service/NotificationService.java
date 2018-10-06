package com.nahrawy.his.appointment.service;



import java.nio.charset.StandardCharsets;
import java.util.Locale;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.nahrawy.his.appointment.config.AppointmentProperties;
import com.nahrawy.his.appointment.service.dto.AppointmentDTO;

/**
 * Service for notification.
 */
@Service
public class NotificationService {

    private final Logger log = LoggerFactory.getLogger(NotificationService.class);

    private static final String APPOINTMENT = "appointment";

    private static final String BASE_URL = "baseUrl";

    private final AppointmentProperties appointmentProperties;

    private final JavaMailSender javaMailSender;

    private final MessageSource messageSource;

    private final SpringTemplateEngine templateEngine;

    public NotificationService(AppointmentProperties appointmentProperties, JavaMailSender javaMailSender,
            MessageSource messageSource, SpringTemplateEngine templateEngine) {

        this.appointmentProperties = appointmentProperties;
        this.javaMailSender = javaMailSender;
        this.messageSource = messageSource;
        this.templateEngine = templateEngine;
    }

    @Async
    public void sendEmail(String to, String subject, String content, boolean isMultipart, boolean isHtml) {
        log.debug("Send email[multipart '{}' and html '{}'] to '{}' with subject '{}' and content={}",
            isMultipart, isHtml, to, subject, content);

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage, isMultipart, StandardCharsets.UTF_8.name());
            message.setTo(to);
            message.setFrom(appointmentProperties.getMail().getFrom());
            message.setSubject(subject);
            message.setText(content, isHtml);
            javaMailSender.send(mimeMessage);
            log.debug("Sent email to User '{}'", to);
        } catch (Exception e) {
            if (log.isDebugEnabled()) {
                log.warn("Email could not be sent to user '{}'", to, e);
            } else {
                log.warn("Email could not be sent to user '{}': {}", to, e.getMessage());
            }
        }
    }

    @Async
    public void sendEmailFromTemplate(String to , AppointmentDTO appointment , String templateName, String titleKey) {
        Locale locale = Locale.forLanguageTag("en");
        Context context = new Context(locale);
        context.setVariable(APPOINTMENT, appointment);
        context.setVariable(BASE_URL, appointmentProperties.getMail().getBaseUrl());
        String content = templateEngine.process(templateName, context);
        String subject = messageSource.getMessage(titleKey, null, locale);
        sendEmail(to, subject, content, false, true);

    }

    @Async
    public void sendConfirmNotificationEmail(AppointmentDTO appointment , String to) {
        log.debug("Sending confirmation email to '{}'", to);
        sendEmailFromTemplate(to, appointment,"mail/confirmationEmail", "email.confirmation.title");
    }

   
}
