package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.centralelille.ig2i.la2.poo.jpa.domain.service.Service;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.Personne;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medecin")
@Data // Génère les getters, setters, constructeurs ...
public class Medecin extends Personne {

    @ManyToOne()
    @JoinColumn(name = "id_service")
    @JsonIgnoreProperties("medecins")
    private Service service;

    @OneToMany(mappedBy = "chef")
    @JsonIgnoreProperties({"medecins", "chef"})
    private List<Service> servicesDiriges;

}
