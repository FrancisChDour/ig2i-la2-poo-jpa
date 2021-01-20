package fr.centralelille.ig2i.la2.poo.jpa.domain.personne;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

}
