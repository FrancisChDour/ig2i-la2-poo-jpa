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

    @Query(value = "select m.* from service s " +
            "inner join medecin m on s.id = m.id_service " +
            "where s.chef_id = :idMedecin " +
            "and m.id != :idMedecin",
            nativeQuery = true)
    List<Medecin> getSubordonnedMedecin(@Param("idMedecin") String idMedecin);

}
