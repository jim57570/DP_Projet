package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;
import mesmaths.geometrie.base.Vecteur;

public class BilleDragged extends EtatBille{

	public BilleDragged(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	
	public void doAction (MouseEvent arg0) {
		if(arg0.getID() == MouseEvent.MOUSE_RELEASED) {
			ecouteurBille.setState(this.suivant);
			ecouteurBille.etatBille.doAction(arg0);
		}
		else {
			ecouteurBille.billeSélectionné.setPosition(new Vecteur(arg0.getX(), arg0.getY()));
			ecouteurBille.billeSélectionné.setVitesse(Vecteur.VECTEURNUL);
		}
		
	}

}
