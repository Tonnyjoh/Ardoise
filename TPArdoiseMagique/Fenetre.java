import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;

public class Fenetre {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fen fenetre =  new Fen();
	}

}
class Fen extends JFrame{
	private Panneau panel= new Panneau();
	private JPanel conteneur= new JPanel();
	private JMenuBar menuBar= new JMenuBar();
	private JMenu fichier=new JMenu("Fichier"),
			edition= new JMenu("Edition"),
			formeP= new JMenu("Forme du pointeur"),
			couleurP= new JMenu("Couleur du pointeur");
	private	JMenuItem effacer= new JMenuItem("Effacer"),
			quitter= new JMenuItem("Quitter"),
			rond= new JMenuItem("Rond"),
			carre= new JMenuItem("Carre"),
			rouge= new JMenuItem("rouge"),
			vert = new JMenuItem("vert"),
			bleu = new	JMenuItem("bleu");
	private JToolBar toolBar= new JToolBar();
	private JButton rondB= new JButton(new ImageIcon("images/rond.png"));
	private	JButton carreB= new JButton(new ImageIcon("images/carre.png"));
	private	JButton bleuB= new JButton(new ImageIcon("images/bleu.png"));
	private	JButton vertB= new JButton(new ImageIcon("images/vert.png"));
	private	JButton rougeB= new JButton(new ImageIcon("images/rouge.png"));
	private Color fond= Color.white;
	Fen(){
		//mnemo
		fichier.setMnemonic('F');
		edition.setMnemonic('E');
		formeP.setMnemonic('O');
		couleurP.setMnemonic('C');
		//accelerateur
        effacer.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,KeyEvent.CTRL_DOWN_MASK));
        quitter.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q,KeyEvent.CTRL_DOWN_MASK));
        //Menu
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
        //ajout des listeners
        couleurListener cl= new couleurListener();
        rouge.addActionListener(cl);
        bleu.addActionListener(cl);
        vert.addActionListener(cl);
        rougeB.addActionListener(cl);
        bleuB.addActionListener(cl);
        vertB.addActionListener(cl);
        
        formeListener fl= new formeListener();
        rond.addActionListener(fl);
        carre.addActionListener(fl);
        rondB.addActionListener(fl);
        carreB.addActionListener(fl);
        effacer.addActionListener(new ActionListener() {
        	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBlanc(true);
			}
        	
        });
        quitter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
        	
        });
        //barre d'outil
        rondB.setBackground(fond);
        carreB.setBackground(fond);
        rougeB.setBackground(fond);
        vertB.setBackground(fond);
        bleuB.setBackground(fond);
        toolBar.add(rondB);
        toolBar.add(carreB);
        toolBar.add(vertB);
        toolBar.add(bleuB);
        toolBar.add(rougeB);
        
		conteneur.setLayout(new BorderLayout());
		conteneur.add(panel,BorderLayout.CENTER);
		this.setSize(1000,600);
		this.setTitle("Ardoise E");
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setContentPane(conteneur);
		this.add(toolBar,BorderLayout.NORTH);
		this.setJMenuBar(menuBar);
		this.setVisible(true);
		
		
		
	}
	class couleurListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(bleu)||e.getSource().equals(bleuB)) {
				panel.setColor(Color.blue);
			}
			if(e.getSource().equals(rouge) ||e.getSource().equals(rougeB)) {
				panel.setColor(Color.red);
			}
			if(e.getSource().equals(vert) ||e.getSource().equals(vertB)) {
				panel.setColor(Color.green);
			}
		}
		
	}
	class formeListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource().equals(rond)||e.getSource().equals(rondB)) {
				panel.setType("Rond");
			}else {
				panel.setType("Carre");
			}
			
		}
		
	}
 
}
