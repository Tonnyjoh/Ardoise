package src;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

public class Panneau extends JPanel {
	private String forme = "Rond";
	private int taillePoint = 20;
	private Color couleurDef = Color.DARK_GRAY;
	private List<Point> tracee = new ArrayList<Point>();
	private boolean effacer = false;

	public Panneau() {
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tracee.add(new Point(e.getX(), e.getY(), taillePoint, couleurDef, forme));
				repaint();
			}
		});

		addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				tracee.add(new Point(e.getX(), e.getY(), taillePoint, couleurDef, forme));
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());

		if (effacer) {
			tracee.clear();
			effacer = false;
		} else {
			for (Point p : tracee) {
				g.setColor(p.getCouleur());
				if (p.getType().equals("Rond")) {
					g.fillOval(p.getCordX(), p.getCordY(), p.getTaille(), p.getTaille());
				} else {
					g.fillRect(p.getCordX(), p.getCordY(), p.getTaille(), p.getTaille());
				}
			}
		}
	}

	public void setColor(Color c) {
		this.couleurDef = c;
	}

	public void setType(String str) {
		this.forme = str;
	}

	public void setTaille(int taille) {
		this.taillePoint = taille;
	}

	public void clearCanvas() {
		effacer = true;
		repaint();
	}
}
