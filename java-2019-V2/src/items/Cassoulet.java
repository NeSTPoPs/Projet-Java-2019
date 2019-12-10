package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import monde.Monde;

public class Cassoulet extends Acc implements Mangeable
{
	private double poids;
	private static Image cassoulet;
	public static final Image cassouletImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/Cassoulet.png");
	public Cassoulet(double poids)
	{
		super("Cassoulet");
		this.poids = poids; 
	}
	
	public Cassoulet()
	{
		this(Math.random()*3 + 3);
	}
	
	public double getPoids()
	{
		return this.poids;
	}
	
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		g.drawImage(cassouletImage,this.getX()*tc, this.getY()*tc, tc,tc, m);
	}
	
	public String toString()
	{
		return super.toString() + String.format(" %.1fkg", this.poids);
	}

} 
