package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.ErrorMessage;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.NotFoundException;

public class PatientNotFoundException extends NotFoundException {

    private static final String error = "patient.notFound";
    private static final String message = "Ce patient n'existe pas : ";

    public PatientNotFoundException(String identifier){
        super(ErrorMessage.builder()
                .error(error)
                .message(message + identifier)
                .build());
    }

}
