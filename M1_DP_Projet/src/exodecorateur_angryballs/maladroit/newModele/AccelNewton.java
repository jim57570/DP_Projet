package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.OutilsBille;

/**
 * Decoration pour une bille
 * Représente l'accélération 2: attraction universelle due à la force de Newton
 * @author Jimmy
 *
 */
public class AccelNewton extends DecoratorBille {

	public AccelNewton(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDecorated.gestionAccélération(billes); //remise à zéro du vecteur accélération
		this.billeDecorated.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this.billeDecorated, billes)); //contribution de l'accélération due à l'attraction des autres billes
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonnéeCointHautGauche, largeur, hauteur);
	}

}
