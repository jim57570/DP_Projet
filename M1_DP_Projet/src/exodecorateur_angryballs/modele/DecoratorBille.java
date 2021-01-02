package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

/***
 * Cas g�n�ral des classes qui compl�tent le type de bille
 * Les d�corateurs sucessifs d'un objet forment toujours une liste cha�n�e
 * @author Jimmy
 *
 */
public abstract class DecoratorBille extends Bille {
	
	protected Bille billeDecorated; //la bille qui doit �tre d�cor�. Soit l'objet dont on va compl�ter un traitement
	
	/** 
	 * @param billeDecorated : La bille qui �tre d�cor�. Celle dont un traitement va �tre compl�t� par this
	 */
	public DecoratorBille(Bille billeDecorated) {
		this.billeDecorated = billeDecorated;
	}

	@Override
	public Vecteur getPosition() {
		return this.billeDecorated.getPosition(); // par d�faut la position du d�corateur de l'objet est le m�me que la position de l'objet d�cor�
		//cette m�thode est donc r�cursive. Le cas terminal est le cas du dernier maillon : l'objet ordinaire
	}

	@Override
	public double getRayon() {
		return this.billeDecorated.getRayon();
	}

	@Override
	public void setAcc�l�ration(Vecteur acc�l�ration) {
		this.billeDecorated.setAcc�l�ration(acc�l�ration);
	}
	@Override
	public Vecteur getVitesse() {
		return this.billeDecorated.getVitesse();
	}

	@Override
	public Vecteur getAcc�l�ration() {
		return this.billeDecorated.getAcc�l�ration();
	}

	@Override
	public int getClef() {
		return this.billeDecorated.getClef();
	}

	@Override
	public double masse() {
		return this.billeDecorated.masse();
	}
	
	@Override
	public Color getHaloColor() {
		return this.billeDecorated.getHaloColor();
	}
	
	@Override
	public void setHaloColor(Color haloColor) {
		this.billeDecorated.setHaloColor(haloColor);
	}

	/**
	 * A priori � ce niveau on ne sait pas calculer l'acc�l�ration de la bille
	 * Elle d�pend du type d'acc�l�ration accord� � la bille d�cor�e
	 */
	@Override
	public abstract void gestionAcc�l�ration(Vector<Bille> billes);
	
	/**
	 * A priori � ce niveau on ne sait pas calculer la collision de la bille
	 * Elle d�pend du type de collision accord� � la bille d�cor�e
	 */
	@Override
	public abstract void collisionContour(double abscisseCointHautGauche, double ordonn�eCointHautGauche, double largeur, double hauteur);
	
	
	public void dessine(Graphics g) {
		this.billeDecorated.dessine(g);
	}
	
	

}
