package exodecorateur_angryballs.modele;

import mesmaths.cinematique.Collisions;

/**
 * Decoration pour une bille
 * Repr�sente la collision 6: bloqu�e par un bord
 * @author Jimmy
 *
 */
public class CollisionBloque extends Collision {

	public CollisionBloque(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecArretHorizontal(this.billeDecorated.getPosition(), this.billeDecorated.getRayon(), this.billeDecorated.getVitesse(), abscisseCointHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.billeDecorated.getPosition(), this.billeDecorated.getRayon(), this.billeDecorated.getVitesse(), ordonn�eCointHautGauche, hauteur);
	}

}