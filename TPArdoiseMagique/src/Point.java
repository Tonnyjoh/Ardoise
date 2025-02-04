package src;

import java.awt.Color;

public class Point {
	private int taille;
	private Color couleur;
	private int cordX;
	private int cordY;
	private String type;

	public Point(int cordX, int cordY, int taille, Color couleur, String type) {
		this.cordX = cordX;
		this.cordY = cordY;
		this.taille = taille;
		this.couleur = couleur;
		this.type = type;
	}

	public int getTaille() {
		return taille;
	}

	public Color getCouleur() {
		return couleur;
	}

	public int getCordX() {
		return cordX;
	}

	public int getCordY() {
		return cordY;
	}

	public String getType() {
		return type;
	}
}
