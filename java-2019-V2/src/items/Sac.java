package items;

import java.awt.Graphics;

import monde.Monde;

public class Sac extends Acc
{
    private Acc [] tab;
    
    public Sac(int n)
    {
        super("Sac");
        this.tab = new Acc [n];
    }
    
    public Sac()
    {
        this( (int)(Math.random()*10) + 1);
    }
    
    public int size()
    {
        int i = 0;
        for (i = 0; i < this.tab.length ; i++)
        {
            if (this.tab[i] == null)
                return i;
        }
        return i;
    } 
    
    public void ajouter(Acc a)
    {
    	if (this.size() >= this.tab.length)
    	{
    		System.out.println("Pas de place");
    		return;
    	}
    	for (int i = 0; i < this.tab.length; i++)
    	{
    		if (this.tab[i] == null)
    		{
    			this.tab[i] = a;
    			return;
    		}
    	}
    	
    }
    
    public Acc obtenir(int i)
    {
    	if ( i > this.size() - 1 )
    	{
    		System.out.println("Fail");
    		return null;
    	}
    	Acc a = this.tab[i];
    	int taille = this.size();
    	this.tab[i] = null;
    	for (int j = i + 1; j < taille; j++ ) //----------------------On d�place les �l�ments dans tab vers la gauche
    	{
    		if (this.tab[j] == null)
    			return a;
    		this.tab[j-1] = this.tab[j];
    		this.tab[j] = null;
     	}
    	return a;
    }
    
    public double getPoids()
    {
        double p = 0;
        for (int i = 0; i < this.size(); i++)
        {
        	p += this.tab[i].getPoids();
        }
        return p;
    }
    
    @Override
    public String toString()
    {
    	String s =super.toString() + String.format(" Contient %d accessoires sur %d places", this.size(), this.tab.length);
    	for (int i = 0; i < this.size(); i++)
    	{
    		s += "\n" + this.tab[i].toString();
    	}
    	return s;
    }
 
} 
