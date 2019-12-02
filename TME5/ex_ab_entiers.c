#include <stdlib.h>
#include <stdio.h>
#include <time.h>
#include "arbre_binaire.h"
#include "fonctions_entiers.h"

int main(void) {
    srand(time(NULL));
    int entier = 50;
    int i = 0;
    PNoeudBinaire  noeud = NULL;
    PArbreBinaire arbre  = creer_arbre(
              1,
			  dupliquer_int,
			  copier_int,
			  detruire_int,
			  afficher_int,
			  comparer_int,
			  ecrire_int,
			  lire_int
			  );
    noeud         = creer_noeud_binaire(arbre, &entier);
	arbre->racine = noeud;
	
	entier = 25;
    noeud->gauche         = creer_noeud_binaire(arbre, &entier);
    entier = 75;
    noeud->droit          = creer_noeud_binaire(arbre, &entier);
    entier = 12;
    noeud->gauche->gauche = creer_noeud_binaire(arbre, &entier);
    entier = 38;
    noeud->gauche->droit  = creer_noeud_binaire(arbre, &entier);
    entier = 66;
    noeud->droit->gauche  = creer_noeud_binaire(arbre, &entier);
    entier = 86;
    noeud->droit->droit   = creer_noeud_binaire(arbre, &entier);
   
    afficher_ab_postfixe(arbre);
  
    printf("\n");
    for(i=0; i<100; i++){
       
        if(chercher_abr(arbre, &i)!=NULL)
            printf("%d\tTrue\n", i);
        else{
            printf("%d ----\n", i);
        }
    }
   
    ecrire_ab(arbre, "monArbre.txt");
    
    detruire_ab(arbre);
    
    printf("\n");
    return 0;
}
