package exodecorateur_angryballs.modele;

import java.util.Vector;

/**
 * Decoration pour une bille
 * Repr�sente l'acc�l�ration 2: attraction universelle due � la force de Newton
 * @author Jimmy
 *
 */
public class AccelNewton extends Acceleration {

	public AccelNewton(Bille billeDecorated) {
		super(billeDecorated);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes); //remise � z�ro du vecteur acc�l�ration
		this.billeDecorated.getAcc�l�ration().ajoute(OutilsBille.gestionAcc�l�rationNewton(this.billeDecorated, billes)); //contribution de l'acc�l�ration due � l'attraction des autres billes
	}

}
