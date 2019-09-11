package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.panels.CartesianPlanePanel;

public class CartesianPlanePanelMouseController implements MouseListener{
	
	private CartesianPlanePanel panel;
	
	public CartesianPlanePanelMouseController(CartesianPlanePanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		panel.setNewPoint(e.getX(), e.getY());
	}
	
}
