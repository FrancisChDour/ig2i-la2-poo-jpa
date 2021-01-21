package fr.centralelille.ig2i.la2.poo.jpa.controller;

import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.BusinessException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.exceptions.NotFoundException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin.Medecin;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin.MedecinNotFoundException;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin.MedecinService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{idMedecin}/subordonnesJPQL")
    public ResponseEntity<List<Medecin>> getSubordonnedMedecinsJPQL(@PathVariable String idMedecin) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(medecinService.getSubordonnedMedecinJPQL(idMedecin));
    }

    @GetMapping("/{idMedecin}/subordonnes")
    public ResponseEntity<List<Medecin>> getSubordonnedMedecins(@PathVariable String idMedecin) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(medecinService.getSubordonnedMedecin(idMedecin));
    }

    @PostMapping
    public ResponseEntity<?> postMedecin(@RequestBody Medecin medecin) throws BusinessException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .header("Location", medecinService.createMedecin(medecin))
                .build();
    }
}
