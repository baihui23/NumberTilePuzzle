package test.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.boundary.NumberPuzzleApp;
import project.controller.ExitController;
import project.controller.MovePieceController;
import project.controller.ResetController;
import project.controller.SelectPieceController;
import project.model.Coordinate;
import project.model.Model;
import project.model.MoveType;
import test.model.ModelTestCase;

class TestMoveController {
	
	Model model = new Model();
	NumberPuzzleApp app = new NumberPuzzleApp(model);
	MovePieceController mpc = new MovePieceController(model, app);
	

	@Test
	public void testNullSelectedMove() {
		model.setSelected(null);
		assertEquals(model.tryMove(MoveType.LEFT), false);
	}
	
	@Test
	public void testMove() {
		model.resetPuzzle();
		model.setSelected(model.getTileFrom(new Coordinate(1, 1)));
		assertEquals(model.tryMove(MoveType.LEFT), true);
		assertEquals(model.tryMove(MoveType.DOWN), false);
		
		//perform MoveType.LEFT on selected
		mpc.calculateMove(new Coordinate(model.getSelected().getColumn() - 1, model.getSelected().getRow()),
				MoveType.LEFT);
	}
	
	@Test
	public void testRight() {
		model.resetPuzzle();
		model.setSelected(model.getTileFrom(new Coordinate(1, 1)));
		mpc.calculateMove(new Coordinate(model.getSelected().getColumn() + 1, model.getSelected().getRow()),
				MoveType.RIGHT);

	}
	
	@Test
	public void testWinMsg() {
		mpc.winGame();
	}
	
	@Test
	public void testLoseMsg() {
		mpc.loseGame();
	}

}
