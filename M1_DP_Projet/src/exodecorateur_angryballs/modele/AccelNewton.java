package exodecorateur_angryballs.modele;

import java.util.Vector;

/**
 * Decoration pour une bille
 * Représente l'accélération 2: attraction universelle due à la force de Newton
 * @author Jimmy
 *
 */
public class AccelNewton extends Acceleration {

	public AccelNewton(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDecorated.gestionAccélération(billes); //remise à zéro du vecteur accélération
		this.billeDecorated.getAccélération().ajoute(OutilsBille.gestionAccélérationNewton(this.billeDecorated, billes)); //contribution de l'accélération due à l'attraction des autres billes
	}

}
