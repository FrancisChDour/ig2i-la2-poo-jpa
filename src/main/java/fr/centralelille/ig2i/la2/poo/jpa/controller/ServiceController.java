package fr.centralelille.ig2i.la2.poo.jpa.controller;

import fr.centralelille.ig2i.la2.poo.jpa.domain.service.Service;
import fr.centralelille.ig2i.la2.poo.jpa.repository.ServiceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/service")
@RequiredArgsConstructor
public class ServiceController {

    // On peut utiliser le repo JPA tels quel, même si une séparation des couches est préférable
    private final ServiceRepository serviceRepository;

    @GetMapping("/{idService}")
    public ResponseEntity<Service> getMedecinByidService(@PathVariable String idService){
        return ResponseEntity.status(HttpStatus.OK)
                .body(serviceRepository.getServiceById(idService));
    }

    @PostMapping
    public ResponseEntity<?> postService(@RequestBody Service service){
        if (service.getId() == null) service.setId(UUID.randomUUID().toString());
        serviceRepository.save(service);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
