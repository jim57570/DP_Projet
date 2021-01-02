package exodecorateur_angryballs;

import java.awt.event.MouseEvent;

/**
 * Classe abstraite pour d�finir les diff�rents �venements � g�rer pour chaque �tat
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
