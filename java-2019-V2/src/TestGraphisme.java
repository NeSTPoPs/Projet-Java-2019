


import javax.swing.*;
import items.*;
import monde.*;
import personnage.Avatar;
import personnage.Creature;


public class TestGraphisme  {
	private static final int TAILLE_CASE=60;
	private static final int NB_CASES=15;
	private static final int NB_COUPS=5;
	
	
	public static void ajouterBoucle(Monde monde, String item, int iter)
	{
		for (int i = 0; i < iter; i++)
		{
			if(item == "Case")
				monde.ajouterItem(new CaseNormale());
		  if(item == "Boost")
				monde.ajouterItem(new CaseBoost());
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
	
	public static void main( String [ ] args ) throws InterruptedException {
		// Creation fenetre graphique et ses caracteristiques
		JFrame f = new JFrame () ;
		f.setLocationRelativeTo(null) ;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
		                                                  // Creation du monde (qui est un panneau )
		Monde m = new Monde(NB_CASES,TAILLE_CASE) ;
		
	
		ajouterBoucle(m, "Case", NB_CASES*TAILLE_CASE);
		ajouterBoucle(m, "Poubelle", (int)(Math.random()*10+10));
		ajouterBoucle(m, "Pomme", (int)(Math.random()*10+10));
		ajouterBoucle(m, "Cassoulet", (int)(Math.random()*10+10));
		ajouterBoucle(m, "Creature", (int)(Math.random()*10+2));
		ajouterBoucle(m, "Boost", (int)(Math.random()*10+5));
		
		
		f.setContentPane (m) ;                            //Ajout du monde a la fenetre
		f.pack () ;                                         // Adaptation de la fenetre au panneau
		f.setVisible ( true ) ;
		
		Avatar jake=new Avatar ("Jake" ,79.5 ,m) ;          // ajoute Jake dans le monde
		Avatar mark=new Avatar ("Mark" ,89.5 ,m) ;
	
		m.setAvatar(jake);
		m.ajouterItem(jake);
		m.ajouterItem(mark);
		
	
		
		for ( int i =0;i <10; i++) {
		
			//---------------------------DEPLACEMENT DE J1------------------------
			System.out.println(String.format("### Deplacement de %s ###", jake.getNom()));
			m.setAvatar(jake);
			m.getAvatar().setImage(m.getAvatar().avatarImages[2]);
			jake.setResteAJouer(NB_COUPS);
			
			while(jake.getResteAJouer() > 0) {
				m.setFocusable(true);
				m.requestFocusInWindow();
				;
			}
			m.getAvatar().setImage(m.getAvatar().avatarImages[1]);
			
			//---------------------------DEPLACEMENT DE J2------------------------
			System.out.println(String.format("### Deplacement de %s ###", mark.getNom()));
			m.setAvatar(mark);
			m.getAvatar().setImage(m.getAvatar().avatarImages[2]);
			mark.setResteAJouer(NB_COUPS);
			
			while(mark.getResteAJouer() > 0) {
				m.setFocusable(true);
				m.requestFocusInWindow();	
			}
     m.getAvatar().setImage(m.getAvatar().avatarImages[0]);                      
		}
		if (mark.course() < jake.course())
		{
			System.out.println(String.format("%s a parcouru plus de distance face a %s !",jake.getNom(),mark.getNom()));
		}
		else
		{
			System.out.println(String.format("%s a parcouru plus de distance face a %s !",mark.getNom(),jake.getNom()));
		}
	}



	
}