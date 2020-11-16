package exodecorateur_angryballs.maladroit;

import java.awt.Color;
import java.util.Vector;

import exodecorateur_angryballs.maladroit.newModele.*;
import exodecorateur_angryballs.maladroit.vues.CadreAngryBalls;
import mesmaths.geometrie.base.Vecteur;

public class NewTestAngryBalls {
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
	//------------------- cr�ation de la liste (pour l'instant vide) des billes -----------------------

	Vector<Bille> billes = new Vector<Bille>();

	//---------------- cr�ation de la vue responsable du dessin des billes -------------------------

	CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
	                                        "Animation de billes ayant des comportements diff�rents. Situation id�ale pour mettre en place le DP Decorator",
	                                        billes);

	cadre.montrer(); // on rend visible la vue

	//------------- remplissage de la liste avec 5 billes -------------------------------



	double xMax, yMax;
	double vMax = 0.1;
	xMax = cadre.largeurBillard();      // abscisse maximal
	yMax = cadre.hauteurBillard();      // ordonn�e maximale

	double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le m�me rayon, mais ce n'est pas obligatoire

	Vecteur p0, p1, p2, p3, p4,  v0, v1, v2, v3, v4;    // les positions des centres des billes et les vecteurs vitesse au d�marrage. 
	                                                    // Elles vont �tre choisies al�atoirement

	//------------------- cr�ation des vecteurs position des billes ---------------------------------

	p0 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
	p1 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
	p2 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
	p3 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);
	p4 = Vecteur.cr�ationAl�atoire(0, 0, xMax, yMax);

	//------------------- cr�ation des vecteurs vitesse des billes ---------------------------------

	v0 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
	v1 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, 0);
	v2 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
	v3 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);
	v4 = Vecteur.cr�ationAl�atoire(-vMax, -vMax, vMax, vMax);

	//--------------- ici commence la partie � changer ---------------------------------
	
	
	Bille billeRouge = new BilleNormale(p0, rayon, v0, Color.red); //cr�ation d'une bille normale rouge
	billeRouge = new CollisionRebond(billeRouge); //on d�core cette bille avec la collision rebond
	
	Bille billeJaune = new BilleNormale(p1, rayon, v1, Color.yellow);
	billeJaune = new AccelPesanteur(billeJaune, new Vecteur(0, 0.001));
	billeJaune = new AccelFrottement(billeJaune);
	billeJaune = new CollisionRebond(billeJaune);
	
	Bille billeVerte = new BilleNormale(p2, rayon, v2, Color.green);
	billeVerte = new AccelNewton(billeVerte);
	billeVerte = new AccelFrottement(billeVerte);
	billeVerte = new CollisionRebond(billeVerte);
	
	Bille billeBleue = new BilleNormale(p3, rayon, v3, Color.cyan);
	billeBleue = new CollisionPasseMuraille(billeBleue);
	
	Bille billeNoire = new BilleNormale(p4, rayon, v4, Color.black); //cr�ation d'une bille normale verte
	billeNoire = new AccelNewton(billeNoire); //on d�core cette bille avec l'attraction due � la force de newton
	billeNoire = new CollisionBloque(billeNoire); //on la d�core �galement avec la collision bloqu�e
	
	//on ajoute les billes � la liste
	billes.add(billeRouge);
	billes.add(billeJaune);
	billes.add(billeVerte);
	billes.add(billeBleue);
	billes.add(billeNoire);
	
	//---------------------- ici finit la partie � changer -------------------------------------------------------------


	System.out.println("billes = " + billes);


	//-------------------- cr�ation de l'objet responsable de l'animation (c'est un thread s�par�) -----------------------

	AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

	//----------------------- mise en place des �couteurs de boutons qui permettent de contr�ler (un peu...) l'application -----------------

	EcouteurBoutonLancer �couteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
	EcouteurBoutonArreter �couteurBoutonArr�ter = new EcouteurBoutonArreter(animationBilles);
	
	EcouteurBille �couteurBille = new EcouteurBille(animationBilles);

	//------------------------- activation des �couteurs des boutons et �a tourne tout seul ------------------------------


	cadre.lancerBilles.addActionListener(�couteurBoutonLancer);             // pourrait �tre remplac� par Observable - Observer 
	cadre.arr�terBilles.addActionListener(�couteurBoutonArr�ter);           // pourrait �tre remplac� par Observable - Observer
	
	//Tests bille attrapable
	//cadre.getBillard().addMouseListener(�couteurBille);
	//cadre.getBillard().addMouseMotionListener(�couteurBille);
	




	}

}
