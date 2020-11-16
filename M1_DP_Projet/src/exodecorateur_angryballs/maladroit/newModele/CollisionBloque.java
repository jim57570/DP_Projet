package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		
	}

}
