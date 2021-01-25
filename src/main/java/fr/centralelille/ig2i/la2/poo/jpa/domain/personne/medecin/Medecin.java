package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.medecin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.Personne;
import fr.centralelille.ig2i.la2.poo.jpa.domain.service.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "medecin")
@Builder
@NoArgsConstructor
@AllArgsConstructor
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
