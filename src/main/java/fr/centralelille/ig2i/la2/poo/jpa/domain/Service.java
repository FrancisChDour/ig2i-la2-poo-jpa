package fr.centralelille.ig2i.la2.poo.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "service")
@Data
public class Service {

    @Id
    @Column(name = "id_service")
    private String idService;

    @Column(name = "nom")
    private String nom;

    @Column(name = "localisation")
    private String localisation;

    @OneToMany(mappedBy = "service")
    @JsonIgnoreProperties({"service", "servicesDiriges"})
    private List<Medecin> medecins;

    @ManyToOne()
    @JoinColumn(name = "id_medecin")
    @JsonIgnoreProperties({"service", "servicesDiriges"})
    private Medecin chef;

}
