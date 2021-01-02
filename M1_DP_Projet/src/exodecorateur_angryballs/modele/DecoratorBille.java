package exodecorateur_angryballs.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Vector;

import mesmaths.geometrie.base.Vecteur;

/***
 * Cas général des classes qui complètent le type de bille
 * Les décorateurs sucessifs d'un objet forment toujours une liste chaînée
 * @author Jimmy
 *
 */
public abstract class DecoratorBille extends Bille {
	
	protected Bille billeDecorated; //la bille qui doit être décoré. Soit l'objet dont on va compléter un traitement
	
	/** 
	 * @param billeDecorated : La bille qui être décoré. Celle dont un traitement va être complété par this
	 */
	public DecoratorBille(Bille billeDecorated) {
		this.billeDecorated = billeDecorated;
	}

	@Override
	public Vecteur getPosition() {
		return this.billeDecorated.getPosition(); // par défaut la position du décorateur de l'objet est le même que la position de l'objet décoré
		//cette méthode est donc récursive. Le cas terminal est le cas du dernier maillon : l'objet ordinaire
	}

	@Override
	public double getRayon() {
		return this.billeDecorated.getRayon();
	}

	@Override
	public void setAccélération(Vecteur accélération) {
		this.billeDecorated.setAccélération(accélération);
	}
	@Override
	public Vecteur getVitesse() {
		return this.billeDecorated.getVitesse();
	}

	@Override
	public Vecteur getAccélération() {
		return this.billeDecorated.getAccélération();
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
	 * A priori à ce niveau on ne sait pas calculer l'accélération de la bille
	 * Elle dépend du type d'accélération accordé à la bille décorée
	 */
	@Override
	public abstract void gestionAccélération(Vector<Bille> billes);
	
	/**
	 * A priori à ce niveau on ne sait pas calculer la collision de la bille
	 * Elle dépend du type de collision accordé à la bille décorée
	 */
	@Override
	public abstract void collisionContour(double abscisseCointHautGauche, double ordonnéeCointHautGauche, double largeur, double hauteur);
	
	
	public void dessine(Graphics g) {
		this.billeDecorated.dessine(g);
	}
	
	

}
