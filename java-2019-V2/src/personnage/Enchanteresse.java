package personnage;

public class Enchanteresse extends Creature {

	public Enchanteresse() {
		// TODO Auto-generated constructor stub
		this.creatureImage = java.awt.Toolkit.getDefaultToolkit().getImage("resource/enchanteresse.png");
	}

	public double getVitesse()
	{
		return 0;
	}
	
	public void courir()
	{
		System.out.println("L'enchanteresse encourage son �quipe ! Leur vitesse est multipli�e par 1.25");
	}
	
	
}
