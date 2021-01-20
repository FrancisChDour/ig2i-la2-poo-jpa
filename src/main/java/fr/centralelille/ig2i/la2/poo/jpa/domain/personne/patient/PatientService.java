package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;

public interface PatientService {

    Patient findPatientWithId(String id) throws PatientNotFoundException;

    String createPatient(Patient patient) throws BusinessException;

}
