package fr.centralelille.ig2i.la2.poo.jpa.repository;

import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedecinRepository extends JpaRepository<Medecin, String> {

    Medecin getMedecinById(String idMedecin);

    @Query(value = "select m2.* from medecin m " +
            "inner join service s on m.id = s.chef_id " +
            "inner join medecin m2 on m2.id_service = s.id " +
            "where m.id = :idMedecin " +
            "and m2.id != :idMedecin ",
            nativeQuery = true)
    List<Medecin> getSubordonnedMedecin(@Param("idMedecin") String idMedecin);

}
