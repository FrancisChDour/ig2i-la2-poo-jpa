package fr.centralelille.ig2i.la2.poo.jpa.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medecin")
@Data // Génère les getters, setters, constructeurs ...
public class Medecin {

    @Id
    @Column(name = "id_medecin")
    private String idMedecin;

    @Column(name = "nom")
    private String nom;

    @ManyToOne()
    @JoinColumn(name = "id_service")
    @JsonIgnoreProperties("medecins")
    private Service service;

    @OneToMany(mappedBy = "chef")
    @JsonIgnoreProperties({"medecins"})
    private List<Service> servicesDiriges;

//    @ManyToOne()
//    @JoinColumn(name = "chef_id_medecin")
//    @JsonIgnoreProperties({"service", "servicesDiriges"})
//    private Medecin chef;
//
//    @OneToMany(mappedBy = "chef")
//    @JsonIgnoreProperties({"chef", "service"})
//    private List<Medecin> medecinsDiriges;

}
