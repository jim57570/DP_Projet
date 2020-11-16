package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;

/**
 * Decoration pour une bille
 * Repr�sente la collision 7: franchissement des parois et r�apparition sur le c�t� oppos�
 * @author Jimmy
 *
 */
public class CollisionPasseMuraille extends DecoratorBille {

	public CollisionPasseMuraille(Bille billeDecorated) {
		super(billeDecorated);
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes);
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourPasseMuraille( this.getPosition(), abscisseCointHautGauche, ordonn�eCointHautGauche, largeur, hauteur);
	}

}
