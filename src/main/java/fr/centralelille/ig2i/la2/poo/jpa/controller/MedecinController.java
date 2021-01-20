package fr.centralelille.ig2i.la2.poo.jpa.controller;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.medecin.Medecin;
import fr.centralelille.ig2i.la2.poo.jpa.domain.medecin.MedecinNotFoundException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.medecin.MedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/medecin")
@RequiredArgsConstructor
public class MedecinController {

    private final MedecinService medecinService;

    @GetMapping("/{idMedecin}")
    public ResponseEntity<Medecin> getMedecinByIdMedecin(@PathVariable String idMedecin) throws MedecinNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(medecinService.findMedecin(idMedecin));
    }

    @PostMapping
    public ResponseEntity<?> postMedecin(@RequestBody Medecin medecin) throws BusinessException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", medecinService.createMedcin(medecin))
                .build();
    }
}
