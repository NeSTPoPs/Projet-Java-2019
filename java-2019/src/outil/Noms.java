package outil;
import java.util.ArrayList;

public class Noms {
	public final static String [] tabNoms =
			       {"Jojo", "Bertrand", "Josette", "Gérard", "Adolf", "Bourpi", "Gloumax", "Frodon", "Micheline", "Ghislaine",
					"Huguette", "Kozak", "Josiane", "Germaine" ,"Michel", "Michelle", "Joséphine", "Gertrude", "Bernard","Simone",
					"Jacquie", "Kevin", "Rémi", "Jacqueline", "Guy", "Françoise", "Bernadette", "Josette", "Dieu", "Viviane"};
	
	private static ArrayList<String> tabNomsDonne        = new ArrayList<String>();
	private static ArrayList<Integer>    tabCptNomsDonne = new ArrayList<Integer>();
	
	public static String getNom()
	{
		
		String name = Noms.tabNoms[(int)(Math.random()*Noms.tabNoms.length)];
		boolean isIn =  Noms.tabNomsDonne.contains(name);
		if (isIn)
		{
			int i = tabNomsDonne.indexOf(name);
			tabCptNomsDonne.set(i, tabCptNomsDonne.get(i) + 1);
			name += tabCptNomsDonne.get(i);
		}
		else
		{
			tabNomsDonne.add(name);
			tabCptNomsDonne.add(1);
		}
		return name;
	}
}
