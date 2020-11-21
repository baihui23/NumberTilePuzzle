package test.boundary;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

import org.junit.jupiter.api.Test;

import project.boundary.PuzzlePanel;
import project.model.Coordinate;
import project.model.Model;
import project.model.Tile;

class TestPuzzlePanel {
	
	Model model = new Model();
	PuzzlePanel panel = new PuzzlePanel(model);

	@Test
	public void testComputeRect() {
		Tile t = new Tile(1);
		model.getPuzzle().add(t, 0, 0);
		
		assertEquals(panel.computeRect(t), new Rectangle(5, 5, 85, 85));
	}
	
	@Test
	public void testPointToCoord() {
		Point p = new Point(10, 10);
		assertEquals(panel.pointToCoord(p), new Coordinate(0, 0));
	}
	
	@Test
	public void testPaint() {
		Graphics g = null;
		panel.paintComponent(g);
	}

}
