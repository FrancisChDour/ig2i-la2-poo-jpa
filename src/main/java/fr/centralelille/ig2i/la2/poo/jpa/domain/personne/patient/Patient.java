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

    private String numeroSecu;

    private Adresse adresse;

}
