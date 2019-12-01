package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import monde.Monde;

public class Poubelle extends Acc {
	private double poids;
	public static final Image poubelleImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/Poubelle.png");
	public Poubelle()
	{
		super("Poubelle");
		this.poids = Math.random()*10;
		
	}
	
	public double getPoids()
	{
		return this.poids;
	}
	
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		g.setColor(Color.GRAY);
		g.drawImage(poubelleImage,this.getX()*tc, this.getY()*tc, tc,tc, m);
	}
}
