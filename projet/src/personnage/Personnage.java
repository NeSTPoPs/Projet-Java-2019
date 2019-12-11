package personnage;

import monde.Item;

public abstract class Personnage extends Item
{
	private double poids;
	
	protected Personnage(String nom, double poids)
	{
		super(nom);
		this.poids = poids;
	}
	
	protected Personnage(String nom)
	{
		this(nom, Math.random()*100 + 30);
	}
	
	protected void addPoids(double poids)
	{
		if (poids>0) this.poids += poids;
	}
	
	@Override
	public String toString()
	{
		return String.format("%s %.1fkg", this.getNom(), this.poids);
	}
	
	protected double getPoids()
	{
		return this.poids;
	}
}
