package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

/**
 * Decoration pour une bille
 * Représente la collision 7: franchissement des parois et réapparition sur le côté opposé
 * @author Jimmy
 *
 */
public class CollisionPasseMuraille extends DecoratorBille {

	public CollisionPasseMuraille(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		
	}

}
