package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;
import mesmaths.geometrie.base.Vecteur;

public class BilleReleased extends EtatBille{

	public BilleReleased(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(MouseEvent arg0) {
		
		
		/******************************************************/
		Vecteur v0 = Vecteur.créationAléatoire(-0.1, -0.1, 0.1, 0.1);
		ecouteurBille.billeSélectionné.setVitesse(v0);
		/******************************************************/
		
		ecouteurBille.billeSélectionné = null;
		ecouteurBille.setState(this.suivant);
	}

}
