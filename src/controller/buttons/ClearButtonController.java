package controller.buttons;

import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import view.Main;
import view.panels.CartesianPlanePanel;

public class ClearButtonController implements ActionListener {

	private CartesianPlanePanel panel;
	private DefaultTableModel pointsTable;
	
	public ClearButtonController(CartesianPlanePanel panel, DefaultTableModel pointsTable) {
		this.panel = panel;
		this.pointsTable = pointsTable;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Main.btnCriarCurva.setEnabled(true);
		Main.btnLimpar.setEnabled(false);
		
		Main.pointList = new ArrayList<Point>();
		Main.curvePointList = new ArrayList<Point>();
		
		pointsTable.setRowCount(0);
		panel.paint(panel.getGraphics());
		
	}

}
