package test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.model.Coordinate;
import project.model.MoveType;
import project.model.Puzzle;
import project.model.Tile;

public class TestTile {

	Puzzle p = new Puzzle(3, 3);
	Tile t = new Tile (2);


	@Test
	void testGetters() {
		p.add(t, 0, 1);

		assertEquals(t.getValue(), 2);
		assertEquals(t.getColumn(), 0);
		assertEquals(t.getRow(), 1);

		assertEquals(t.getWhere().col, 0);
		assertEquals(t.getWhere().row, 1);
	}

	@Test
	void testSetters() {
		t.setValue(5);
		t.setColumn(2);
		t.setRow(2);

	}

	@Test
	void testContainsCoord() {
		p.add(t, 0, 1);

		assertTrue(t.contains(new Coordinate (0, 1)));

		assertFalse(t.contains(new Coordinate (1, 0)));
		assertFalse(t.contains(new Coordinate (1, 1)));
		assertFalse(t.contains(new Coordinate (0, 0)));
	}

	@Test
	void testMoveLeft() {
		p.add(t, 1, 1);
		t.move(MoveType.LEFT);

		assertEquals(t.getColumn(), 0);
		assertEquals(t.getRow(), 1);
	}
	
	@Test
	void testMoveRight() {
		p.add(t, 1, 1);
		t.move(MoveType.RIGHT);

		assertEquals(t.getColumn(), 2);
		assertEquals(t.getRow(), 1);
	}
	
	@Test
	void testMoveUp() {
		p.add(t, 1, 1);
		t.move(MoveType.UP);

		assertEquals(t.getColumn(), 1);
		assertEquals(t.getRow(), 0);
	}
	
	@Test
	void testMoveDown() {
		p.add(t, 1, 1);
		t.move(MoveType.DOWN);

		assertEquals(t.getColumn(), 1);
		assertEquals(t.getRow(), 2);
	}
	
	@Test
	void testMoveNone() {
		p.add(t, 1, 1);
		t.move(MoveType.NONE);

		assertEquals(t.getColumn(), 1);
		assertEquals(t.getRow(), 1);
	}

}
