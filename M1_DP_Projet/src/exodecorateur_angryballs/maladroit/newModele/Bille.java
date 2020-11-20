package exodecorateur_angryballs.maladroit.newModele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.OutilsBille;
import mesmaths.cinematique.Cinematique;
import mesmaths.geometrie.base.Geop;
import mesmaths.geometrie.base.Vecteur;

/**
 * Classe abstraite pour la mise en place du design pattern
 * Repr�sente le cas g�n�ral d'une bille
 * @author Jimmy
 *
 */
public abstract class Bille {
	
	public abstract Vecteur getPosition();
	public abstract void setPosition(Vecteur position);
	public abstract double getRayon();
	public abstract Vecteur getVitesse();
	public abstract void setVitesse(Vecteur vitesse);
	public abstract Vecteur getAcc�l�ration();
	public abstract int getClef();
	
	public abstract double masse();

	/**
	 * mise � jour de position et vitesse � t+deltaT � partir de position et vitesse � l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur acc�l�ration intact
	 *
	 * La bille subit par d�faut un mouvement uniform�ment acc�l�r�
	 * */
	public void d�placer( double deltaT) {
		Cinematique.mouvementUniform�mentAcc�l�r�( this.getPosition(), this.getVitesse(), this.getAcc�l�ration(), deltaT);
	}
	
	/**
	 * M�thode red�finie dans les d�corateurs
	 * Pour la gestion des diff�rentes acc�l�rations
	 * */
	public abstract void gestionAcc�l�ration(Vector<Bille> billes);
	
	
	/**
	 * gestion de l'�ventuelle  collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par d�faut est le choc parfaitement �lastique (c-�-d rebond sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliqu�es dans le choc sont modifi�es
	 * si renvoie false, il n'y a pas de collision et les billes sont laiss�es intactes 
	 * */
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		//TODO adapter classe OutilsBille pour la nouvelle classe bille
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}
	
	public abstract void dessine(Graphics g);
	
	/**
	 * M�thode red�finie dans les d�corateurs
	 * Pour la gestion des diff�rentes collisions
	 */
	public abstract void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur);

	
}
