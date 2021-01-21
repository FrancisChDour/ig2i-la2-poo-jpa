package fr.centralelille.ig2i.la2.poo.jpa.domain.service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin.Medecin;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
@Data
public class Service {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "localisation")
    private String localisation;

    @OneToMany(mappedBy = "service")
    @JsonIgnoreProperties({"service", "servicesDiriges"})
    private List<Medecin> medecins;

    @ManyToOne()
    @JsonIgnoreProperties({"service", "servicesDiriges"})
    private Medecin chef;

}
