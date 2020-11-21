package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;

import exodecorateur_angryballs.maladroit.newModele.BillePilotée;

public class BillePressed extends EtatBille{

	public BillePressed(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(MouseEvent arg0) {
		/**********************************************************/
		if(this.ecouteurBille.animationBilles.getThread()!= null) {
			/**********************************************************/
			for (int i = 0; i < this.ecouteurBille.animationBilles.billes.size(); ++i){
				int xBille = (int) this.ecouteurBille.animationBilles.billes.get(i).getPosition().x;
				int yBille = (int) this.ecouteurBille.animationBilles.billes.get(i).getPosition().y;
				
				double xClick = arg0.getX();
				double yClick = arg0.getY();
				
				int diffX = (int) Math.abs((xBille - xClick));
				int diffY = (int)  Math.abs((yBille - yClick));
				
				if(diffX < this.ecouteurBille.animationBilles.billes.get(i).getRayon() && diffY < this.ecouteurBille.animationBilles.billes.get(i).getRayon()){
					if(this.ecouteurBille.animationBilles.billes.get(i) instanceof BillePilotée) {
						ecouteurBille.billeSélectionné = this.ecouteurBille.animationBilles.billes.get(i);
						ecouteurBille.setState(this.suivant);
					
						((BillePilotée) this.ecouteurBille.animationBilles.billes.get(i)).setEstPilotée(true);
						
						break;
					}
				}
			}
		}
	}
}
