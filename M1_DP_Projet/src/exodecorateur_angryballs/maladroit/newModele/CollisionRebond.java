package exodecorateur_angryballs.maladroit.newModele;

import mesmaths.cinematique.Collisions;

/**
 * D�coration pour une bille
 * Repr�sente la collision 5: rebond sur les bords
 * @author Jimmy
 *
 */
public class CollisionRebond extends Collision {

	public CollisionRebond(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond( this.billeDecorated.getPosition(), this.billeDecorated.getRayon(), this.billeDecorated.getVitesse(), abscisseCointHautGauche, ordonn�eCointHautGauche, largeur, hauteur);
	}

}
