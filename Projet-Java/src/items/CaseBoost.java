package items;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import monde.Monde;
import personnage.Avatar;

public class CaseBoost extends CaseSpeciale {
	public static final Image image = java.awt.Toolkit.getDefaultToolkit().getImage("resource/case_spe.png");

	public CaseBoost(String nom, int x, int y) {
		super(nom, x, y);
		// TODO Auto-generated constructor stub
	}

	public CaseBoost() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void effet(Avatar a) {
		
		// Le personnage a deux déplacements supplémentaires
		a.setResteAJouer(a.getResteAJouer()+2);
	
	}
	public void dessiner(Graphics g, Monde m) {
		int tc = m.getTailleCase();
		//g.setColor(Color.GRAY);
		g.drawImage(image,this.getX()*tc, this.getY()*tc, tc,tc, m);
	}

}
