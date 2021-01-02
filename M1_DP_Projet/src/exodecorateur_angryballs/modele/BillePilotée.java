package exodecorateur_angryballs.modele;

import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

public class BillePilotée extends DecoratorBille{
		
	private Vecteur mousePosition = Vecteur.VECTEURNUL;

	public BillePilotée(Bille billeDecorated) {
		super(billeDecorated);
	}

	@Override
	public void gestionAccélération(Vector<Bille> billes) {
		this.billeDecorated.gestionAccélération(billes);
		this.billeDecorated.getAccélération().ajoute(this.mousePosition);
	}

	@Override
	public void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur) {
		this.billeDecorated.collisionContour(abscisseCointHautGauche, ordonnéeCointHautGauche, largeur, hauteur);
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
