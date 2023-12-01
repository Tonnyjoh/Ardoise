import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Panneau extends JPanel {
	private String forme ="Rond";
	private int taillePoint=20;
	private Color couleurDef= Color.DARK_GRAY;
	private List<Point> tracee= new ArrayList<Point>();
	private int posX,posY;
	private boolean effacer=true;
	public void peindre() {
		//position du pointeur
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				tracee.add(new Point(e.getX(),e.getY(),taillePoint,couleurDef,forme));
				repaint();
				
			}
		});
		this.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				//System.out.println(e.getX()+"  "+e.getY());
				tracee.add(new Point(e.getX()-(taillePoint/1000),e.getY()-(taillePoint/1000),taillePoint,couleurDef,forme));
				repaint();
				
			}
		});
	}
	private void draw(Graphics g) {
		if(effacer) {
		/*	g.setColor(Color.white);
			g.fillRect(0, 0, this.getWidth(), this.getHeight());
			for(int i=0;i<tracee.size();i++) {
				tracee.set(i,new Point(0,0,taillePoint,Color.white,"Rond"));
			}
		*/	
		     //correction
			this.tracee= new ArrayList<Point>();
			effacer=false;
		}
		else {
		for(Point p:tracee) {
			g.setColor(p.getCouleur());
			if(p.getType().equals("Rond")) {
				g.fillOval(p.getCordX(), p.getCordY(), p.getTaille(), p.getTaille());
				repaint();
			}
			else {
				g.fillRect(p.getCordX(), p.getCordY(), p.getTaille(), p.getTaille());
				repaint();
			}
		}
		}
	}
	public void paintComponent(Graphics g) {
		peindre();
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		draw(g);
	}
	public void setColor(Color c) {
		this.couleurDef=c;
	}	
	public void setType(String str) {
		this.forme=str;
	}
	public void setBlanc(boolean bool) {
		this.effacer=bool;
	}
}	

