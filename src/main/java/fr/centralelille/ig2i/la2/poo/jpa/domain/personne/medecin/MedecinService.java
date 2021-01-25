package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;

import java.util.List;

public interface MedecinService {

    Medecin findMedecin(String idMedecin) throws MedecinNotFoundException;

    String createMedecin(Medecin medecin) throws BusinessException;

    List<Medecin> getSubordonnedMedecin(String idMedecin) throws MedecinNotFoundException;

    List<Medecin> getSubordonnedMedecinJPQL(String idMedecin);

    List<String> getSubordonnedMedecinIdsJPQL(String idMedecin);

    List<String> getSubordonnedMedecinIds(String idMecin) throws MedecinNotFoundException;

}
