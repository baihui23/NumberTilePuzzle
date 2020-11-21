package test.boundary;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import project.boundary.NumberPuzzleApp;
import project.boundary.UpdateButtons;
import project.model.Model;
import project.model.MoveType;

class TestUpdateButtons {
	
	Model model = new Model();
	NumberPuzzleApp app = new NumberPuzzleApp(model);
	UpdateButtons ub = new UpdateButtons();

	@Test
	void testNoMovesAvail() {
		ArrayList<MoveType> moves = new ArrayList<MoveType>();
		moves.add(MoveType.NONE);
		UpdateButtons.enableButtons(app, moves);
	}
	
	@Test
	void testAllMovesAvail() {
		ArrayList<MoveType> moves = new ArrayList<MoveType>();
		moves.add(MoveType.LEFT);
		moves.add(MoveType.RIGHT);
		moves.add(MoveType.UP);
		moves.add(MoveType.DOWN);

		UpdateButtons.enableButtons(app, moves);
		
		assertTrue(app.getLeftButton().isEnabled());
		assertTrue(app.getRightButton().isEnabled());
		assertTrue(app.getUpButton().isEnabled());
		assertTrue(app.getDownButton().isEnabled());
	}

}
