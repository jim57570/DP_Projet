package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

/**
 * Représente une bille ordinaire avec l'accélération 1 (soit mouvement rectiligne uniforme)
 * @author Jimmy
 *
 */
public class BilleNormale extends Bille {
	
	public  Vecteur position;   // centre de la bille
	public  double rayon;            // rayon > 0
	public  Vecteur vitesse;
	public  Vecteur accélération;
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
	 * @param accélération
	 * @param couleur
	 */
	protected BilleNormale(Vecteur centre, double rayon, Vecteur vitesse, Vecteur accélération, Color couleur) {
		this.position = centre;
		this.rayon = rayon;
		this.vitesse = vitesse;
		this.accélération = accélération;
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
	 * @return the accélération
	 */
	public Vecteur getAccélération() {
		return this.accélération;
	}

	/**
	 * @return the clef
	 */
	public int getClef() {
		return this.clef;
	}
	
	public double masse() {
		return ro*Geop.volumeSphère(rayon);
	}
	
	
	/**
	 * calcul (c-à-d mise à jour) éventuel  du vecteur accélération. 
	 * billes est la liste de toutes les billes en mouvement
	 * Cette méthode peut avoir besoin de "billes" si this subit l'attraction gravitationnelle des autres billes
	 * La nature du calcul du vecteur accélération de la bille  est définie dans les classes dérivées
	 * A ce niveau le vecteur accélération est mis à zéro (c'est à dire pas d'accélération)
	 * */
	public void gestionAccélération(Vector<Bille> billes) {
		this.getAccélération().set(Vecteur.VECTEURNUL);
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
		return "centre = " + position + " rayon = "+rayon +  " vitesse = " + vitesse + " accélération = " + accélération + " couleur = " + couleur + "clef = " + clef;
    }

	@Override
	public void collisionContour(double abscisseCoinHautGauche, double ordonnéeCoinHautGauche, double largeur, double hauteur) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

	@Override
	public void setAccélération(Vecteur accélération) {
		this.accélération = accélération;
		
	}
}
