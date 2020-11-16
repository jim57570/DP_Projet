package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;

/**
 * D�coration pour une bille
 * Repr�sente la collision 5: rebond sur les bords
 * @author Jimmy
 *
 */
public class CollisionRebond extends DecoratorBille {

	public CollisionRebond(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes);
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecRebond( this.billeDecorated.getPosition(), this.billeDecorated.getRayon(), this.billeDecorated.getVitesse(), abscisseCointHautGauche, ordonn�eCointHautGauche, largeur, hauteur);
	}

}
