package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import mesmaths.mecanique.MecaniquePoint;

/**
 * Décoration pour une bille
 * Représente l'accélération 4: frottement visqueux
 * @author Jimmy
 *
 */
public class AccelFrottement extends DecoratorBille {

	public AccelFrottement(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDecorated.gestionAccélération(billes);	//remise à zéro du vecteur accélération
		this.billeDecorated.getAccélération().ajoute(MecaniquePoint.freinageFrottement(this.masse(), this.getVitesse()));      // contribution de l'accélération due au frottement dans l'air
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonnéeCointHautGauche, largeur, hauteur);
	}

}
