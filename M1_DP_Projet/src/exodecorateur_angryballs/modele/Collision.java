package exodecorateur_angryballs.modele;

import java.util.Vector;

public abstract class Collision extends DecoratorBille{

	public Collision(Bille billeDecorated) {
		super(billeDecorated);
	}
	
	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {};
	
	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDecorated.gestionAccélération(billes);
	};
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

}
