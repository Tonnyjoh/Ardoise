package src;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Fenetre {
	public static void main(String[] args) {
		Fen fenetre = new Fen();
	}
}

class Fen extends JFrame {
	private Panneau panel = new Panneau();
	private JPanel conteneur = new JPanel();
	private JMenuBar menuBar = new JMenuBar();
	private JMenu fichier = new JMenu("Fichier"),
			edition = new JMenu("Edition"),
			formeP = new JMenu("Forme du pointeur"),
			couleurP = new JMenu("Couleur du pointeur");

	private JMenuItem effacer = new JMenuItem("Effacer"),
			quitter = new JMenuItem("Quitter"),
			rond = new JMenuItem("Rond"),
			carre = new JMenuItem("Carre"),
			rouge = new JMenuItem("rouge"),
			vert = new JMenuItem("vert"),
			bleu = new JMenuItem("bleu");

	private JToolBar toolBar = new JToolBar();
	private JButton rondB = new JButton(new ImageIcon("images/rond.png"));
	private JButton carreB = new JButton(new ImageIcon("images/carre.png"));
	private JButton bleuB = new JButton(new ImageIcon("images/bleu.png"));
	private JButton vertB = new JButton(new ImageIcon("images/vert.png"));
	private JButton rougeB = new JButton(new ImageIcon("images/rouge.png"));
	private JSlider tailleSlider = new JSlider(JSlider.HORIZONTAL, 5, 50, 20);

	private Color fond = Color.white;

	Fen() {
		// Configuration des menus
		fichier.setMnemonic('F');
		edition.setMnemonic('E');
		formeP.setMnemonic('O');
		couleurP.setMnemonic('C');

		effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));
		quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.CTRL_DOWN_MASK));

		fichier.add(effacer);
		fichier.add(quitter);
		edition.add(formeP);
		edition.add(couleurP);
		formeP.add(carre);
		formeP.add(rond);
		couleurP.add(rouge);
		couleurP.add(bleu);
		couleurP.add(vert);

		menuBar.add(fichier);
		menuBar.add(edition);

		// Listeners pour les couleurs et formes
		couleurListener cl = new couleurListener();
		rouge.addActionListener(cl);
		bleu.addActionListener(cl);
		vert.addActionListener(cl);
		rougeB.addActionListener(cl);
		bleuB.addActionListener(cl);
		vertB.addActionListener(cl);

		formeListener fl = new formeListener();
		rond.addActionListener(fl);
		carre.addActionListener(fl);
		rondB.addActionListener(fl);
		carreB.addActionListener(fl);

		// Action pour effacer
		effacer.addActionListener(e -> panel.clearCanvas());

		quitter.addActionListener(e -> System.exit(0));

		// Slider pour la taille du pinceau
		tailleSlider.setMajorTickSpacing(5);
		tailleSlider.setPaintTicks(true);
		tailleSlider.setPaintLabels(true);
		tailleSlider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				panel.setTaille(tailleSlider.getValue());
			}
		});

		// Barre d'outils
		toolBar.add(rondB);
		toolBar.add(carreB);
		toolBar.add(vertB);
		toolBar.add(bleuB);
		toolBar.add(rougeB);
		toolBar.addSeparator();
		toolBar.add(new JLabel("Taille du pinceau: "));
		toolBar.add(tailleSlider);

		// Conteneur
		conteneur.setLayout(new BorderLayout());
		conteneur.add(panel, BorderLayout.CENTER);
		this.setSize(1000, 600);
		this.setTitle("Ardoise E");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(conteneur);
		this.add(toolBar, BorderLayout.NORTH);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
	}

	class couleurListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(bleu) || e.getSource().equals(bleuB)) {
				panel.setColor(Color.blue);
			} else if (e.getSource().equals(rouge) || e.getSource().equals(rougeB)) {
				panel.setColor(Color.red);
			} else if (e.getSource().equals(vert) || e.getSource().equals(vertB)) {
				panel.setColor(Color.green);
			}
		}
	}

	class formeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource().equals(rond) || e.getSource().equals(rondB)) {
				panel.setType("Rond");
			} else {
				panel.setType("Carre");
			}
		}
	}
}
