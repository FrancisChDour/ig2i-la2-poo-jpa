package fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions;

public class BusinessException extends DomainException {
    public BusinessException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
