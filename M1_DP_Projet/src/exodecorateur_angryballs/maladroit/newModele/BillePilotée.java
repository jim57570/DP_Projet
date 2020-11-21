package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.OutilsBille;

public class BillePilot�e extends DecoratorBille{
	
	private boolean estPilot�e = false;

	public BillePilot�e(Bille billeDecorated) {
		super(billeDecorated);
	}

	@Override
	public void gestionAcc�l�ration(Vector<Bille> billes) {
		this.billeDecorated.gestionAcc�l�ration(billes);
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonn�eCointHautGauche, largeur, hauteur);
	}
	
	public boolean getEstPilot�e() {
		return estPilot�e;
	}

	public void setEstPilot�e(boolean estPilot�e) {
		this.estPilot�e = estPilot�e;
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		if(this.estPilot�e) {
			return false;
		}
		else {
			return OutilsBille.gestionCollisionBilleBille(this, billes);
		}
	}
}
