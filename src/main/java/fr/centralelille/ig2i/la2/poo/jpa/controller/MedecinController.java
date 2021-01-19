package fr.centralelille.ig2i.la2.poo.jpa.controller;

import fr.centralelille.ig2i.la2.poo.jpa.domain.Medecin;
import fr.centralelille.ig2i.la2.poo.jpa.repository.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/medecin")
@RequiredArgsConstructor
public class MedecinController {

    private final MedecinRepository medecinRepository;

    @GetMapping("/{idMedecin}")
    public ResponseEntity<Medecin> getMedecinByIdMedecin(@PathVariable String idMedecin){
        return ResponseEntity.status(HttpStatus.OK)
                .body(medecinRepository.getMedecinByIdMedecin(idMedecin));
    }

    @PostMapping
    public ResponseEntity<?> postMedecin(@RequestBody Medecin medecin){
        if (medecin.getIdMedecin() == null) medecin.setIdMedecin(UUID.randomUUID().toString());
        medecinRepository.save(medecin);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
