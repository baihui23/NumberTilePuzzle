package test.boundary;

import static org.junit.jupiter.api.Assertions.*;

import javax.swing.JLabel;

import org.junit.jupiter.api.Test;

import project.boundary.NumberPuzzleApp;
import project.boundary.PuzzlePanel;
import project.model.Model;

class TestApp {

	Model model = new Model();
	NumberPuzzleApp app = new NumberPuzzleApp(model);
	
	
	@Test
	public void testGetNumMoves() {
		JLabel numMoves = new JLabel("" + model.getNumMoves());
		assertEquals(app.getNumMovesLabel(), numMoves);
	}
	
	@Test
	public void testGetPuzzlePanel() {
		PuzzlePanel p = new PuzzlePanel(model);
		assertEquals(app.getPuzzlePanel(), p);
	}

}
