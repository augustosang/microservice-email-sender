package com.augusto.ms.emailmicroservice.services;

import com.augusto.ms.emailmicroservice.enums.StatusEmail;
import com.augusto.ms.emailmicroservice.models.EmailModel;
import com.augusto.ms.emailmicroservice.repositories.EmailRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class EmailService {

  final EmailRepository emailRepository;
  final JavaMailSender emailSender;

  @Value(value = "${spring.mail.username}")
  private String emailFrom;

  public EmailService(EmailRepository emailRepository, JavaMailSender emailSender) {
    this.emailRepository = emailRepository;
    this.emailSender = emailSender;
  }

  @Transactional
  public EmailModel sendEmail(EmailModel emailModel) {
    try {
      emailModel.setSendDateEmail(LocalDateTime.now());
      emailModel.setEmailForm(emailFrom);

      SimpleMailMessage message = new SimpleMailMessage();
      message.setTo(emailModel.getEmailTo());
      message.setSubject(emailModel.getSubject());
      message.setText(emailModel.getText());
      emailSender.send(message);

      emailModel.setStatusEmail(StatusEmail.SENT);
    } catch (MailException e) {
      emailModel.setStatusEmail(StatusEmail.ERROR);
    } finally {
      return emailRepository.save(emailModel);
    }
  }
}
