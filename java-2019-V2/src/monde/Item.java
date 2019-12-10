package monde;

import java.awt.*;

public abstract class Item 
{
	private final String nom;
	private int x;
	private int y;
	
	public Item(String nom, int x, int y)
	{
		this.nom = nom;
		this.y   = y;
		this.x   = x;
	}
	
	public Item(String nom)
	{
		this(nom, -1 , -1);
	}
	
	public abstract Item getInstance();
	
	public int getX(){return this.x;}
	public int getY(){return this.y;}
	
	protected void setX(int x) {this.x = x;}
	protected void setY(int y) {this.y = y;}
	
	public String getNom() {return this.nom;}
	@Override
	public String toString() {return nom+"("+x+","+y+")";}
	
	public int distance(Item item)
	{
		return Math.abs(x-item.x)+Math.abs(y-item.y); //------Distance de Manhattan
	}
	
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		g.setColor(new Color(0,0,255));
		g.fillRect(this.getX() * tc, this.getY() * tc, tc, tc);
	}
	
}