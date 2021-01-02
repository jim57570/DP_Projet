package exodecorateur_angryballs;

import java.awt.event.MouseEvent;

/**
 * Classe abstraite pour définir les différents évenements à gérer pour chaque état
 *
 */
public abstract class EtatBille {
	
	EcouteurBille ecouteurBille;
	
	public EtatBille suivant, retour;
		
	public EtatBille(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super();
		this.ecouteurBille = ecouteurBille;
		this.suivant = suivant;
		//this.retour = retour;
	}

	protected abstract void pressed(MouseEvent arg0);
	protected abstract void dragged(MouseEvent arg0);
	protected abstract void released(MouseEvent arg0);

	protected abstract void moved(MouseEvent arg0);
}
