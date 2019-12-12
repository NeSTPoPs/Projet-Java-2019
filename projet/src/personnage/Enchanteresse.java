package personnage;

import items.Acc;
import items.Mangeable;
import items.Pomme;
import items.PommeDoree;
import monde.Item;

public class Enchanteresse extends Creature {

	public Enchanteresse() {
		super();
		this.creatureImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/enchanteresse.png");
	}

	@Override
	public double getVitesse()
	{
		return 0;
	}
	
	@Override
	public void courir()
	{
		System.out.println("L'enchanteresse encourage son équipe ! Leur vitesse est multipliée par 1.25");
	}
	
	
	@Override
	public boolean accepte(Acc item) 
	{
		return (item instanceof PommeDoree);
	}
	
	@Override
	public Item getInstance() {
		
		return new Enchanteresse();
	}
}
