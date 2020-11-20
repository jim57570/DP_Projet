package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import exodecorateur_angryballs.maladroit.newModele.Bille;
import mesmaths.geometrie.base.Vecteur;

public class EcouteurBille implements MouseListener, MouseMotionListener {
	
	EtatBille etatBille;	
	Bille billeSélectionné;
	
	AnimationBilles animationBilles;
	
	BilleDragged billeDragged;
	BilleReleased billeReleased;
	BillePressed billePressed;

	public EcouteurBille(AnimationBilles animationBilles){
		this.animationBilles = animationBilles;
		
		this.billeDragged = new BilleDragged(this, null, null);
		this.billePressed = new BillePressed(this, this.billeDragged, null);
		this.billeReleased = new BilleReleased(this, this.billePressed, null);
		
		this.billeDragged.suivant = this.billeReleased;
		this.etatBille = billePressed;
	}
	
	@Override
	public void mousePressed(MouseEvent arg0) {
		this.etatBille.doAction(arg0);		
	}


	public void mouseDragged(MouseEvent arg0) {
		this.etatBille.doAction(arg0);
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		this.etatBille.doAction(arg0);		
	}

	
	public void setState(EtatBille etatBille) {
		this.etatBille = etatBille;
	}
	
	public EtatBille getState() {
		return this.etatBille;
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
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
