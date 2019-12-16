Par Quentin Bellut et Matthieu de Castelbajac
# NOM DU JEU

![image](https://user-images.githubusercontent.com/47456539/70750135-166a7c80-1d2e-11ea-93e0-5a05082804fa.PNG)


#### Résumé : Création d'un mini jeu vidéo sous Java dans l'optique d'exploiter les outils de la programmation orientée objet.
         
## Q15 : Principe et fonctionnement : (2 joueurs)

  Le jeu se joue en tour par tour. 
  A chaque tour le joueur peut se déplacer, ramasser les objets qu'il croise et intéragir avec des créatures (pnj).
  En échange d'objets, les créature le rallieront.
  A la fin des X tours, les créatures concourent et  le joueur qui à la meilleure équipe remporte le match.
  Gare aux faux pas ! les objets doivent être ramassés intelligemment car les créatures ne feront pas toujours le tri dans ce que les joueurs leur proposeront.
  


## Q16, Q17, Q18 et Q20 : Ajouts et spécificités

  ### Items
  #### Q16 : Accessoires 
  Ajout de deux accessoires supplémentaires mangeables, sous conditions : 
  * La pomme dorée : la pommme dorée sert à recruter L'Enchanteresse *(voir ci-dessous)*. Elle ne pèse rien et n'a donc pas d'effet sur les autres créatures.
  * Les poubelles : les poubelles pèsent plus lourd et désavantagent les créatures, sauf les recycleurs qui en tirent de grands bénéfices.
  #### Q18 : Autres items
  Ajouts des cases spéciales (Items à deux niveaux d'héritage) :
  * Cases Normales : elles servent à stocker l'image des cases et ses coordonnées. Elle permettent d'afficher le plateau de jeu (l'arrière plan).
  * Cases Boost : elles permettent au joueur qui s'y trouve ou qui passe dessus de gagner un bonus de déplacement pendant son tour.
  
  ### Personnages
  #### Q17 : Créatures
  Ajout de deux créatures spéciales :
  * L'Enchanteresse : L'Enchanteresse ne participe pas à la course, mais donne un bonus de vitesse à toutes les créatures alliées à la fin de la partie. Elle ne peut être recrutée qu'avec la pomme dorée.
  * Les recycleurs : les éboueurs acceptent tous les accessoires mangeables, recyclent très bien les poubelles, mais leurs performances sont drastiquement réduites par la consommation de produits frais. 
 
  ### Q20 :       
  ### Monde  
  #### Déplacements
  Ajout de l'interface KeyListener() 
  :warning: non optimale 
  
  #### Méthode pour se déplacer:  
  KeyListener requiert le focus (l'attention) d'une instance précise -- ici notre monde -- et ne peut donc déplacer qu'un objet à la fois. Cela à nécessité l'ajout d'un attribut Avatar pour le monde, afin de gérer les multiples déplacements. Si aucun avatar ne peut se déplacer (exemple à la fin de la partie), cette variable est vide.  
  Dans notre version, nous avons fais le choix de se déplacer case par case plutôt que de choisir la ligne et la colonne pour se déplacer. Toutefois, l'ancienne methode de déplacement est disponible dans l'ancienne version du projet.  
  #### Contrôles:   
  UP    : Se déplacer en haut  
  DOWN  : Se déplacer en bas  
  LEFT  : Se déplacer à gauche  
  RIGHT : Se déplacer à droite  
  
  ### Main  
  #### Génération du monde
  * Ajout méthode getInstance() : Permet d'éviter une duplication du code lors de la génération des items, et de leur ajout dans le monde. Elle retourne une nouvelle instance de même type et permet ainsi de dupliquer un objet sans besoin de savoir son type.
  ### Fonctionnement du jeu
  * Ajout d'un menu textuel qui permet de choisir le nombre de joueurs et leurs noms. Le jeu devient donc jouable de 1 à X joueurs.
  
  
  
