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
 * Représente le cas général d'une bille
 * @author Jimmy
 *
 */
public abstract class Bille {
	
	public abstract Vecteur getPosition();
	public abstract void setPosition(Vecteur position);
	public abstract double getRayon();
	public abstract Vecteur getVitesse();
	public abstract void setVitesse(Vecteur vitesse);
	public abstract Vecteur getAccélération();
	public abstract int getClef();
	
	public abstract double masse();

	/**
	 * mise à jour de position et vitesse à t+deltaT à partir de position et vitesse à l'instant t
	 * 
	 * modifie le vecteur position et le vecteur vitesse
	 * 
	 * laisse le vecteur accélération intact
	 *
	 * La bille subit par défaut un mouvement uniformément accéléré
	 * */
	public void déplacer( double deltaT) {
		Cinematique.mouvementUniformémentAccéléré( this.getPosition(), this.getVitesse(), this.getAccélération(), deltaT);
	}
	
	/**
	 * Méthode redéfinie dans les décorateurs
	 * Pour la gestion des différentes accélérations
	 * */
	public abstract void gestionAccélération(Vector<Bille> billes);
	
	
	/**
	 * gestion de l'éventuelle  collision de cette bille avec les autres billes
	 *
	 * billes est la liste de toutes les billes en mouvement
	 * 
	 * Le comportement par défaut est le choc parfaitement élastique (c-à-d rebond sans amortissement)
	 * 
	 * @return true si il y a collision et dans ce cas les positions et vecteurs vitesses des 2 billes impliquées dans le choc sont modifiées
	 * si renvoie false, il n'y a pas de collision et les billes sont laissées intactes 
	 * */
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		//TODO adapter classe OutilsBille pour la nouvelle classe bille
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}
	
	public abstract void dessine(Graphics g);
	
	/**
	 * Méthode redéfinie dans les décorateurs
	 * Pour la gestion des différentes collisions
	 */
	public abstract void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur);

	
}
