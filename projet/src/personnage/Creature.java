package personnage;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import items.*;
import monde.Item;
import monde.Monde;
import outil.*;

public class Creature extends Personnage 
{
	protected Sac leSac;
	protected Image creatureImage; 
	public Creature ()
	{
		super(Noms.getNom());
		this.leSac = new Sac();
		this.creatureImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/CreaturePoubelle.png");
	}
	
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		g.setColor(new Color(255,0,0));
		g.drawImage(creatureImage,this.getX()*tc, this.getY()*tc, tc,tc, m);
	}
	
	public void ajouter(Acc a)
	{
		if (a.getPoids() + this.leSac.getPoids() > this.getPoids())
		{
			System.out.println("Trop lourd !");
			return;
		}
		this.leSac.ajouter(a);
	}
	
	public double getVitesse()
	{
		double v = ((1./4.)*this.getPoids() - this.leSac.getPoids());
		if (v < 0)
			return 0;
		return v;
	}
	
	public void manger()
	{
		for (int i = 0; i < this.leSac.size(); i++)
		{
			Acc a = this.leSac.obtenir(i);
			if (a instanceof Mangeable)
			{
				this.addPoids(((Mangeable)a).getPoids()); 
				return;
			}
			this.leSac.ajouter(a);
		}
	}
	
	public void courir()
	{
		System.out.println(String.format("%s court a vitesse %.1f km/h avec %s\n",
				this.toString(), this.getVitesse(), this.leSac.toString()));
	}
	
	
	//*******************//
	//     AJOUTS        //
	//*******************//
	
	
	@Override
	public Item getInstance() {
		return new Creature();
	}
	
	public boolean accepte(Acc item) {
		return (item.getPoids()>0.5);
	}
}
