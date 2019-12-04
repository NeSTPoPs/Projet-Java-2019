package personnage;

import java.awt.Image;

import items.Acc;
import items.Mangeable;

public class Enchanteresse extends Creature {

	public Enchanteresse() {
		this.creatureImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/enchanteresse.png");
	}
	
	public double getVitesse()
	{
		return 0;
	}
	
	public void manger()
	{
	}
	
	public void courir()
	{
	}
}
