package fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorMessage {
    private String error;
    private String message;
}
