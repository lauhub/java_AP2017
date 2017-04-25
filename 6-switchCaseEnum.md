# Introduction

Au cours de cette session, nous allons étudier différentes
fonctionnalités pratiques du langage Java:

-   les switch-case
-   les `Enum`

## Switch-case

### Les cascades de if-else

On peut critiquer le code suivant du point de vue de :

-   son efficacité
-   sa lisibilité

```java
        private void choixAvecIfElse(int valeurChoix){
            if(valeurChoix == 1){
                System.out.println("Menu Préférences");
            }
            if (valeurChoix == 2){
                System.out.println("Menu Edition");
            }
            if (valeurChoix == 3){
                System.out.println("Bonjour");
            }
            if (valeurChoix == 4){
                System.out.println("Au revoir");
            }
            if (valeurChoix == 5){
                System.exit(0);
            }else {
                System.out.print("Saisir votre choix (1,2,3,4 ou 5) : ");
            }
        }
```


### La structure de branchement switch-case

Voici un code équivalent avec une structure `switch-case`.



```java
  private void choixAvecSwitch(int valeurChoix){
      switch(valeurChoix){
      case 1: System.out.println("Menu Préférences");
          break;
      case 2: System.out.println("Menu Edition");
          break;
      case 3: System.out.println("Bonjour");
          break;
      case 4: System.out.println("Au revoir");
          break;
      case 5: System.exit(0);
      default:
          System.out.print("Saisir votre choix (1,2,3,4 ou 5) : ");
      }
  }
```

Commentez son efficacité et sa lisibilité.


### String et switch-case

Il est possible de faire des switch-case sur des String depuis la
version 7 de Java. Vous serez peut-être amenés à maintenir du code avec
une version plus ancienne.

Vous ne pourrez donc pas utiliser la syntaxe suivante :

```java
    switch(choix){
    case "1": System.out.println("Menu Préférences");
    break;
    case "2": System.out.println("Menu Edition");
    break;
    default: System.out.println("Recommencez !");
    }
```

## Les Enum

### Les constantes (avant les Enum)

Nous pouvons remplacer les éléments pour chaque `case` d'un `switch` par des constantes:
```java
    switch(choix){
    case CHOIX_MENU_PREFERENCES: System.out.println("Menu Préférences");
    break;
    case CHOIX_MENU_EDITION: System.out.println("Menu Edition");
    break;
    default: System.out.println("Recommencez !");
    }
```

avec les constantes définies comme tel:

```java
  public static final String CHOIX_MENU_PREFERENCES = "1";
  public static final String CHOIX_MENU_PREFERENCES = "2";
```

Ceci rend le code plus lisible. Cependant, il exite un risque pour que deux constantes soient de même valeur:

```java
  public static final String CHOIX_MENU_PREFERENCES = "1";
  public static final String CHOIX_MENU_PREFERENCES = "1";
```

Dans ce cas, le risque de mauvais fonctionement du programme est important, sans qu'il soit nécessairement détecté.

Pour palier à cela, nous pouvons utiliser les `Enum`.

### Définition des Enum

Les `Enum` permettent de définir un set de valeur pour lesquels nous sommes certains que chacune d'elles seront distinctes, tout en étant *typée*.

De plus, elle peuvent être utilisées dans une structure `switch...case` comme n'importe quelle valeur constante, à la différence qu'on est assuré qu'aucune valeur ne peut être confondue avec une autre.

#### Exemple

On définit un Enum à la manière d'une classe, mais avec le mot clé `enum`:
```java
public enum PointsCardinaux {
  NORD, OUEST, SUD, EST;
}
```

Utilisation:

```java
public class EssaiEnum {
	PointCardinal pointCardinal;

	EssaiEnum(PointCardinal pointCardinal){
		this.pointCardinal = pointCardinal;
	}
	public void disMoiTaDirection(){
		switch (pointCardinal) {
		case NORD:
			System.out.println("J'irai plus au Nord !");
			break;
		case OUEST:
			System.out.println("Je suis un peu à l'Ouest !!!");
			break;
		default:
			System.out.println("Je vogue plein "+pointCardinal);
			break;
		}
	}
	public static void main(String[] args) {
    new EssaiEnum(PointCardinal.NORD).disMoiTaDirection();
		new EssaiEnum(PointCardinal.SUD).disMoiTaDirection();
		new EssaiEnum(PointCardinal.EST).disMoiTaDirection();
		new EssaiEnum(PointCardinal.OUEST).disMoiTaDirection();
	}
}
```

L'exécution de ce programme donne:
```
J'irai plus au Nord !
Je vogue plein SUD
Je vogue plein EST
Je suis un peu à l'Ouest !!!
```


### Les Enum comme des objets

On peut gérer les `enum` comme des objets, et leur ajouter des méthodes, des constructeurs:

```java

public enum PointCardinal {
	NORD("Nord"),
	OUEST("Ouest"),
	SUD("Sud"),
	EST ("Est");

	private String representation ;

	PointCardinal(String representation){
		this.index = index;
		this.representation = representation;
	}

	public String toString(){
		return representation;
	}
}
```

En relançant le programme précédent, on obtient:
```
J'irai plus au Nord !
Je vogue plein Sud
Je vogue plein Est
Je suis un peu à l'Ouest !!!
```

On peut ajouter d'autres informations et méthodes:

```java
public enum PointCardinal {
	NORD ( 0,  1, "Nord"),
	OUEST(-1,  0, "Ouest"),
	SUD  ( 0, -1, "Sud"),
	EST  ( 1,  0, "Est");

	private String representation ;
	private int directionX, directionY;

	PointCardinal(int directionX, int directionY, String representation){
		this.directionX = directionX;
		this.directionY = directionY;
		this.representation = representation;
	}
	/**
	 * Permet de définir une direction
	 * selon le système cartésien x,y
	 * @return l'index
	 */
	public int getDirectionX(){
		return directionX;
	}
	public int getDirectionY(){
		return directionY;
	}

	public String toString(){
		return representation;
	}
}
```


Ce qui donnerait avec le programme suivant:
```java
public static void main(String[] args) {
  new EssaiEnum(PointCardinal.NORD).disMoiTaDirection();
  new EssaiEnum(PointCardinal.SUD).disMoiTaDirection();
  new EssaiEnum(PointCardinal.EST).disMoiTaDirection();
  new EssaiEnum(PointCardinal.OUEST).disMoiTaDirection();

  System.out.println("Dans un tableau:");
  dansUnTableau();
}
```
#### Exercice
##### Dates
Reprendre l'exercice sur les dates et créer les Enum pour les mois.
