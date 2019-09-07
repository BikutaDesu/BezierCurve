package controller.buttons;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Main;

public class ClearButtonController implements ActionListener {

	private Point[] pointList;
	
	public ClearButtonController(Point... pointList) {
		this.pointList = pointList;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Main.btnCriarCurva.setEnabled(true);
		Main.btnLimpar.setEnabled(false);
	}

}
