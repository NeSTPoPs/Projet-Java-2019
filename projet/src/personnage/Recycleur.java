package personnage;


import items.Acc;
import items.Mangeable;
import items.Poubelle;
import monde.Item;

public class Recycleur extends Creature {

	public Recycleur() {
		super();
		this.creatureImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/recycleur.png");
		
	}
	
	
	
	public void regurgiter(Acc a)
	{
		this.addPoids(-2*a.getPoids() );
	}
	
	
	@Override
	public void manger()
	{
		for (int i = 0; i < this.leSac.size(); i++)
		{
			Acc a = this.leSac.obtenir(i);
			if (a instanceof Mangeable)
			{
				if(a instanceof Poubelle) {
					this.addPoids(((Mangeable)a).getPoids()); 
					return;
				}
				else
					regurgiter(a);
				
			}
			this.leSac.ajouter(a);
		}
	}
	
	@Override
	public Item getInstance() {
		
		return new Recycleur();
	}
	
	
	
}
