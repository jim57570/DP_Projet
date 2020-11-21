package exodecorateur_angryballs.maladroit.newModele;

import java.util.Vector;

import exodecorateur_angryballs.maladroit.modele.OutilsBille;

public class BillePilotée extends DecoratorBille{
	
	private boolean estPilotée = false;

	public BillePilotée(Bille billeDecorated) {
		super(billeDecorated);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDecorated.gestionAccélération(billes);
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonnéeCointHautGauche, largeur, hauteur);
	}
	
	public boolean getEstPilotée() {
		return estPilotée;
	}

	public void setEstPilotée(boolean estPilotée) {
		this.estPilotée = estPilotée;
	}

	@Override
	public boolean gestionCollisionBilleBille(Vector<Bille> billes) {
		if(this.estPilotée) {
			return false;
		}
		else {
			return OutilsBille.gestionCollisionBilleBille(this, billes);
		}
	}
}
