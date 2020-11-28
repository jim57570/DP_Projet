package mesmaths.geometrie.base;

public class VecteurDartevelleVichard extends Vecteur{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8722960597758538252L;
	
	
	/**
	 * fait la valeur absolue de chaque coordonnées (x,y)  
	 * 
	 * */
	public void vecteurAbsolue() {
		this.x = Math.abs(x);
		this.y = Math.abs(y);
	}
	
	/**
	 * retourne vrai si les coordonnées (x,y) sont inférieurs au double  
	 * 
	 * */
	public boolean isCoordInfTo(Double z) {
		if(this.x<=z && this.y<=z)
			return true;
		else 
			return false;
	}


	public VecteurDartevelleVichard() {
		super();
		// TODO Auto-generated constructor stub
	}


	public VecteurDartevelleVichard(double x, double y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}


	public VecteurDartevelleVichard(String string) {
		super(string);
		// TODO Auto-generated constructor stub
	}


	public VecteurDartevelleVichard(StringBuffer string) {
		super(string);
		// TODO Auto-generated constructor stub
	}


	public VecteurDartevelleVichard(Vecteur v) {
		super(v);
		// TODO Auto-generated constructor stub
	}

}
