package items;

import java.awt.Graphics;
import java.awt.Image;

import monde.Item;
import monde.Monde;
import personnage.Avatar;

public class CaseNormale extends CaseSpeciale {
	
	public static final Image image = java.awt.Toolkit.getDefaultToolkit().getImage("resource/case.png");
	public CaseNormale(String nom, int x, int y) {
		super(nom, x, y);
		// TODO Auto-generated constructor stub
	}

	public CaseNormale() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effet(Avatar a) {
		// NONE
	}

	@Override
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		//g.setColor(Color.GRAY);
		g.drawImage(image,this.getX()*tc, this.getY()*tc, tc,tc, m);
	}

	@Override
	public Item getInstance() {
		return new CaseNormale();
	}

}
