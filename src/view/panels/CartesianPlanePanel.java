package view.panels;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

import controller.CartesianPlanePanelMouseController;
import view.Main;

public class CartesianPlanePanel extends JPanel {

	private static final long serialVersionUID = 1L;

	CartesianPlanePanelMouseController cpPanelMouseController;

	private DefaultTableModel pointsTable;

	public CartesianPlanePanel(DefaultTableModel pointsTable) {
		setBackground(Color.WHITE);
		setBounds(252, 0, 532, 561);
		setLayout(null);

		this.pointsTable = pointsTable;
		
		cpPanelMouseController = new CartesianPlanePanelMouseController(this);

		addMouseListener(cpPanelMouseController);
	}

	public void paint(Graphics g) {

		g.clearRect(0, 0, this.getWidth(), this.getHeight());
		
		g.drawLine(0, getHeight() / 2, getWidth(), getHeight() / 2);
		g.drawString("X", getWidth() - 12, (getHeight() / 2) + 15);

		g.drawLine(getWidth() / 2, 0, getWidth() / 2, getHeight());
		g.drawString("Y", (getWidth() / 2) + 12, 0 + 12);

		int i = 0;
		
		for (Point point : Main.pointList) {
			g.drawOval(point.x, point.y, 3, 3);
			g.drawString("p" + i++, point.x, point.y+20);
		}
		
		if (Main.pointList.size() >= 3) {
			for (Point point : Main.curvePointList) {
				g.setColor(Color.red);
				g.drawOval(point.x, point.y, 2, 2);
			}
		}
	}

	public void setNewPoint(int x, int y) {
		Main.pointList.add(new Point(x, y));
		pointsTable.addRow(new Object[] { Main.pointList.size() - 1, x, y });
		paint(this.getGraphics());
	}

}
