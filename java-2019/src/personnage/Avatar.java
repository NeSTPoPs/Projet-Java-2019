package personnage;
import items.*;
import monde.*;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;



public class Avatar extends Personnage 
{
	private ArrayList<Creature> listeAmis; 
	private ArrayList<Acc>      listeAcc ;
	private Monde monde;
	
	public static final Image[] tabCreatureImage = {java.awt.Toolkit.getDefaultToolkit().getImage("resource/Avatar2.png"),
							java.awt.Toolkit.getDefaultToolkit().getImage("resource/Avatar3.png")};
	private int resteAJouer;
	
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		g.setColor(new Color(255,0,0));
		g.drawImage(avatarImage,this.getX()*tc, this.getY()*tc, tc,tc, m);
	}
	public Avatar(String nom, double poids, Monde monde)
	{
		super(nom, poids);
		this.listeAmis = new ArrayList<Creature>();
		this.listeAcc  = new ArrayList<Acc>();
		this.monde = monde;
		resteAJouer = 0;
		this.avatarImage = tabCreatureImage[(int)(Math.random()*2)];
		
	}
	
	public int getResteAJouer() {
		return resteAJouer;
	}
	public void setResteAJouer(int n) {
		resteAJouer = n;
	}
	public boolean estAmi(Creature c)
	{
		return this.listeAmis.contains(c);
	}
	
	public void devenirAmi(Creature c)
	{
		if (!this.estAmi(c))
		{
			listeAmis.add(c);
			System.out.println(this.getNom()+" est devenu ami avec "+c.getNom());
		}
	}
	
	public void perdreAmi(Creature c)
	{
		if (this.estAmi(c))
		{
			listeAmis.remove(listeAmis.indexOf(c));
			System.out.println(this.getNom()+" n'est plus ami avec "+c.getNom());
		}
	}
	
	public void rencontrer(Creature c)
	{
		if (listeAcc.isEmpty())
		{
			perdreAmi(c);
		}
		else
		{	
			System.out.println(String.format("%s donne %s à %s", this.getNom(), listeAcc.get(0).getNom(), c.getNom()));
			if (listeAcc.get(0).getPoids()>0.5)
				this.devenirAmi(c);
			c.ajouter(listeAcc.get(0));
			listeAcc.remove(0);
		}
	}
	
	public double course()
	{
		System.out.println("--------------"+this.getNom()+" fait courir son équipe !--------------");
		double distance = 0;
		for (Creature c : listeAmis)
		{
			c.manger();
			c.courir();
			distance += c.getVitesse() * 1; //-----------------Distance(km) = Vitesse(km/h) * Temps(h)
		}
		return distance;
	}
	
	public Creature getCreaturePlusRapide()
	{
		double vitesseMax = 0;
		Creature creaturePlusRapide = null;
		for (Creature c : listeAmis)
		{
			if (c.getVitesse() > vitesseMax)
				creaturePlusRapide = c;
		}
		return creaturePlusRapide;
	}
	
	public int compterAccMangeable()
	{
		int cpt = 0;
		for (Acc a : listeAcc)
		{
			if (a instanceof Mangeable)
				cpt++;
		}
		return cpt;
	}
	
	public void ramasser(Acc a)
	{
		listeAcc.add(a);
		monde.supprimerItem(a);
		System.out.println(this.toString() +" ramasse " +a.toString());
	}
	
	public void rencontrerVoisins()
	{
		for (Item i : monde.getVoisins(this))
		{
			if (i != this)
			{
				if (i instanceof Acc)
					this.ramasser((Acc) i);
				if (i instanceof Creature)
					this.rencontrer((Creature) i);
				if (i instanceof Avatar)
					System.out.println(String.format("%s et %s se saluent avant la course", this.getNom(), i.getNom()));
				if (i instanceof CaseSpeciale)
					((CaseSpeciale)i).effet(this);
			}
		}
	}

	//////
	////
	//       Fonctions de déplacement
	////
	//////


	
	public boolean descendre()
	{
		//if( (this.getY()+1) < monde.getTaille()-1) 
	//		return false;
		int y = this.getY()+1 ;
		this.setY(y);
	//this.setX(this.getX()+1);
		
		return true;
	}
	
	public boolean monter()
	{
		//if( (this.getY()-1) < 0) 
			//return false;
		int y = this.getY()-2 ;
		this.setY(y);
	//	this.setX(this.getX()+1);
		
		return true;
	}
	
	public boolean gauche()
	{
	
		
		int x = this.getX()-1;
		this.setX(x);
		
		return true;
	}
	
	public boolean droite()
	{
		if( this.getX()+1 > monde.getTaille()-1)
			return false;
		this.setX(this.getX()+1);
		return true;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %d ami(s) %d accessoire(s)", super.toString(), listeAmis.size(), listeAcc.size() );
	}

	
	
}
