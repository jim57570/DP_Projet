package exodecorateur_angryballs.maladroit.newModele;

/***
 * Cas g�n�ral des classes qui compl�tent le type de bille
 * Les d�corateurs sucessifs d'un objet forment toujours une liste cha�n�e
 * @author Jimmy
 *
 */
public class DecoratorBille extends Bille {
	
	protected Bille billeDecorated; //la bille qui doit �tre d�cor�. Soit l'objet dont on va compl�ter un traitement
	
	/** 
	 * @param billeDecorated : La bille qui �tre d�cor�. Celle dont un traitement va �tre compl�t� par this
	 */
	public DecoratorBille(Bille billeDecorated) {
		this.billeDecorated = billeDecorated;
	}
	
	

}
