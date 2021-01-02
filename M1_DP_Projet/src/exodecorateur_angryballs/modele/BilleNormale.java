package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

/**
 * Repr�sente une bille ordinaire avec l'acc�l�ration 1 (soit mouvement rectiligne uniforme)
 * @author Jimmy
 *
 */
public class BilleNormale extends Bille {
	
	public  Vecteur position;   // centre de la bille
	public  double rayon;            // rayon > 0
	public  Vecteur vitesse;
	public  Vecteur acc�l�ration;
	public int clef;                // identifiant unique de cette bille

	private Color couleur;
	private Color haloColor = Color.CYAN;

	public Color getHaloColor() {
		return haloColor;
	}

	public void setHaloColor(Color haloColor) {
		this.haloColor = haloColor;
	}

	private static int prochaineClef = 0;

	public static double ro = 1;        // masse volumique
		
	/**
	 * @param position
	 * @param rayon
	 * @param vitesse
	 * @param couleur
	 */
	public BilleNormale(Vecteur position, double rayon, Vecteur vitesse, Color couleur) {
		
		this(position,rayon,vitesse,new Vecteur(),couleur);
	}
	
	/**
	 * @param centre
	 * @param rayon
	 * @param vitesse
	 * @param acc�l�ration
	 * @param couleur
	 */
	protected BilleNormale(Vecteur centre, double rayon, Vecteur vitesse, Vecteur acc�l�ration, Color couleur) {
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.acc�l�ration = acc�l�ration;
		this.couleur = couleur;
		this.clef = BilleNormale.prochaineClef ++;
	}
	
	
	/**
	 * @return the position
	 */
	public Vecteur getPosition() {
		return this.position;
	}
	
	/**
	 * @return 
	 */
	public void setPosition(Vecteur position)
	{
		this.position = position;
	}

	/**
	 * @return the rayon
	 */
	public double getRayon() {
		return this.rayon;
	}

	/**
	 * @return the vitesse
	 */
	public Vecteur getVitesse() {
		return this.vitesse;
	}
	
	public void setVitesse(Vecteur vitesse) {
		this.vitesse = vitesse;
	}

	/**
	 * @return the acc�l�ration
	 */
	public Vecteur getAcc�l�ration() {
		return this.acc�l�ration;
	}

	/**
	 * @return the clef
	 */
	public int getClef() {
		return this.clef;
	}
	
	public double masse() {
		return ro*Geop.volumeSph�re(rayon);
	}
	
	
	/**
	 * calcul (c-�-d mise � jour) �ventuel  du vecteur acc�l�ration. 
	 * billes est la liste de toutes les billes en mouvement
	 * Cette m�thode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
	 * La nature du calcul du vecteur acc�l�ration de la bille  est d�finie dans les classes d�riv�es
	 * A ce niveau le vecteur acc�l�ration est mis � z�ro (c'est � dire pas d'acc�l�ration)
	 * */
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.getAcc�l�ration().set(Vecteur.VECTEURNUL);
	}
	
	public void dessine (Graphics g) {
	    int width, height;
	    int xMin, yMin;
	    
	    xMin = (int)Math.round(position.x-rayon);
	    yMin = (int)Math.round(position.y-rayon);
	
	    width = height = 2*(int)Math.round(rayon); 
	
	    g.setColor(couleur);
	    g.fillOval( xMin, yMin, width, height);
	    g.setColor(haloColor);
	    g.drawOval(xMin, yMin, width, height);
	    
    }
	
	public String toString()  {
		return "centre = " + position + " rayon = "+rayon +  " vitesse = " + vitesse + " acc�l�ration = " + acc�l�ration + " couleur = " + couleur + "clef = " + clef;
    }

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonn�eCoinHautGauche, double largeur, double hauteur) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

	@Override
	public void setAcc�l�ration(Vecteur acc�l�ration) {
		this.acc�l�ration = acc�l�ration;
		
	}
}
