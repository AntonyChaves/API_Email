package com.MS.Email.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

public record EmailDTO(              //DTO contendo os dados que serão usados no envio da requisição do email

        @NotBlank
        String ownerRef,

        @NotBlank
        String emailFrom,

        @NotBlank
        String emailTO,

        @NotBlank
        String subject,

        @NotBlank
        String text

) {
}
