package outil;

import java.awt.*;
import java.awt.event.*;

import javax.swing.JComponent;

import monde.Monde;

public class Souris extends JComponent implements MouseListener
{
	private Monde m;
	private int x ;
	private int y ;
	public void init() {
		 addMouseListener(this);
	}
	
	public Souris(Monde m)
	{
		this.m = m;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.x = e.getX() / m.getTailleCase();
		this.y = e.getY() / m.getTailleCase();
		System.out.println("GetX : " + this.x);
	}
	
	

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void reinitialiser()
	{
		this.x = -1;
		this.y = -1;
	}
	
	@Override
	public int getX()
	{
		return this.x;
	}
	
	@Override
	public int getY()
	{
		return this.y;
	}
	
}
