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
	//------------------- création de la liste (pour l'instant vide) des billes -----------------------

	Vector<Bille> billes = new Vector<Bille>();

	//---------------- création de la vue responsable du dessin des billes -------------------------

	CadreAngryBalls cadre = new CadreAngryBalls("Angry balls",
	                                        "Animation de billes ayant des comportements différents. Situation idéale pour mettre en place le DP Decorator",
	                                        billes);

	cadre.montrer(); // on rend visible la vue

	//------------- remplissage de la liste avec 5 billes -------------------------------



	double xMax, yMax;
	double vMax = 0.1;
	xMax = cadre.largeurBillard();      // abscisse maximal
	yMax = cadre.hauteurBillard();      // ordonnée maximale

	double rayon = 0.05*Math.min(xMax, yMax); // rayon des billes : ici toutes les billes ont le même rayon, mais ce n'est pas obligatoire

	Vecteur p0, p1, p2, p3, p4,  v0, v1, v2, v3, v4;    // les positions des centres des billes et les vecteurs vitesse au démarrage. 
	                                                    // Elles vont être choisies aléatoirement

	//------------------- création des vecteurs position des billes ---------------------------------

	p0 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
	p1 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
	p2 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
	p3 = Vecteur.créationAléatoire(0, 0, xMax, yMax);
	p4 = Vecteur.créationAléatoire(0, 0, xMax, yMax);

	//------------------- création des vecteurs vitesse des billes ---------------------------------

	v0 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
	v1 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, 0);
	v2 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
	v3 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);
	v4 = Vecteur.créationAléatoire(-vMax, -vMax, vMax, vMax);

	//--------------- ici commence la partie à changer ---------------------------------

	Bille B = new BilleNormale(p0, rayon, v0, Color.red); //création d'une bille normale rouge
	B = new CollisionRebond(B); //on décore cette bille avec la collision rebond
	
	Bille G = new BilleNormale(p1, rayon, v1, Color.green); //création d'une bille normale verte
	
	billes.add(B); //on ajoute la bille à la liste
	billes.add(G);
	
	//---------------------- ici finit la partie à changer -------------------------------------------------------------


	System.out.println("billes = " + billes);


	//-------------------- création de l'objet responsable de l'animation (c'est un thread séparé) -----------------------

	AnimationBilles animationBilles = new AnimationBilles(billes, cadre);

	//----------------------- mise en place des écouteurs de boutons qui permettent de contrôler (un peu...) l'application -----------------

	EcouteurBoutonLancer écouteurBoutonLancer = new EcouteurBoutonLancer(animationBilles);
	EcouteurBoutonArreter écouteurBoutonArrêter = new EcouteurBoutonArreter(animationBilles);
	
	EcouteurBille écouteurBille = new EcouteurBille(animationBilles);

	//------------------------- activation des écouteurs des boutons et ça tourne tout seul ------------------------------


	cadre.lancerBilles.addActionListener(écouteurBoutonLancer);             // pourrait être remplacé par Observable - Observer 
	cadre.arrêterBilles.addActionListener(écouteurBoutonArrêter);           // pourrait être remplacé par Observable - Observer
	
	cadre.getBillard().addMouseListener(écouteurBille);
	cadre.getBillard().addMouseMotionListener(écouteurBille);
	




	}

}
