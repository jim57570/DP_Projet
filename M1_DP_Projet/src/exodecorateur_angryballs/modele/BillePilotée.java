package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class BillePilot�e extends DecoratorBille{
		
	private Vecteur mousePosition = Vecteur.VECTEURNUL;

	public BillePilot�e(Bille billeDecorated) {
		super(billeDecorated);
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes);
		this.billeDecorated.getAcc�l�ration().ajoute(this.mousePosition);
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonn�eCointHautGauche, largeur, hauteur);
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		return OutilsBille.gestionCollisionBilleBille(this, billes);
	}

	public Vecteur getMousePosition() {
		return mousePosition;
	}

	public void setMousePosition(Vecteur mousePosition) {
		this.mousePosition = mousePosition;
	}
}
