package fr.centralelille.ig2i.la2.poo.jpa.domain.medecin;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;

public interface MedecinService {

    Medecin findMedecin(String idMedecin) throws MedecinNotFoundException;

    String createMedcin(Medecin medecin) throws BusinessException;

}
