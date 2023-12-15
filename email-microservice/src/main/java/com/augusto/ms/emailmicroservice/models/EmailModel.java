package com.augusto.ms.emailmicroservice.models;

import com.augusto.ms.emailmicroservice.enums.StatusEmail;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "tb_emails")
@Getter
@Setter
public class EmailModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID emailId;
  private UUID userId;
  private String emailForm;
  private String emailTo;
  private String subject;
  @Column(columnDefinition = "text")
  private String text;
  private LocalDateTime sendDateEmail;
  private StatusEmail statusEmail;
}
