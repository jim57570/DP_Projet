package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.OutilsBille;

public abstract class Acceleration extends DecoratorBille{

	public Acceleration(Bille billeDecorated) {
		super(billeDecorated);
	}
	
	@Override
	public void gestionAccélération(Vector<Bille> billes) {};
	
	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonnéeCointHautGauche, largeur, hauteur);
	};
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

}
