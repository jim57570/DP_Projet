package exodecorateur_angryballs.maladroit;

import java.awt.Color;
import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.newModele.BillePilotée;
import mesmaths.geometrie.base.Vecteur;

public class DéplacementBille extends EtatBille{
	Vecteur mousePosition;
	Vecteur accélération;

	public DéplacementBille(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
	}
	
	@Override
	public void dragged(MouseEvent arg0) {
		mousePosition = new Vecteur(arg0.getX(), arg0.getY());
		accélération = mousePosition.difference(this.ecouteurBille.billeSélectionné.getPosition());
		accélération.multiplie(0.000005);
		((BillePilotée) this.ecouteurBille.billeSélectionné).setMousePosition(accélération);
	}
	
	@Override
	public void released(MouseEvent arg0) {
		ecouteurBille.setState(this.suivant);
		((BillePilotée) this.ecouteurBille.billeSélectionné).setMousePosition(Vecteur.VECTEURNUL);
		this.ecouteurBille.billeSélectionné.setHaloColor(Color.CYAN);
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
