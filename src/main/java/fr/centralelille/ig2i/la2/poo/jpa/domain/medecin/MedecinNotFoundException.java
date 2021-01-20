package fr.centralelille.ig2i.la2.poo.jpa.domain.medecin;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.ErrorMessage;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.NotFoundException;

public class MedecinNotFoundException extends NotFoundException {

    private static final String error = "medecin.notFound";
    private static final String message = "Ce médecin n'existe pas : ";

    public MedecinNotFoundException(String identifier){
        super(ErrorMessage.builder()
                .error(error)
                .message(message + identifier)
                .build());
    }

}
