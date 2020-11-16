package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import mesmaths.cinematique.Collisions;

/**
 * Decoration pour une bille
 * Représente la collision 6: bloquée par un bord
 * @author Jimmy
 *
 */
public class CollisionBloque extends DecoratorBille {

	public CollisionBloque(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDecorated.gestionAccélération(billes);
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {
		Collisions.collisionBilleContourAvecArretHorizontal(this.billeDecorated.getPosition(), this.billeDecorated.getRayon(), this.billeDecorated.getVitesse(), abscisseCointHautGauche, largeur);
		Collisions.collisionBilleContourAvecArretVertical(this.billeDecorated.getPosition(), this.billeDecorated.getRayon(), this.billeDecorated.getVitesse(), ordonnéeCointHautGauche, hauteur);
	}

}
