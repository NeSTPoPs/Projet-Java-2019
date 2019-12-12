
import java.util.Scanner;
import javax.swing.*;
import items.*;
import monde.*;
import personnage.Avatar;
import personnage.Creature;
import personnage.Enchanteresse;
import personnage.Recycleur;


public class TestGraphisme  {
	private static final int TAILLE_CASE=100;
	private static final int NB_CASES=10;
	private static final int NB_COUPS=5;
	
	public static void main( String [ ] args ) throws InterruptedException {
		
		
		

		JFrame f = new JFrame () ;
		f.setLocationRelativeTo(null) ;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		                                                  // Creation du monde (qui est un panneau )
		Monde m = new Monde(NB_CASES,TAILLE_CASE) ;
		
		m.ajouterBoucle(m, new CaseBoost(), (int)(Math.random()*10+5));
		m.ajouterBoucle(m, new Poubelle(), (int)(Math.random()*10+10));
		m.ajouterBoucle(m, new Pomme(), (int)(Math.random()*10+10));
		m.ajouterBoucle(m, new PommeDoree(), (int)(Math.random()*2+1));
		m.ajouterBoucle(m, new Creature(), (int)(Math.random()*10+2));
		m.ajouterBoucle(m, new Recycleur(), (int)(Math.random()*5+2));
		m.ajouterBoucle(m, new Enchanteresse(), (int)Math.random()*2+1);
		
		f.setContentPane (m) ;                            //Ajout du monde a la fenetre
		f.pack () ;                                         // Adaptation de la fenetre au panneau
		f.setVisible ( true ) ;

		int nbJoueur = 0;
		while (nbJoueur < 1)
		{
			Scanner sc  = new Scanner(System.in);
			System.out.println("Veuillez indiquer le nombre de joueurs (>=1): ");
			if (sc.hasNextInt())
			{
				
				nbJoueur = sc.nextInt();
			}
		}
		Avatar[] tabAvatar = new Avatar[nbJoueur];
		for (int i = 0; i < nbJoueur; i++)
		{
			Scanner sc  = new Scanner(System.in);
			String name = "Bob";
			System.out.println("Nom J"+i +" :");
			if (sc.hasNext())
				name = sc.nextLine();
			tabAvatar[i]   = new Avatar(name , Math.random()*100 + 50 ,m);
			
			m.ajouterItem(tabAvatar[i]);
			m.repaint();
			if (i == nbJoueur - 1)
				sc.close();
		}
		
		
		
		
		
		for (int tour = 0; tour < 5; tour++) {
			for ( int i =0;i < nbJoueur; i++) {
			
				//---------------------------DEPLACEMENT DE JOUEUR------------------------
				System.out.println(String.format("### Deplacement de %s ###", tabAvatar[i].getNom()));
				m.setAvatar(tabAvatar[i]);
				m.getAvatar().setImage(Avatar.avatarImages[2]);
				m.repaint();
				tabAvatar[i].setResteAJouer(NB_COUPS);
				
				while(tabAvatar[i].getResteAJouer() > 0) {
					
					m.setFocusable(true);
					m.requestFocusInWindow();
					
					;
				}
				m.getAvatar();
				m.getAvatar().setImage(Avatar.avatarImages[1]);
			}
		}
		
		
		
		
		
		
		m.setAvatar(null);
		Avatar gagnant  = null;
		double distanceMax = 0;
        for (int i = 0; i < tabAvatar.length; i++)
        {
        	double distance = tabAvatar[i].course();
        	if (distance > distanceMax)
        	{
        		distanceMax = distance;
        		gagnant     = tabAvatar[i];
        	}
        }
		System.out.println(String.format("%s gagne la course !",gagnant.getNom()));
	}

	
}
