package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import exodecorateur_angryballs.maladroit.newModele.Bille;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;

public class EcouteurBille implements MouseListener, MouseMotionListener {
	
	EtatBille etatBille;	
	Bille billeSélectionné;
	
	AnimationBilles animationBilles;
	
	DéplacementBille déplacementBille;
	AttenteSélectionBille attenteSélectionBille;
	
	
	public EcouteurBille(AnimationBilles animationBilles, CadreAngryBalls cadre){
		this.animationBilles = animationBilles;
		
		this.déplacementBille = new DéplacementBille(this, null, null);
		this.attenteSélectionBille = new AttenteSélectionBille(this, this.déplacementBille, null);
		
		this.déplacementBille.suivant = this.attenteSélectionBille;
		this.etatBille = attenteSélectionBille;
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
