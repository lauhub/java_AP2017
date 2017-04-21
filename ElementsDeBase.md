# Eléments du langage Java

## Paquetages (package)
Un package permet de regrouper des classes qui partagent un même objectif dans une application ou une librairie.

Par exemple, les classes du package `java.net` regroupent des outils d'accès au réseau. Les classes du package `java.io` regroupent les classes de gestion de flux d'entrées/sorties.

Les packages:

* permettent d'organiser les classes dans une arborescence
* réduisent les problèmes de conflits de nom et sont sensés garantir une unicité dans l'identification d'une classe
* permettent de protéger l'utilisation de certains attributs / méthodes à l'intérieur d'un package donné.


### Nommage des packages

Les noms des paquetages sont **TOUJOURS** en minuscules (aucune majuscule).

### Exercice

Vérifiez à quelles packages appartiennent les classes String, Object et List.

Concernant la classe List, déterminez si elle est unique.




## Classes
Une classe est un modèle. Elle permet de déterminer le comportement d'un ensemble d'objets similaires et leurs caractéristiques et comportements.

La classe va servir de prototype pour créer une instance. L'instance (ou exemplaire) d'une classe se comportera comme définit dans ce modèle.

### Définition d'une classe

```java
class Forme {
    String nom; //attribut nom
}
```

### Instantiation
L'instantiation se fait avec le mot clef `new`

```java
Forme forme = new Forme();
```

### Identification d'une classe

L'identification d'une classe se fait à partir de son nom et de son paquetage.

Ainsi, le nom complet de la classe `String` est `java.lang.String`.

Le nom complet de la classe `List` est `java.util.List` ou `java.awt.List`. En effet il y a plusieurs classes List.

#### Import

Si on veut les différencier il faut utiliser le nom complet. Ce qui serait peu lisible en pratique. Comme dans une classe on n'utilise en général qu'une de ces deux classes, on va utiliser un `import`.

Ainsi, au lieu de devoir écrire:

```java
class Polygone extends Forme {
  java.util.List listeCotes;
}
```

On va écrire:
```java
import java.util.List;
class Polygone{
  List listeCotes;
}
```

Une fois un `import` fait dans un fichier, il est valide pour tout le fichier.

#### Import de toutes les classes d'un paquet
Il est possible aussi d'importer toutes les classes d'un même paquet en une seule fois avec le joker `*`.

```java
import java.util.*;
class Polygone{
  List listeCotes;
}
```


## Attributs
Les attributs d'une classe sont les éléments contenus par une classe.

Dans l'exemple précédent, l'attribut `nom` permet de stocker le nom de la Forme sous forme d'une chaîne de caractère.

### Attributs d'instance
La valeur d'un attribut est propre à une instance de classe.

Testez le code suivant:
```java
Forme formeA = new Forme();
formeA.nom = "Forme A";
Forme formeB = new Forme();
formeB.nom = "Forme B";
System.out.println(formeA); //Forme A
System.out.println(formeB); //Forme B

```

### Attributs de classe
Il est possible de définir des attributs communs à toutes les instances d'une classe. Ce sont les attributs d'instance.

```java
class Forme{
  String nom;
  static int compteurForme;
}

...
Forme formeA = new Forme();
formeA.compteur = 1;
Forme formeB = new Forme();
formeB.compteur += 1;
System.out.println(formeA.compteur); //2
System.out.println(formB.compteur); //2
```


## Méthodes

Une méthode permet de définir un comportement, d'implémenter un algorithme.

Elles sont de deux types:

* les méthodes d'instances, qui s'applique à une instance donnée
* les méthodes de classe : elles sont accessibles directement à partir du nom de la classe.

```java
class Forme{
  static int compteurFormes = 0;

  Forme(){
    compteurFormes++;
  }

  static getNombreDInstances(){
    return compteurFormes;
  }
}

```


## Import statique

Normalement pour utiliser un membre d'une classe, il faut l'écrire explicitement:

```java
double rayon = Math.cos(beta * Math.PI);
```

Les *static import* permettent d'utiliser directement depuis une autre classe des membres statiques d'une classe particulière.

```java
import static java.lang.Math.PI;
import static java.lang.Math.cos;

...

double rayon = cos(beta * PI);
```

**ATTENTION**

Ceci est à utiliser avec précaution et parcimonie !

Il est facile de se retrouver avec des membres avec le même nom que ceux importés  d'une autre classe.

## Constantes et le mot clé 'final'
Les constantes sont des attributs qui ne peuvent plus changer de valeur.

Pour les définir on utilise le mot clé `final`

En fait, tout membre d'une classe ayant un attribut `final` ne pourra plus être modifié ou surchargé.

Ainsi une méthode déclarée `final` ne pourra pas être surchargée par une classe qui hériterait de la classe courante.

```java
class Polygone{
  String nom ;
  final int JE_NE_PEUX_PAS_CHANGER = 0;

  final String getNom(){
    return nom;
  }

  void changer(){
    JE_NE_PEUX_PAS_CHANGER = 1 ; //ERREUR
  }
}
class Triangle{
  String getNom(){ // ERREUR de COMPILATION
  }
}
```


## Conventions de codage
### Définition


C'est un ensemble de règles qui permettent d'écrire un code dans une manière lisible et compréhensible par un maximum de développeurs.

Ces règles évoluent d'un langage à l'autre. En Java, elles sont essentielles car elles permettent, d'un seul coup d'oeil, de déterminer si on a affaire à une classe/un type, une variable/attribut/paramètre ou une constante.

Elles sont là pour améliorer la compréhension des éléments du code et faire en sorte qu'il soit "auto-commenté" le plus possible. C'est à dire que l'on va utiliser des noms qui soient parlant, que ce soit pour les méthodes, attributs, variables ou classes.

'

Un lien vers les conventions de codage telles que définies aux origines du langage Java.
[http://www.oracle.com/technetwork/java/codeconventions-150003.pdf](http://www.oracle.com/technetwork/java/codeconventions-150003.pdf)

Autre lien avec quelques exemples:

[https://en.wikibooks.org/wiki/Java_Programming/Coding_conventions](https://en.wikibooks.org/wiki/Java_Programming/Coding_conventions) pour compléter vos connaissances.


### Règle de nommage.
En Java on utilise la notation CamelCase (casse en dos de chameau). La casse, c'est la différence majuscule/minuscule.

Pour nommer un attribut, une méthode ou une classe, on l'écrit sous la forme de mots accolés, avec la première lettre du mot qui commence par une majuscule.

La première lettre du premier mot est:

* minuscule pour les méthodes, attributs, variables et paramètres.
* majuscule pour les classes.

Exemple:
```java
class FormeSpeciale {
  String leNomDeCetteForme ;

  static final int CODE_FORME = 3;

  String getLeNomDeCetteForme(){
    return leNomDeCetteForme;
  }

  void setLeNomDeCetteForme(String nouveauNom){
    leNomDeCetteForme = nouveauNom;
  }
```

#### Pour les constantes
Pour les constantes on utilise une règle différente: majuscules avec des mots séparés par des tirets-bas (underscore).

```java
final String MA_CONSTANTE = "Je ne changerai jamais !"
```



## Exercices
Ces exercices ont pour but de vous faire pratiquer et découvrir les autres concepts du langage Java.

Vous pouvez vous appuyer sur le livre [Java Programming / Language fundamentals](https://en.wikibooks.org/wiki/Java_Programming/Language_Fundamentals) pour récupérer les informations sur les notions qui vous manquent


### Validité d'une date

Écrire une classe `Date` permettant de tester la validité d'une date saisie par l'utilisateur sous la forme jour/mois/année.

On rappelle que le mois de février compte 29 jours sauf si l'année est bissextile et qu'une année est bissextile si elle est divisible par 4 mais pas par 100 (exception faite des années divisibles par 400, qui sont également bissextiles).

La classe `Date` comportera au minimum les méthodes suivantes:

* `public void setJour(int)`
* `public void setMois(int)`
* `public void setAnnee(int)`
* `public boolean estValide()`
* `public String getRepresentation()`

La classe qui utilisera `Date` et qui permettra la saisie sera nommée `ValiditeDate`.

Elle comportera les fonctions de saisie en proposant à l'utilisateur:

* de saisir une nouvelle date (qui deviendra la date courante)
* d'indiquer la validité de la date courante
* de modifier la date courante (en modifiant soit le jour, le mois ou l'année)
* de supprimer la date courante
* de quitter le programme


#### Concepts abordés
* boolean
* `switch/case`
* `if/else`
* boucles


### Géométrie

Vous allez définir des classes permettant de calculer les caractéristiques géométriques de formes simples.

Pour cela, nous allons définir une classe abstraite:

```java

public abstract class Forme {
    private String type ;
    private String nom;
    public Forme(String type, String nom){
      this.type = type;
      this.nom = nom;
    }

    /** Renvoie la surface de la forme courante */    
    public abstract double getSurface();
    /** Renvoie le périmètre de la forme courante */
    public abstract double getPerimetre();
    /** Fonction qui pose des questions à l'utilisateur pour
    saisir les valeurs nécessaires aux calculs*/
    public void saisirValeurs();

    public String getType(){...}
    public String getNom(){...}
    /**
    Renvoie la concaténation du type et du nom.
    Ex: triangle/bermudes
    */
    public String getRepresentation(){...}
}

```

Une classe abstraite ne peut être instanciée: il est nécessaire d'en hériter pour pouvoir créer un objet de cette classe.

Vous allez donc définir des classes qui en héritent et qui implémenteront ces fonctions de base pour :

* le triangle
* le rectangle
* le carré
* le trapèze

Pour commencer, faites un diagramme UML de toutes ces classes.

Exemple pour le triangle, prévoir des méthodes qui permettent de tester si on a :

* un triangle rectangle
* un triangle équilatéral
* un triangle isocèle

Exemple de nom de méthode: `public boolean estTriangleRectangle()`


Le nombre de côté d'une forme pourra être stocké dans une constante.

### Calculs sur le triangle
Ecrire un programme qui permette de saisir les longueurs de côtés d'un triangle.

Ce programme doit permettre d'afficher le nom et le type de la forme et,
à la demande de l'utilisateur:
* soit la surface
* soit le périmètre du triangle



### Autres formes

Implémentez toutes les formes demandées.

Pour chacune de ces formes, faites en sorte que votre programme puisse gérer les demandes de l'utilisateur données précédemment.


### Gestion d'une liste d'entiers triés


Nous allons définir une classe `TableauEntierTrie` permettant de stocker des entiers dans un tableau d'entier.

Pour cela nous allons définir les méthodes suivantes:
* `void inserer(int valeur)` : insère un entier dans le tableau en respectant l'ordre croissant.
* `void supprimer(int valeur)` : supprime toutes les occurrences de l'entier donnée en paramètre du tableau
* `public String toString()` : récupère une représentation sous forme de chaîne de caractères du tableau

Si le tableau devient trop petit, vous devrez en définir un nouveau plus grand et recopier son contenu.

La classe `EssaiTableauEntierTrie` comportera une méthode `main(String[] args)` et permettra de tester votre classe.

### Gestion d'une liste d'objets

Nous allons cette fois gérer une liste de `Forme`.

La classe à créer est `ListeForme`. Elle comportera comme attributs:
* un tableau de `Forme`
* une valeur entière `longueur` représentant le nombre d'instances actuellement stockées dans la liste.

Elle comportera les méthodes suivantes:

* `void ajouter(Forme forme)` : ajoute une instance de `Forme` à la suite du tableau. Si l'instance est déjà dans le tableau, elle est tout de même ajoutée.
* `int getLongueur()` : récupère la longueur du tableau
* `Forme getForme(int index)`: récupère l'instance de `Forme` positionné à `index` dans le tableau.
* `void supprimerA(int index)` :  supprime l'instance de `Forme` positionné à `index` dans le tableau en décalant toutes les autres instances d'un cran (c'est à dire que la forme positionnée à l'index `i+1` sera recopiée et à l'index `i` et ainsi de suite jusqu'à la fin du tableau). Une fois cela fait, `longueur` est mis à jour.

Implémentez cette classe et testez-là avec la classe nommée `EssaiListeForme`.

Dessinez le diagramme de classe correspondant.

### Utilisation de la liste de Forme

Ecrire une classe `GestionForme` (comportant une méthode `main`) qui demande de saisir une liste de forme à l'utilisateur et d'afficher toutes les caractéristiques des formes.

Par exemple on aura ce type de fonctionnement:

```
Que voulez-faire ?
    1: créer une nouvelle forme
    2: supprimer une forme
    3: afficher les valeurs de périmètres pour toutes les formes
    4: afficher les valeurs des aires pour toutes les formes
    5: quitter le programme
```

L'affichage d'une forme se fera de cette manière:

```
triangle/bermudes : l'aire vaut 500
```


### Carnet d'adresses

Nous allons créer un programme qui permet de gérer un carnet d'adresses.

Avant d'écrire ce programme, établissez la représentation UML sous forme de diagramme de classes.

Pour cela, nous allons définir une classe `Personne` qui permette de stocker:

* un nom
* un prénom
* une liste d'adresses postales
* une liste de numéros de téléphone
* une liste d'adresses électroniques

Dans la liste d'adresses postale, chaque adresse pourra comporter les éléments suivants:

* numéro de rue
* nom de la voie
* complément d'adresse
* type de la voie
* code postal
* localité

Le carnet d'adresse proprement dit pourra gérer plusieurs personnes. Pour cela, vous allez utiliser
les tableaux (array) (voir le chapitre [Java Programming/Arrays](https://en.wikibooks.org/wiki/Java_Programming/Arrays)

Enfin, vous devrez pouvoir faire afficher dans la console:
* soit la liste de toutes les personnes du carnet d'adresse
* soit les informations concernant une seule personne
* soit les informations concernant toutes les entrées du carnet


#### Concepts abordés
* `switch/case`
* `if/else`
* tableaux
* boucles
* représentation textuelle
