package fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class DomainException extends Exception {
    private ErrorMessage errorMessage;
}
