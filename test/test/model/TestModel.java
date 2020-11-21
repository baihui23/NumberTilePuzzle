package test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import project.Main;
import project.model.Coordinate;
import project.model.Model;
import project.model.MoveType;
import project.model.Tile;

public class TestModel { 
	
	Model model = new Model();
	
	@Test
	public void testConstructor() {
		assertEquals(model.getNumMoves(), 0);
		assertEquals(model.isGameOver(), false);
		assertEquals(model.getSelected(), null);
		assertEquals(model.availableMoves().size(), 0);
	}
	
	@Test
	public void testAvailMoves() {
		Tile t = model.getTileFrom(new Coordinate (1, 1));
		model.setSelected(t);
		ArrayList<MoveType> moves = new ArrayList<MoveType>();
		moves = model.availableMoves(t);
		
		assertTrue(moves.contains(MoveType.LEFT));
		assertTrue(moves.contains(MoveType.RIGHT));
		assertTrue(moves.contains(MoveType.UP));
	}
	
	@Test
	public void testSetters() {
		model.setNumMoves(1);
		assertEquals(model.getNumMoves(), 1);
		
		model.setGameOver(true);
		assertEquals(model.isGameOver(), true);
		model.setGameOver(false);
		
		model.clearSelected();
		assertEquals(model.getSelected(), null);
	}
	
	@Test
	public void testWin() {
		model.getPuzzle().getTileSet().clear();
		model.getPuzzle().add(new Tile(1), 1, 1);
		assertEquals(model.isWinCondition(), true);
		
		model.resetPuzzle();
		assertFalse(model.isWinCondition());
	}
	
	@Test
	public void testLose() {
		model.getPuzzle().getTileSet().clear();
		model.getPuzzle().add(new Tile(1), 0, 1);
		assertEquals(model.isLoseCondition(), true);
		
		model.getPuzzle().add(new Tile(2), 2, 1);
		assertEquals(model.isLoseCondition(), true);
		
		model.resetPuzzle();
		assertFalse(model.isLoseCondition());
	}
	
 
	@Test
	public void testTryMoveNoSelected() {
		model.setSelected(null);

		assertEquals(model.tryMove(MoveType.NONE), false);
	}


	@Test
	public void testReset() {
		model.resetPuzzle();
	}
	
	
}
