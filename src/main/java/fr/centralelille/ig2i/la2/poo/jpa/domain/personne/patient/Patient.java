package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient;

import com.fasterxml.jackson.annotation.JsonInclude;
import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.Personne;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "patient")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient extends Personne {

    // Sans préciser @Column ..., Hibernate semble reconnaître qu'il sagit de la colonne numero_secu
    private String numeroSecu;

    // Simplement rajouter la Embeddable classe Adresse comme un Attribut de Patient
    private Adresse adresse;

}
