package fr.centralelille.ig2i.la2.poo.jpa.domain.personne.patient;

import fr.centralelille.ig2i.la2.poo.jpa.domain.personne.Personne;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "patient")
public class Patient extends Personne {

    private String numeroSecu;

}
