package exodecorateur_angryballs.maladroit;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import mesmaths.geometrie.base.Vecteur;

public class EcouteurBille implements MouseListener, MouseMotionListener {
	
	AnimationBilles animationBilles;

	public EcouteurBille(AnimationBilles animationBilles)
	{
		this.animationBilles = animationBilles;
	}


	public void mouseDragged(MouseEvent arg0) {

		System.out.println("x:"+arg0.getX());
		System.out.println("y:"+arg0.getY());
		
		double xClick = arg0.getX();
		double yClick = arg0.getY();
		
		for (int i = 0; i < animationBilles.billes.size(); ++i)
		{
			int xBille = (int) animationBilles.billes.get(i).getPosition().x;
			int yBille = (int) animationBilles.billes.get(i).getPosition().y;
			
			System.out.println("xBille:"+xBille);
			System.out.println("yBille:"+yBille);
			
			int diffX = (int) Math.abs((xBille - xClick));
			int diffY = (int)  Math.abs((yBille - yClick));
			
			if(diffX < animationBilles.billes.get(i).getRayon() && diffY < animationBilles.billes.get(i).getRayon())
			{
				System.out.println("C'est une bille !");
				animationBilles.billes.get(i).setVitesse();
				animationBilles.billes.get(i).setPosition(new Vecteur(xClick, yClick));
			}
		}
		
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
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


	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
