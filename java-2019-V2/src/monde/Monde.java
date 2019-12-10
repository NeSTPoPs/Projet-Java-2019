package monde;
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;



import items.CaseBoost;
import items.CaseNormale;
import items.Cassoulet;
import items.Pomme;
import items.Poubelle;
import personnage.Avatar;
import personnage.Creature;

public class Monde extends JPanel implements KeyListener {
	
	public static ArrayList<Item> listeItems = new ArrayList<Item>();
	private static int taille;
	private static int tailleCase;
	private Avatar avatar;
	
	public static int getPositionAlea() {return (int)(Math.random()*taille);}
	
	public Monde(int taille, int tailleCase)
	{
		setPreferredSize(new Dimension(taille*tailleCase, taille*tailleCase));
		Monde.taille     = taille;
		Monde.tailleCase = tailleCase;
		this.avatar = null;
		addKeyListener(this);
		for (int i = 0; i < taille; i++)
		{
			for (int j = 0; j < taille; j++)
			{
				CaseNormale c = new CaseNormale();
				this.ajouterItem(c);
				c.setX(i);
				c.setY(j);
			}
		}
			
	}
	
	public void ajouterBoucle(Monde monde,Item item, int iter)
	{
		for (int i = 0 ; i < iter; i++)
		{
			this.ajouterItem(item.getInstance());
		}
	}
	
	public void setAvatar(Avatar a) {
		this.avatar = a;
	}
	public Avatar getAvatar() {
		return this.avatar;
	}
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		for (Item itemVoisin : listeItems)
		{
			if ( itemVoisin != null )
				itemVoisin.dessiner(g, this);
		}
	}
	
	public void ajouterItem(Item item)
	{
		item.setX(Monde.getPositionAlea());
		item.setY(Monde.getPositionAlea());
		listeItems.add(item);
	}
	
	public void supprimerItem(Item item)
	{
		if (listeItems.contains(item))
		{
			item.setX(-1);
			item.setY(-1);
			listeItems.remove(item);
		}
	}
	
	public Item chercher(int x, int y)
	{
		for (Item item : listeItems)
		{
			if (item.getX() == x && item.getY() == y)
				return item;
		}
		return null;
	}
	
	public int getTailleCase()
	{
		return Monde.tailleCase;
	}
	
	public int getTaille()
	{
		return Monde.taille;
	}
	
	public ArrayList<Item> getVoisins(Item item)
	{
		ArrayList<Item> listeVoisin = new ArrayList<Item>();
		for (Item iFor : listeItems)
		{
			if (iFor != item)
			{
				if (iFor.distance(item) == 0)
					listeVoisin.add(iFor);
			}
		}
		return listeVoisin;
	}
	
	private static String getNomCourt(String nom)
	{
		if (nom.length() >= 4)
			return nom.substring(0, 4);
		else
		{
			switch (nom.length()) {
				case 0:
					return "    ";
				case 1:
					return "  "+nom+" ";
				case 2:
					return " "+nom+" ";
				case 3:
					return nom +" ";
				default:
					return null;
			}
		}
	}
	
	public void afficher()
	{
		String s = "     ";
		for (int i = 0; i < Monde.taille; i++)
		{
			s += Monde.getNomCourt(""+i)+"|";
		}
		
		for (int i = 0; i < Monde.taille; i++)
		{
			s += "\n"+Monde.getNomCourt(""+i)+"|";
			for (int j = 0; j < Monde.taille; j++)
			{
				if (!(this.chercher(i,j) == null))
					s += Monde.getNomCourt(this.chercher(i, j).getNom())+"|";
				else 
					s += Monde.getNomCourt("")+"|";
			}
		}
		System.out.println(s);
	}
	

	@Override
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_UP:
				if(avatar.monter())
				{
					this.repaint();
					avatar.setResteAJouer(avatar.getResteAJouer()-1);
				}
				break;
			case KeyEvent.VK_DOWN :
				if(avatar.descendre())
				{
					this.repaint();
					avatar.setResteAJouer(avatar.getResteAJouer()-1);
				}
				break;
			case KeyEvent.VK_LEFT :
				if(avatar.gauche())
				{
					avatar.setResteAJouer(avatar.getResteAJouer()-1);
					this.repaint();
				}
				break;
			case KeyEvent.VK_RIGHT :
				if(avatar.droite())
				{
					avatar.setResteAJouer(avatar.getResteAJouer()-1);
					this.repaint();
				}
				break;
		}
	    System.out.println(avatar.getResteAJouer()+" coups a jouer");
			
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
	
	}
}
