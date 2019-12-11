package items;

import java.awt.Graphics;
import java.awt.Image;

import monde.Item;
import monde.Monde;

public class PommeDoree extends Pomme implements Mangeable
{
	private static final double GRAND_RAYON = 8.0;
	private double poids;
	public static final Image PommeDoreeImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/PommeDoree.png");
	public PommeDoree()
	{
		super(GRAND_RAYON);
	}
	
	
	public double getPoids()
	{
		return 0; // Elles sont magiques et ne pèsent rien
	}
	
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		g.drawImage(PommeDoreeImage,this.getX()*tc, this.getY()*tc, tc,tc, m);
	}

	@Override
	public Item getInstance() {
		return new PommeDoree();
	}
	public String toString()
	
	{
		return super.toString() + " Pomme Dorée !!!";
	}
} 
