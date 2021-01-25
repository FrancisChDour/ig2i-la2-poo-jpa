package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Data
@Embeddable
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Adresse {

    @Column(name = "adresse_numero")
    private String numero;

    @Column(name = "adresse_rue")
    private String rue;

    @Column(name ="adresse_ville")
    private String ville;

}
