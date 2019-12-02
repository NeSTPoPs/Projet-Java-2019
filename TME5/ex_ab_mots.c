#include <stdlib.h>
#include <stdio.h>
#include "arbre_binaire.h"
#include "fonctions_string.h"

int main(void) {


    PArbreBinaire arbre  = creer_arbre(
              1,
			  dupliquer_str,
			  copier_str,
			  detruire_str,
			  afficher_str,
			  comparer_str,
			  ecrire_str,
			  lire_str
			  );
    lire_abr(arbre, "monDico.txt");
	ecrire_ab(arbre, "monArbre.txt");

  return 0;
}
