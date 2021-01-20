package fr.centralelille.ig2i.la2.poo.jpa.controller;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient.Patient;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient.PatientNotFoundException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @GetMapping("/{id}")
    public ResponseEntity<Patient> getMedecinByIdMedecin(@PathVariable String id) throws PatientNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(patientService.findPatientWithId(id));
    }

    @PostMapping
    public ResponseEntity<?> postPatient(@RequestBody Patient patient) throws BusinessException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", patientService.createPatient(patient))
                .build();
    }

}
