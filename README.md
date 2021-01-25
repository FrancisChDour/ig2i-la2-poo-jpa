# ig2i-la2-poo-jpa

## Etape 6 : héritage

Patient et Médecin possède des attributs en commun : id, nom, prenom. De ce fait on peut modéliser nos deux classes en Java comme héritantes d'une classe abstraite Personne qui
possèdera ces attributs communs :

````java
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
````
L'annotation ```@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)``` indique qu'une classe Entity pourra hériter de cette classe Personne.
L'option ```strategy=InheritanceType.TABLE_PER_CLASS``` indique la statégie de gestion de cette héritage dans la base de données.
En l'occurence ici, chaque table possèdera distinctement les colonnes id, nom et prenom.

Autres statégies d'héritage possible :
+ ```InheritanceType.SINGLE_TABLE``` : Pas de tables distinctes, tout est stocké à plat dans la même table.
+ ```InheritanceType.JOINED``` : Deux tables distinctes, ici personne et medecin par exemple, reliées entre elles par une jointure.

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

## Comparaison des performances entre JPA, JPQL et JDBC

Création d'un grand nombre de médecins en bouclant sur un appel POST:/medecin :

```bash
curl --location --request POST 'http://localhost:8080/medecin' \
--header 'Content-Type: application/json' \
--data '{
  "nom": "TEST",
  "prenom": "TEST",
  "service": {
    "id": "2"
  }
}'
```
```bash
for i in {1..500}; do bash test.sh; done
```
On possède maintenant un nombre important de médecins pour un service donné. On effectue ensuite un certain nombre d'appels sur les endpoints 
+ /medecin/{idMedecin}/subordonnesIds qui requête la BDD avec JPA
+ /medecin/{idMedecin}/subordonnesIdsJPQL qui requête la BDD avec une requête JPQL
+ /medecin/{idMedecin}/subordonnesIdsJDBC qui requête la BDD avec JDBC

Jusqu'à avoir une moyenne du temps de réponse pour chaque endpoint :

+ /medecin/{idMedecin}/subordonnesIds : ~500ms pour 26.1 ko
+ /medecin/{idMedecin}/subordonnesIdsJPQL : ~200ms pour 26.1 ko
+ /medecin/{idMedecin}/subordonnesIdsJDBC : ~200ms pour 26.1 ko

**Conclusion :**

Pour une grande quantités de données, manipuler la données en naviguant dans des objets Java récupérés avec les interfaces JPA semble moins performant que de récupérer la données via une requête JPQL ou JDBC spécifique. Pas de perte de performance constatée entre JDBC et JPQL.
