package fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions;

public class NotFoundException extends DomainException {
    public NotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }
}
