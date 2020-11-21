package project.boundary;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JPanel;

import project.model.Coordinate;
import project.model.Model;
import project.model.Puzzle;
import project.model.Tile;

public class PuzzlePanel extends JPanel {

	Model model;
	public static final int tileSize = 90;
	public static final int offset = 5;

	public PuzzlePanel(Model m) {
		this.model = m;
	}

	public Rectangle computeRect(Tile t) {

		//row and columns are indexed starting at 1
		int row = t.getRow();
		int col = t.getColumn();

		//Tiles are square, all 1x1 unit in size 
		Rectangle r = new Rectangle(col*tileSize + offset, row*tileSize + offset, 
				tileSize - offset, tileSize - offset);
		return r;
	}

	public Coordinate pointToCoord(Point p) {
		return new Coordinate(p.x/tileSize, p.y/tileSize);
	}


	//Creates and draws Rectangles for each Tile
	//Also checks if a Tile is selected and recolors accordingly
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (model == null) { return; } //there's nothing to draw

		Tile selected = model.getSelected();
		Puzzle puzzle = model.getPuzzle();

		for (Tile t : puzzle) {
			
			//acknowledge Tile is selected by giving it a different color
			if (t.equals(selected)) {
				g.setColor(new Color(176,224,230));
			} else {
				g.setColor(Color.WHITE);
			}

			Rectangle r = computeRect(t);
			g.fillRect(r.x, r.y, r.width, r.height);

			//convert Tile value to String and display value on puzzle
			g.setColor(Color.BLACK);
			g.setFont(new Font("Serif", Font.BOLD, 25));
			g.drawString(String.valueOf(t.getValue()), r.x + (r.width/2), r.y + (r.height/2));
		}



	}

}
