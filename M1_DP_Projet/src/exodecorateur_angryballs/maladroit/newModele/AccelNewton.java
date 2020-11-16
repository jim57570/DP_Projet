package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.OutilsBille;

/**
 * Decoration pour une bille
 * Repr�sente l'acc�l�ration 2: attraction universelle due � la force de Newton
 * @author Jimmy
 *
 */
public class AccelNewton extends DecoratorBille {

	public AccelNewton(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes); //remise � z�ro du vecteur acc�l�ration
		this.billeDecorated.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this.billeDecorated, billes)); //contribution de l'acc�l�ration due � l'attraction des autres billes
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonn�eCointHautGauche, largeur, hauteur);
	}

}
