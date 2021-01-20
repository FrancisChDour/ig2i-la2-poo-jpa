package fr.centralelille.ig2i.la2.poo.jpa.repository;

import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String> {

    Patient getPatientById(String id);

}
