package GUI;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;



public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 636, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.NORTH);
		PanelItems panelItems = new PanelItems();
		CustomerPanel customerPanel = new CustomerPanel();
		NewOrderPanel orderPanel = new NewOrderPanel();
		tabbedPane.addTab("Produkter", null, panelItems, null);
		tabbedPane.addTab("Personer", null, customerPanel, null);
		tabbedPane.addTab("Ny ordre", null, orderPanel, null);
		frame.setVisible(true);
		frame.pack();

	}
}
