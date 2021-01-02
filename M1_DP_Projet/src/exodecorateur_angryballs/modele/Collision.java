package exodecorateur_angryballs.modele;

import java.util.Vector;

public abstract class Collision extends DecoratorBille{

	public Collision(Bille billeDecorated) {
		super(billeDecorated);
	}
	
	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {};
	
	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes);
	};
	
	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

}
