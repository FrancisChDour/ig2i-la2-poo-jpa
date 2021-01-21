package fr.centralelille.ig2i.la2.poo.jpa.domain.service;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.ErrorMessage;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.NotFoundException;

public class ServiceNotFoundException extends NotFoundException {

    private static final String error = "service.notFound";
    private static final String message = "Ce service n'existe pas : ";

    public ServiceNotFoundException(String identifier){
        super(ErrorMessage.builder()
                .error(error)
                .message(message + identifier)
                .build());
    }

    public ServiceNotFoundException(ErrorMessage errorMessage){
        super(errorMessage);
    }

}
