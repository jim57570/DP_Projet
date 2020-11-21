package exodecorateur_angryballs.maladroit;

import java.awt.Cursor;
import java.awt.event.MouseEvent;

public class BilleFocused extends EtatBille{
	
	Cursor c = new Cursor(Cursor.HAND_CURSOR);
	Cursor c1 = new Cursor(Cursor.DEFAULT_CURSOR);

	public BilleFocused(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doAction(MouseEvent arg0) {
		for (int i = 0; i < this.ecouteurBille.animationBilles.billes.size(); ++i){
			int xBille = (int) this.ecouteurBille.animationBilles.billes.get(i).getPosition().x;
			int yBille = (int) this.ecouteurBille.animationBilles.billes.get(i).getPosition().y;
			
			double xClick = arg0.getX();
			double yClick = arg0.getY();
			
			int diffX = (int) Math.abs((xBille - xClick));
			int diffY = (int)  Math.abs((yBille - yClick));
			
			if(diffX < this.ecouteurBille.animationBilles.billes.get(i).getRayon() && diffY < this.ecouteurBille.animationBilles.billes.get(i).getRayon()){
				this.ecouteurBille.cadre.setCursor(c);
			}
			else {
				this.ecouteurBille.cadre.setCursor(c1);
			}
		}
	}
}
