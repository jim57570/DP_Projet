package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

/**
 * Décoration pour une bille
 * Représente l'accélération 3: attraction vers le bas (pesanteur)
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
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDecorated.gestionAccélération(billes); //remise à zéro du vecteur accélération
		this.getAccélération().ajoute(this.pesanteur);          // contribution du champ de pesanteur (par exemple)
	}

}
