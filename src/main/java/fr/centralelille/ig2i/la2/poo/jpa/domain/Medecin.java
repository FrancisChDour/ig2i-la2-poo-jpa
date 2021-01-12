package fr.centralelille.ig2i.la2.poo.jpa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medecin")
@Data
public class Medecin {

    @Id
    @Column(name = "id_medecin")
    private String idMedecin;

    @Column(name = "nom")
    private String nom;
}
