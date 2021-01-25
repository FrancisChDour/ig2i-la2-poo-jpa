# ig2i-la2-poo-jpa

## Etape 7 : classe insérée

Pour rajouter l'adresse d'un patient, et que cette classe adresse qui peut être générique soit utilisable par d'autres entités,
on créé une classe Adresse comme suit :

```java
@Data
@Embeddable // Permet à cette classe d'être incluse dans d'autres classe Entity
public class Adresse {

    @Column(name = "adresse_numero")
    private String numero;

    @Column(name = "adresse_rue")
    private String rue;

    @Column(name ="adresse_ville")
    private String ville;

}
```
La propriété ````@Embeddable```` n'est pas destinée à donner naissance à une table, aussi n'a-t-elle pas l'annotation @Entity. L'annotation @Embeddable indique que la classe a vocation à être intégrée dans un objet @Entity et donc dans la table associée à celui-ci.

Dans la classe Patient maintenant, on ajoute juste un attribut de type Adresse :

````java
@Data
@Entity
@Table(name = "patient")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient extends Personne {

    private String numeroSecu;

    private Adresse adresse;

}
````
Patient possède désormais un attribut adresse, si on tente de persister les données suivantes :
```json
{
  "adresse": {
    "numero": "4",
    "rue": "Boulevard de la liberté",
    "ville": "Lille"
  },
  "nom": "Dourlens",
  "numeroSecu": "1984738929239",
  "prenom": "François"
}
```
Alors on retrouve bien ces informations en base de données :
```
+------------------------------------+--------+--------+-------------+--------------+-----------------------+-------------+
|id                                  |nom     |prenom  |numero_secu  |adresse_numero|adresse_rue            |adresse_ville|
+------------------------------------+--------+--------+-------------+--------------+-----------------------+-------------+
|6a01e8bb-37b4-4dc4-a9fc-2c82f64f8e5b|Dourlens|François|1984738929239|4             |Boulevard de la liberté|Lille        |
+------------------------------------+--------+--------+-------------+--------------+-----------------------+-------------+

```