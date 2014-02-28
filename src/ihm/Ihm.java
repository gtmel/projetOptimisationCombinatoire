package ihm;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.AbstractListModel;

public class Ihm {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ihm window = new Ihm();
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
	public Ihm() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 659, 465);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panelResultats = new JPanel();
		frame.getContentPane().add(panelResultats, BorderLayout.CENTER);
		panelResultats.setLayout(new BoxLayout(panelResultats, BoxLayout.X_AXIS));
		
		Box verticalBox = Box.createVerticalBox();
		panelResultats.add(verticalBox);
		
		JLabel lblResultats = new JLabel("Résultats");
		verticalBox.add(lblResultats);
		
		JTextArea textAreaResultats = new JTextArea();
		verticalBox.add(textAreaResultats);
		
		JPanel panelOptions = new JPanel();
		frame.getContentPane().add(panelOptions, BorderLayout.WEST);
		panelOptions.setLayout(new BorderLayout(0, 0));
		
		JPanel panelChoixListes = new JPanel();
		panelOptions.add(panelChoixListes, BorderLayout.NORTH);
		panelChoixListes.setLayout(new BoxLayout(panelChoixListes, BoxLayout.X_AXIS));
		
		Box verticalBoxEB = Box.createVerticalBox();
		panelChoixListes.add(verticalBoxEB);
		
		Box horizontalBoxLblEB = Box.createHorizontalBox();
		verticalBoxEB.add(horizontalBoxLblEB);
		
		Component horizontalStrutEBLbl1 = Box.createHorizontalStrut(20);
		horizontalBoxLblEB.add(horizontalStrutEBLbl1);
		
		JLabel lblEntreprisesBases = new JLabel("Choix Entreprises/Bases");
		horizontalBoxLblEB.add(lblEntreprisesBases);
		
		Component horizontalStrutEBLbl2 = Box.createHorizontalStrut(20);
		horizontalBoxLblEB.add(horizontalStrutEBLbl2);
		
		Component verticalStrutEB = Box.createVerticalStrut(20);
		verticalBoxEB.add(verticalStrutEB);
		
		Box horizontalBoxJlistEB = Box.createHorizontalBox();
		verticalBoxEB.add(horizontalBoxJlistEB);
		
		Component horizontalStrutJEB1 = Box.createHorizontalStrut(20);
		horizontalBoxJlistEB.add(horizontalStrutJEB1);
		
		JList listeEntreprises = new JList();
		listeEntreprises.setModel(new AbstractListModel() {
			String[] values = new String[] {"Liste E 1", "Liste E 2", "Liste E 3", "Liste E 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		horizontalBoxJlistEB.add(listeEntreprises);
		
		Component horizontalGlueJEB1 = Box.createHorizontalGlue();
		horizontalBoxJlistEB.add(horizontalGlueJEB1);
		
		JList listeBases = new JList();
		listeBases.setModel(new AbstractListModel() {
			String[] values = new String[] {"Liste B 1", "Liste B 2", "Liste B 3", "Liste B 4"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		horizontalBoxJlistEB.add(listeBases);
		
		Component horizontalStrutJEB2 = Box.createHorizontalStrut(20);
		horizontalBoxJlistEB.add(horizontalStrutJEB2);
		
		JPanel panelAlgorithmes = new JPanel();
		panelOptions.add(panelAlgorithmes, BorderLayout.SOUTH);
		panelAlgorithmes.setLayout(new BoxLayout(panelAlgorithmes, BoxLayout.X_AXIS));
		
		Box verticalBoxPanelOptions = Box.createVerticalBox();
		panelAlgorithmes.add(verticalBoxPanelOptions);
		
		Box horizontalBoxTitre = Box.createHorizontalBox();
		verticalBoxPanelOptions.add(horizontalBoxTitre);
		
		JLabel lblAlgorithmes = new JLabel("Algorithmes");
		horizontalBoxTitre.add(lblAlgorithmes);
		
		Box horizontalBoxOptions = Box.createHorizontalBox();
		verticalBoxPanelOptions.add(horizontalBoxOptions);
		
		Box verticalBoxChoix = Box.createVerticalBox();
		horizontalBoxOptions.add(verticalBoxChoix);
		
		JRadioButton rdbtnBranchBound = new JRadioButton("Branch & Bound");
		verticalBoxChoix.add(rdbtnBranchBound);
		
		JRadioButton rdbtnGlouton = new JRadioButton("Glouton");
		verticalBoxChoix.add(rdbtnGlouton);
		
		JPanel panelLancement = new JPanel();
		frame.getContentPane().add(panelLancement, BorderLayout.SOUTH);
		panelLancement.setLayout(new BoxLayout(panelLancement, BoxLayout.X_AXIS));
		
		Box horizontalBoxLancement = Box.createHorizontalBox();
		panelLancement.add(horizontalBoxLancement);
		
		Component horizontalGlueLancement = Box.createHorizontalGlue();
		horizontalBoxLancement.add(horizontalGlueLancement);
		
		JButton btnLancement = new JButton("Lancement");
		btnLancement.setHorizontalAlignment(SwingConstants.RIGHT);
		horizontalBoxLancement.add(btnLancement);
	}

}
