package exodecorateur_angryballs.maladroit;

import java.awt.Color;
import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.newModele.BillePilot�e;
import mesmaths.geometrie.base.Vecteur;

public class D�placementBille extends EtatBille{
	Vecteur mousePosition;
	Vecteur acc�l�ration;

	public D�placementBille(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
	}
	
	@Override
	public void dragged(MouseEvent arg0) {
		mousePosition = new Vecteur(arg0.getX(), arg0.getY());
		acc�l�ration = mousePosition.difference(this.ecouteurBille.billeS�lectionn�.getPosition());
		acc�l�ration.multiplie(0.000005);
		((BillePilot�e) this.ecouteurBille.billeS�lectionn�).setMousePosition(acc�l�ration);
	}
	
	@Override
	public void released(MouseEvent arg0) {
		ecouteurBille.setState(this.suivant);
		((BillePilot�e) this.ecouteurBille.billeS�lectionn�).setMousePosition(Vecteur.VECTEURNUL);
		this.ecouteurBille.billeS�lectionn�.setHaloColor(Color.CYAN);
	}

	@Override
	public void pressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void moved(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}
}
