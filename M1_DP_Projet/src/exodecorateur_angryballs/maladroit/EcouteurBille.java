package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import exodecorateur_angryballs.maladroit.newModele.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;

public class EcouteurBille implements MouseListener, MouseMotionListener {
	
	EtatBille etatBille;	
	Bille billeS�lectionn�;
	
	AnimationBilles animationBilles;
	
	D�placementBille d�placementBille;
	AttenteS�lectionBille attenteS�lectionBille;
	
	
	public EcouteurBille(AnimationBilles animationBilles, CadreAngryBalls cadre){
		this.animationBilles = animationBilles;
		
		this.d�placementBille = new D�placementBille(this, null, null);
		this.attenteS�lectionBille = new AttenteS�lectionBille(this, this.d�placementBille, null);
		
		this.d�placementBille.suivant = this.attenteS�lectionBille;
		this.etatBille = attenteS�lectionBille;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		this.etatBille.pressed(arg0);		
	}


	public void mouseDragged(MouseEvent arg0) {
		this.etatBille.dragged(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.etatBille.released(arg0);		
	}
	
	@Override
	public void mouseMoved(MouseEvent arg0) {
		this.etatBille.moved(arg0);
	}

	
	public void setState(EtatBille etatBille) {
		this.etatBille = etatBille;
	}
	
	public EtatBille getState() {
		return this.etatBille;
	}

	

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
