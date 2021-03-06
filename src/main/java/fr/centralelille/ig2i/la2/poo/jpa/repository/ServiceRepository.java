package fr.centralelille.ig2i.la2.poo.jpa.repository;

import fr.centralelille.ig2i.la2.poo.jpa.domain.service.Service;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends JpaRepository<Service, String> {

    Service getServiceById(String idMedecin);

    Service getServiceByChef(Medecin medecin);

}
