import java.awt.Color;

public class Point {
	private  int taille;
	private Color couleur;
	private int cordX;
	private int cordY;
	private String type;
	
	Point(int cordX, int cordY, int taille, Color couleur,String type ){
		this.cordX= cordX;
		this.cordY= cordY;
		this.taille=taille;
		this.couleur=couleur;
		this.type=type;
	}

	public int getTaille() {
		return taille;
	}

	public void setTaille(int taille) {
		this.taille = taille;
	}

	public Color getCouleur() {
		return couleur;
	}

	public void setCouleur(Color couleur) {
		this.couleur = couleur;
	}

	public int getCordX() {
		return cordX;
	}

	public void setCordX(int cordX) {
		this.cordX = cordX;
	}

	public int getCordY() {
		return cordY;
	}

	public void setCordY(int cordY) {
		this.cordY = cordY;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	 
	
	
	
	
	
	
	
	
	
	
	}
