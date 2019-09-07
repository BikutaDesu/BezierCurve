package controller.buttons;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import utils.Utils;
import view.Main;
import view.panels.CartesianPlanePanel;

public class CreateCurveButtonController implements ActionListener {

	private CartesianPlanePanel panel;
	
	public CreateCurveButtonController(CartesianPlanePanel panel) {
		this.panel = panel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Main.btnCriarCurva.setEnabled(false);
		Main.btnLimpar.setEnabled(true);
		float t = 0;
		
		Point[] points = new Point[Main.pointList.size()];
		points = Main.pointList.toArray(points);
		
		while (t<=1) {
			Utils.quadBesierCurve(t, panel.getGraphics(), points);
			t+=0.001;
		}
		
		panel.repaint();
	}

}
