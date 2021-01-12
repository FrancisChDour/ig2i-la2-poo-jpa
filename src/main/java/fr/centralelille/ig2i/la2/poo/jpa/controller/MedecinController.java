package fr.centralelille.ig2i.la2.poo.jpa.controller;

import fr.centralelille.ig2i.la2.poo.jpa.domain.Medecin;
import fr.centralelille.ig2i.la2.poo.jpa.repository.MedecinRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
