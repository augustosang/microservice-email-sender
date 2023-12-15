package com.augusto.ms.usermicroservice.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDto {

  private UUID id;
  private String emailTo;
  private String subject;
  private String text;
}
