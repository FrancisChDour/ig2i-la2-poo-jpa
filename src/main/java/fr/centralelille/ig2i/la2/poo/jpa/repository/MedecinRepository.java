package fr.centralelille.ig2i.la2.poo.jpa.repository;

import fr.centralelille.ig2i.la2.poo.jpa.domain.medecin.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, String> {

    Medecin getMedecinByIdMedecin(String idMedecin);

}
