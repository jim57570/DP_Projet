package exodecorateur_angryballs.modele;


import mesmaths.cinematique.Collisions;

/**
 * Decoration pour une bille
 * Représente la collision 7: franchissement des parois et réapparition sur le côté opposé
 * @author Jimmy
 *
 */
public class CollisionPasseMuraille extends Collision {

	public CollisionPasseMuraille(Bille billeDecorated) {
		super(billeDecorated);
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCointHautGauche, ordonnéeCointHautGauche, largeur, hauteur);
	}

}
