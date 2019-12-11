package items;

import java.awt.Graphics;

import monde.Item;
import monde.Monde;
import personnage.Avatar;

public abstract class CaseSpeciale extends Item {
	
	protected Monde monde;
	
	public CaseSpeciale(String nom, int x, int y) {
		super(nom, x, y);
		// TODO Auto-generated constructor stub
		this.monde = null;
	}

	public CaseSpeciale() {
		super("Case");
		this.monde = null;
	}
	
	public abstract void effet(Avatar a);

	public abstract void dessiner(Graphics g, Monde m);

}
