package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.ErrorMessage;
import fr.centralelille.ig2i.la2.poo.jpa.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient findPatientWithId(String id) throws PatientNotFoundException {
        return Optional.ofNullable(patientRepository.getPatientById(id))
                .orElseThrow(() -> new PatientNotFoundException(id));
    }

    @Override
    public String createPatient(Patient patient) throws BusinessException {
        Optional.ofNullable(patient).orElseThrow(() -> new BusinessException(ErrorMessage.builder()
                .error("patient.notProvided")
                .message("Aucun patient fourni")
                .build()));

        patient.setId(UUID.randomUUID().toString());

        patientRepository.save(patient);
        return patient.getId();
    }
}
