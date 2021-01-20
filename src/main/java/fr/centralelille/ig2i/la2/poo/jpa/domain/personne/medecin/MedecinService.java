package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.NotFoundException;

import java.util.List;

public interface MedecinService {

    Medecin findMedecin(String idMedecin) throws MedecinNotFoundException;

    String createMedecin(Medecin medecin) throws BusinessException;

    List<Medecin> getSubordonnedMedecin(String idMedecin) throws BusinessException, NotFoundException;

}
