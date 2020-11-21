package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.newModele.BillePilotée;
import mesmaths.geometrie.base.Vecteur;

public class BilleReleased extends EtatBille{
	
	Vecteur mousePositionReleased;

	public BilleReleased(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(MouseEvent arg0) {
		
		this.mousePositionReleased = new Vecteur(arg0.getX(), arg0.getY());

		Vecteur v0 = Vecteur.difference(this.mousePositionReleased, this.ecouteurBille.mousePosition);
		v0.multiplie((double)this.ecouteurBille.temps/10000);
		System.out.println(v0);
		
		ecouteurBille.billeSélectionné.setVitesse(v0);
		
		this.ecouteurBille.mousePosition = null;
				
		((BillePilotée) this.ecouteurBille.billeSélectionné).setEstPilotée(false);
		ecouteurBille.billeSélectionné = null;
		ecouteurBille.setState(this.suivant);
	}

}
