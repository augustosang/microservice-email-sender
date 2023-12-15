package com.augusto.ms.emailmicroservice.dtos;

import java.util.UUID;

public record EmailRecordDto(UUID id,
                             String emailTo,
                             String subject,
                             String text) {
}
