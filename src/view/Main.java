package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.buttons.CreateCurveButtonController;
import view.panels.CartesianPlanePanel;

public class Main extends JFrame {

	private JPanel contentPane;
	private JTable pointsTable;

	public static JButton btnCriarCurva;
	public static JButton btnLimpar;
	
	public static List<Point> pointList = new ArrayList<Point>();
	public static List<Point> curvePointList = new ArrayList<Point>();

	private CreateCurveButtonController createCurveButtonController;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("Curva de B\u00E9zier | Desenvolvido por Victor Neves");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnButtons = new JPanel();
		pnButtons.setBackground(Color.DARK_GRAY);
		pnButtons.setBounds(0, 0, 252, 561);
		contentPane.add(pnButtons);
		pnButtons.setLayout(null);

		JLabel lblCurvaDeBezier = new JLabel("Curva de B\u00E9zier");
		lblCurvaDeBezier.setForeground(Color.WHITE);
		lblCurvaDeBezier.setBounds(75, 27, 95, 17);
		lblCurvaDeBezier.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnButtons.add(lblCurvaDeBezier);

		DefaultTableModel tableModel = new DefaultTableModel();

		pointsTable = new JTable(tableModel);
		tableModel.addColumn("P");
		tableModel.addColumn("X");
		tableModel.addColumn("Y");

		JScrollPane scrollPane = new JScrollPane(pointsTable);
		scrollPane.setBounds(10, 231, 232, 319);
		pnButtons.add(scrollPane);

		CartesianPlanePanel cartesianPlanePanel = new CartesianPlanePanel(tableModel);
		
		createCurveButtonController = new CreateCurveButtonController(cartesianPlanePanel);


		btnCriarCurva = new JButton("Criar Curva");
		btnCriarCurva.setBounds(57, 89, 130, 23);
		btnCriarCurva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCriarCurva.addActionListener(createCurveButtonController);
		pnButtons.add(btnCriarCurva);

		btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(57, 145, 130, 23);
		btnLimpar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		pnButtons.add(btnLimpar);

		contentPane.add(cartesianPlanePanel);
	}
}
