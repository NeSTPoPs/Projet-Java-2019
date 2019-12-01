import items.*;
import personnage.*;
import monde.*;

public class TestProjet {
	public static void ajouterBoucle(Monde monde, String item, int iter)
	{
		for (int i = 0; i < iter; i++)
		{
			if (item == "Pomme")
				monde.ajouterItem(new Pomme());
			if (item == "Cassoulet")
				monde.ajouterItem(new Cassoulet());
			if (item == "Poubelle")
				monde.ajouterItem(new Poubelle());
			if (item == "Creature")
				monde.ajouterItem(new Creature());
		}
	}
	public static void main(String[] args) {
		Monde monde = new Monde(10,10);
		ajouterBoucle(monde, "Poubelle", (int)(Math.random()*30));
		ajouterBoucle(monde, "Cassoulet", (int)(Math.random()*4));
		ajouterBoucle(monde, "Creature", (int)(Math.random()*30 + 1));
		ajouterBoucle(monde, "Pomme", (int)(Math.random()*15 + 5));
		monde.afficher();
		Avatar j1 = new Avatar("Jean",70,monde);
		Avatar j2 = new Avatar("Marc",60,monde);
		monde.ajouterItem(j1);
		monde.ajouterItem(j2);
		//--------------------------------------DEBUT DU JEU-------------------------------------------------------------
		for (int i = 0; i < 5; i++)
		{
			System.out.println("-----------------------------TOUR N°"+i+"-----------------------------");
			j1.seDeplacer();
			j1.rencontrerVoisins();
			monde.afficher();
			j2.seDeplacer();
			j2.rencontrerVoisins();
			monde.afficher();
		}
		if (j1.course() < j2.course())
		{
			System.out.println(String.format("%s a parcouru plus de distance face à %s !",j1.getNom(),j2.getNom()));
		}
		else
		{
			System.out.println(String.format("%s a parcouru plus de distance face à %s !",j2.getNom(),j1.getNom()));
		}
	}

}
