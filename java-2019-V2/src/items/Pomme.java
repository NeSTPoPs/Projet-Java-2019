package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import monde.Item;
import monde.Monde;

public class Pomme extends Acc implements Mangeable
{
	private double rayon;
	public static final Image pommeImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/Pomme.png");
	public Pomme(double rayon)
	{
		super("Pomme");
		this.rayon = rayon; 
	}
	
	public Pomme()
	{
		this(Math.random()*4 + 3);
	}
	
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		g.setColor(new Color(255,0,0));
		g.drawImage(pommeImage,this.getX()*tc, this.getY()*tc, tc,tc, m);
	}
	public double getPoids()
	{
		return (4./3000.)*Math.PI*Math.pow(this.rayon, 3);
	}
	
	public String toString()
	{
		return super.toString() + String.format(" %.1fcm", this.rayon);
	}

	@Override
	public Item getInstance() {
		return new Pomme();
	}
} 
