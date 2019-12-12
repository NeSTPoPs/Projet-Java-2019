Par Quentin Bellut et Matthieu de Castelbajac
# NOM DU JEU

![image](https://user-images.githubusercontent.com/47456539/70671291-d5b22b00-1c7b-11ea-95f2-9dd5f688013d.PNG)

#### Résumé : Création d'un mini jeu vidéo sous Java dans l'optique d'exploiter les outils de la programmation orientée objet.
         
## Principe et règles du jeu : (2 joueurs)

  Le jeu se joue en tour par tour. 
  A chaque tour le joueur peut se déplacer, ramasser les objets qu'il croise et intéragir avec des créatures (pnj).
  En échange d'objets, les créature le rallieront.
  A la fin des X tours, les créatures concourent et  le joueur qui à la meilleure équipe remporte le match.
  Gare aux faux pas ! les objets doivent être ramassés intelligemment car les créatures ne feront pas toujours le tri dans ce que les joueurs leur proposeront.
  
## Diagramme UML (?)

## Ajouts et spécificités

  ### Items
  #### Accessoires 
  Ajout de deux accessoires supplémentaires mangeables, sous conditions : 
  * La pomme dorée : la pommme dorée sert à recruter L'Enchanteresse *(voir ci-dessous)*. Elle ne pèse rien et n'a donc pas d'effet sur les autres créatures.
  * Les poubelles : les poubelles pèsent plus lourd et désavantagent les créatures, sauf les recycleurs qui en tirent de grands bénéfices.
  #### Autres items
  Ajouts des cases spéciales:
  * Cases Normales : elles servent à stocker l'image des cases et ses coordonnées. Elle permettent d'afficher le plateau de jeu (l'arrière plan).
  * Cases Boost : elles permettent au joueur qui s'y trouve ou qui passe dessus de gagner un bonus de déplacement pendant son tour.
  
  ### Personnages
  #### Créatures
  Ajout de deux créatures spéciales :
  * L'Enchanteresse : L'Enchanteresse ne participe mais donne un bonus de vitesse à toutes les créatures alliées à la fin de la partie. Elle ne peut être recrutée qu'avec la pomme dorée.
  * Les recycleurs : les éboueurs acceptent tous les accessoires mangeables, recyclent très bien les poubelles, mais leurs performances sont drastiquement réduites par la consommation de produits frais. 
 
  ### Monde  
  #### Déplacements
  Ajout de l'interface KeyListener() 
  :warning: pas optimisée et risquée...
  
  Ajout d'un attribut Avatar
  ...
  ### Main
  #### Génération du monde
  * Ajout méthode getInstance : à complétér .........................
  * ...
  #### Gestion des avatars 
  ...
  
