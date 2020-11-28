package exodecorateur_angryballs.maladroit;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseEvent;
import exodecorateur_angryballs.maladroit.newModele.BillePilotée;
import mesmaths.geometrie.base.VecteurDartevelleVichard;

public class AttenteSélectionBille extends EtatBille{
	
	Cursor c = new Cursor(Cursor.HAND_CURSOR);
	Cursor c1 = new Cursor(Cursor.DEFAULT_CURSOR);
	
	VecteurDartevelleVichard mousePosition;

	public AttenteSélectionBille(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void pressed(MouseEvent arg0) {
		for(int i=0; i < this.ecouteurBille.animationBilles.billes.size(); i++){
			this.mousePosition = new VecteurDartevelleVichard(arg0.getX(), arg0.getY());
			mousePosition.retire(this.ecouteurBille.animationBilles.billes.get(i).getPosition());
			mousePosition.vecteurAbsolue();
			if(mousePosition.isCoordInfTo(this.ecouteurBille.animationBilles.billes.get(i).getRayon())){
				if(this.ecouteurBille.animationBilles.billes.get(i) instanceof BillePilotée) {
					ecouteurBille.billeSélectionné = this.ecouteurBille.animationBilles.billes.get(i);				
					ecouteurBille.setState(this.suivant);
				}
			}
		}
	}
	
	@Override
	public void dragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void released(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void moved(MouseEvent arg0) {
		for(int i=0; i < this.ecouteurBille.animationBilles.billes.size(); i++){
			this.mousePosition = new VecteurDartevelleVichard(arg0.getX(), arg0.getY());
			mousePosition.retire(this.ecouteurBille.animationBilles.billes.get(i).getPosition());
			mousePosition.vecteurAbsolue();
			if(mousePosition.isCoordInfTo(this.ecouteurBille.animationBilles.billes.get(i).getRayon())){
				if(this.ecouteurBille.animationBilles.billes.get(i) instanceof BillePilotée) {
					this.ecouteurBille.animationBilles.billes.get(i).setHaloColor(Color.RED);
				}
			}
			else {
				this.ecouteurBille.animationBilles.billes.get(i).setHaloColor(Color.CYAN);
			}
		}
	}
}
