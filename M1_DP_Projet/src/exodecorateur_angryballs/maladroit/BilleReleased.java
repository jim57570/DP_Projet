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
		Vecteur v0 = Vecteur.cr�ationAl�atoire(-0.1, -0.1, 0.1, 0.1);
		ecouteurBille.billeS�lectionn�.setVitesse(v0);
		/******************************************************/
		
		ecouteurBille.billeS�lectionn� = null;
		ecouteurBille.setState(this.suivant);
	}

}
