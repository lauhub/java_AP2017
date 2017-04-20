# Travailler avec les objets

## Contrôle des accès

Les classes, attributs ou méthodes peuvent être accessibles
(on dit aussi visibles) ou non à l'intérieur d'autres classes, qu'elles soient du même package ou pas.

Pour indiquer les degrés d'accessibilités on utilise des modificateurs d'accessibilité (*access modifiers*).

On utilise pour cela ces trois mots clés:

* private
* protected
* private

|--------------|--------------|--------------|
| Modificateur |Applicable à  | Signification|
|--------------|--------------|--------------|
|              | classe       | est visible partout |
|   `public`   |              |                     |
|              | membre       |visible partout ou sa classe est visible |                     |
|              |              |                     |
|              |              |                     |
|              |              |                     |
|              |              |                     |
|              |              |                     |
