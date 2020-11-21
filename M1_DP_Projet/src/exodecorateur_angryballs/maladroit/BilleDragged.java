package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;

import mesmaths.geometrie.base.Vecteur;

public class BilleDragged extends EtatBille implements Runnable{
	
	private Thread thread;
	MouseEvent arg0;
	int temps; //milisecondes

	public BilleDragged(EcouteurBille ecouteurBille, EtatBille suivant, EtatBille retour) {
		super(ecouteurBille, suivant, retour);
		this.thread = null;
	}


	public void doAction (MouseEvent arg0) {
		this.arg0 = arg0;
		this.temps = this.ecouteurBille.temps;
		
		if(arg0.getID() == MouseEvent.MOUSE_RELEASED) {
			if (thread != null){
				this.thread.interrupt();
				this.thread = null;
			}
			
			ecouteurBille.setState(this.suivant);
			ecouteurBille.etatBille.doAction(arg0);
			
		}
		else {                    
			ecouteurBille.billeSélectionné.setPosition(new Vecteur(arg0.getX(), arg0.getY()));
			ecouteurBille.billeSélectionné.setVitesse(Vecteur.VECTEURNUL);
			
			if (this.thread == null){ 
				this.thread = new Thread(this);
				thread.start();
			}
		}
	}


	@Override
	public void run() {
		try {
			while (!Thread.interrupted()){                           // gestion du mouvement

				this.ecouteurBille.mousePosition= new Vecteur(arg0.getX(), arg0.getY());
				System.out.println(this.ecouteurBille.mousePosition);
			
				Thread.sleep((int) this.temps);
			}
		} catch (InterruptedException e) {
			
		}
	}
}
