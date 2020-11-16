package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;

/**
 * D�coration pour une bille
 * Repr�sente l'acc�l�ration 4: frottement visqueux
 * @author Jimmy
 *
 */
public class AccelFrottement extends DecoratorBille {

	public AccelFrottement(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes);	//remise � z�ro du vecteur acc�l�ration
		this.billeDecorated.getAcc�l�ration().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'acc�l�ration due au frottement dans l'air
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonn�eCointHautGauche, largeur, hauteur);
	}

}
