package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;

public abstract class EtatBille {
	EcouteurBille ecouteurBille;
	
	public EtatBille suivant, retour;
		
	public EtatBille(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super();
		this.ecouteurBille = ecouteurBille;
		this.suivant = suivant;
		this.retour = retour;
	}

	public abstract void doAction(MouseEvent arg0);
}
