package ihm;

import glouton.AlgorithmeGlouton;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.BorderLayout;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Component;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map.Entry;

import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import branchAndBound.AlgorithmeBranchAndBound;
import model.Model;
import readers.Lecteur;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ihm {

	private JFrame frame;
	private JList<String> listeEntreprises;
	private JList<String> listeBases;
	private JRadioButton rdbtnBranchBound;
	private JRadioButton rdbtnGlouton;
	private ButtonGroup choixAlgorithme;
	private JTextArea textAreaResultats;
	
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
		
		textAreaResultats = new JTextArea();
		verticalBox.add(textAreaResultats);
		
		JPanel panelOptions = new JPanel();
		frame.getContentPane().add(panelOptions, BorderLayout.WEST);
		panelOptions.setLayout(new BorderLayout(0, 0));
		
		JPanel panelAlgorithmes = new JPanel();
		panelAlgorithmes.setBorder(new TitledBorder(null, "Algorithmes", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelOptions.add(panelAlgorithmes, BorderLayout.SOUTH);
		panelAlgorithmes.setLayout(new BoxLayout(panelAlgorithmes, BoxLayout.X_AXIS));
		
		Box verticalBoxPanelOptions = Box.createVerticalBox();
		panelAlgorithmes.add(verticalBoxPanelOptions);
		
		Box horizontalBoxTitre = Box.createHorizontalBox();
		verticalBoxPanelOptions.add(horizontalBoxTitre);
		
		Box horizontalBoxOptions = Box.createHorizontalBox();
		verticalBoxPanelOptions.add(horizontalBoxOptions);
		
		Box verticalBoxChoix = Box.createVerticalBox();
		horizontalBoxOptions.add(verticalBoxChoix);
		
		choixAlgorithme = new ButtonGroup();
		
		rdbtnBranchBound = new JRadioButton("Branch & Bound");
		verticalBoxChoix.add(rdbtnBranchBound);
		choixAlgorithme.add(rdbtnBranchBound);
		
		rdbtnGlouton = new JRadioButton("Glouton");
		verticalBoxChoix.add(rdbtnGlouton);
		choixAlgorithme.add(rdbtnGlouton);
		
		JPanel panelEntreprisesBases = new JPanel();
		panelOptions.add(panelEntreprisesBases, BorderLayout.NORTH);
		panelEntreprisesBases.setLayout(new BorderLayout(0, 0));
		
		JPanel panelEntreprises = new JPanel();
		panelEntreprises.setBorder(new TitledBorder(null, "Entreprises", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEntreprisesBases.add(panelEntreprises, BorderLayout.NORTH);
		panelEntreprises.setLayout(new BorderLayout(0, 0));
		
		listeEntreprises = new JList<String>(remplirListeEntreprises());
		panelEntreprises.add(listeEntreprises, BorderLayout.CENTER);
		
		JPanel panelBases = new JPanel();
		panelBases.setBorder(new TitledBorder(null, "Bases", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelEntreprisesBases.add(panelBases, BorderLayout.SOUTH);
		panelBases.setLayout(new BorderLayout(0, 0));
		
		listeBases = new JList<String>(remplirListeBases());
		panelBases.add(listeBases, BorderLayout.CENTER);
		
		JPanel panelLancement = new JPanel();
		frame.getContentPane().add(panelLancement, BorderLayout.SOUTH);
		panelLancement.setLayout(new BoxLayout(panelLancement, BoxLayout.X_AXIS));
		
		Box horizontalBoxLancement = Box.createHorizontalBox();
		panelLancement.add(horizontalBoxLancement);
		
		Component horizontalGlueLancement = Box.createHorizontalGlue();
		horizontalBoxLancement.add(horizontalGlueLancement);
		
		JButton btnLancement = new JButton("Lancement");
		btnLancement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				// Initialisation du compteur temps;
				long debut = System.currentTimeMillis();
				
				// Choix des fichiers
				String cheminListeBases = "./bin/docs/listesBases/" + listeBases.getSelectedValue();
				String cheminListeEntreprises = "./bin/docs/listesEntreprises/" + listeEntreprises.getSelectedValue();
				
				// Lecture des fichiers
				Lecteur lecteur = new Lecteur(cheminListeBases, cheminListeEntreprises);
				Model model = new Model();
				lecteur.lireBases();
				model.setBases(lecteur.getBases());
				model.setEntreprises(lecteur.lireEntreprises());
				model.setEntreprisesBases(lecteur.getEntreprisesBases());
				
				// Temps intermédiaire = chargement des fichiers
				long inter = System.currentTimeMillis();
				textAreaResultats.append("TEMPS DE CHARGEMENT DES FICHIERS : " + (inter - debut) + " ms\n");
				
				if (rdbtnBranchBound.isSelected()) {
					AlgorithmeBranchAndBound algoBB = new AlgorithmeBranchAndBound(model);
					// Temps final = temps d'éxecution de l'algorithme
					long fin = System.currentTimeMillis();
					textAreaResultats.append("TEMPS D'EXECUTION DE L'ALGORITHME DE BRANCH & BOUND : " + (fin - inter) + " ms\n");
				}
				
				if (rdbtnGlouton.isSelected()) {
					AlgorithmeGlouton algoGlouton = new AlgorithmeGlouton(model);
					// Temps final = temps d'éxecution de l'algorithme
					long fin = System.currentTimeMillis();
					textAreaResultats.append("TEMPS D'EXECUTION DE L'ALGORITHME GLOUTON : " + (fin - inter) + " ms\n\n");
					textAreaResultats.append("Meilleur coût : " + algoGlouton.getResultatCout() + "\n\n");
					for (Entry<String, ArrayList<String>> entry : algoGlouton.getResultatListe().entrySet()) {
						textAreaResultats.append("\tBase" + entry.getKey() + "\n");
						for (String entreprise : entry.getValue()) {
							textAreaResultats.append("\t\t" + entreprise + "\n");
						}
					}
				}
				
				
				
			}
		});
		btnLancement.setHorizontalAlignment(SwingConstants.RIGHT);
		horizontalBoxLancement.add(btnLancement);
	}
	
	private DefaultListModel<String> remplirListeBases() { 
		File[] fichiers = null; 
		File repertoire = new File("bin/docs/listesBases"); 
		fichiers = repertoire.listFiles();
		ArrayList<String> listeTemporaire = new ArrayList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (File file : fichiers) {
			listeTemporaire.add(file.getName());
		}
		Collections.sort(listeTemporaire);
		for (String nomFichier : listeTemporaire) {
			listModel.addElement(nomFichier);
		}
		return listModel;
	}
	
	private DefaultListModel<String> remplirListeEntreprises() { 
		File[] fichiers = null; 
		File repertoire = new File("bin/docs/listesEntreprises"); 
		fichiers = repertoire.listFiles();
		ArrayList<String> listeTemporaire = new ArrayList<String>();
		DefaultListModel<String> listModel = new DefaultListModel<String>();
		for (File file : fichiers) {
			listeTemporaire.add(file.getName());
		}
		Collections.sort(listeTemporaire);
		for (String nomFichier : listeTemporaire) {
			listModel.addElement(nomFichier);
		}
		return listModel;
	}

}
