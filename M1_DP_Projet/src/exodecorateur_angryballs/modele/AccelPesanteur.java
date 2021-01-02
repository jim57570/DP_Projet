package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

/**
 * D�coration pour une bille
 * Repr�sente l'acc�l�ration 3: attraction vers le bas (pesanteur)
 * @author Jimmy
 *
 */
public class AccelPesanteur extends Acceleration {
	
	Vecteur pesanteur;

	public AccelPesanteur(Bille billeDecorated, Vecteur pesanteur) {
		super(billeDecorated);
		this.pesanteur = pesanteur;
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes); //remise � z�ro du vecteur acc�l�ration
		this.getAcc�l�ration().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
	}

}
