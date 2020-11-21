package exodecorateur_angryballs.maladroit.newModele;

import mesmaths.cinematique.Collisions;

/**
 * Décoration pour une bille
 * Représente la collision 5: rebond sur les bords
 * @author Jimmy
 *
 */
public class CollisionRebond extends Collision {

	public CollisionRebond(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond( this.billeDecorated.getPosition(), this.billeDecorated.getRayon(), this.billeDecorated.getVitesse(), abscisseCointHautGauche, ordonnéeCointHautGauche, largeur, hauteur);
	}

}
