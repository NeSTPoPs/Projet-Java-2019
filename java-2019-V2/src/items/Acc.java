package items;



import monde.Item;


public abstract class Acc extends Item
{
    public static int cpt = 0;
    private int numero;
    
    protected Acc(String categorie){
    	super(categorie);
        this.numero    = cpt;
        Acc.cpt++;
    }
    
    public abstract double getPoids();
   
    @Override
    public String toString()
    {
        String s = String.format("%s No %d %.2fkg",this.getNom(), this.numero, this.getPoids());
        return s;
    }
} 
