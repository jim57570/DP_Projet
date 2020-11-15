package exodecorateur_angryballs.maladroit.newModele;

/***
 * Cas général des classes qui complètent le type de bille
 * Les décorateurs sucessifs d'un objet forment toujours une liste chaînée
 * @author Jimmy
 *
 */
public class DecoratorBille extends Bille {
	
	protected Bille billeDecorated; //la bille qui doit être décoré. Soit l'objet dont on va compléter un traitement
	
	/** 
	 * @param billeDecorated : La bille qui être décoré. Celle dont un traitement va être complété par this
	 */
	public DecoratorBille(Bille billeDecorated) {
		this.billeDecorated = billeDecorated;
	}
	
	

}
