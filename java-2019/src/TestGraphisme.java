


import javax.swing.*;
import items.*;
import monde.*;
import personnage.Avatar;
import personnage.Creature;


public class TestGraphisme  {
	private static final int TAILLE_CASE=80;
	private static final int NB_CASES=10;
	private static final int NB_COUPS=5;
	
	
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
			if(item == "Boost")
				monde.ajouterItem(new CaseBoost());
			if(item == "Case")
				monde.ajouterItem(new CaseNormale());
		}
	}
	
	public static void main( String [ ] args ) throws InterruptedException {
		// Création fenêtre graphique et ses caractéristiques
		JFrame f = new JFrame () ;
		f.setLocationRelativeTo(null) ;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		                                                  // Création du monde (qui est un panneau )
		Monde m = new Monde(NB_CASES,TAILLE_CASE) ;
		
	
		ajouterBoucle(m, "Case", NB_CASES*TAILLE_CASE);
		ajouterBoucle(m, "Poubelle", (int)(Math.random()*15+10));
		ajouterBoucle(m, "Pomme", (int)(Math.random()*15+10));
		ajouterBoucle(m, "Cassoulet", (int)(Math.random()*15+10));
		ajouterBoucle(m, "Creature", (int)(Math.random()*5+2));
		ajouterBoucle(m, "Boost", (int)(Math.random()*4+2));
		
		
		f.setContentPane (m) ;                            //Ajout du monde à la fenêtre
		f.pack () ;                                         // Adaptation de la fenêtre au panneau
		f.setVisible ( true ) ;
		
		Avatar jake=new Avatar ("Jake" ,79.5 ,m) ;          // ajoute Jake dans le monde
		Avatar mark=new Avatar ("Mark" ,89.5 ,m) ;
	
		m.setAvatar(jake);
		m.ajouterItem(jake);
		m.ajouterItem(mark);
		
	
		
		for ( int i =0;i <10; i++) {
			Thread.sleep(1000) ;                          // Ralenti l’affichage
		
			//---------------------------DEPLACEMENT DE J1------------------------
			System.out.println(String.format("### Déplacement de %s ###", jake.getNom()));
			m.setAvatar(jake);
			
			jake.setResteAJouer(NB_COUPS);
			
			while(jake.getResteAJouer()>0) {
				
				m.setFocusable(true);
				
				m.requestFocusInWindow();
				Thread.sleep(1000) ; 
				
				System.out.println(jake.getResteAJouer()+" coups à jouer");
			}
			
			
			//---------------------------DEPLACEMENT DE J2------------------------
			System.out.println(String.format("### Déplacement de %s ###", mark.getNom()));
			
			
			m.setAvatar(mark);
			// tour de jeu 
			mark.setResteAJouer(NB_COUPS);
			
			while(mark.getResteAJouer()>0) {
				Thread.sleep(1000) ;  
				m.setFocusable(true);
				m.requestFocusInWindow();	
				
				System.out.println(mark.getResteAJouer()+" coups à jouer");
			}
			
                            
		}
		if (mark.course() < jake.course())
		{
			System.out.println(String.format("%s a parcouru plus de distance face à %s !",jake.getNom(),mark.getNom()));
		}
		else
		{
			System.out.println(String.format("%s a parcouru plus de distance face à %s !",mark.getNom(),jake.getNom()));
		}
	}



	
}
