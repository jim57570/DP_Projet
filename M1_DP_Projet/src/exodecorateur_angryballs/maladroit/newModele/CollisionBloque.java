package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

/**
 * Decoration pour une bille
 * Repr�sente la collision 6: bloqu�e par un bord
 * @author Jimmy
 *
 */
public class CollisionBloque extends DecoratorBille {

	public CollisionBloque(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur,
			double hauteur) {
		// TODO Auto-generated method stub
		
	}

}
