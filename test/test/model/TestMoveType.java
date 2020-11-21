package test.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.model.MoveType;

class TestMoveType {

	@Test
	void testLeft() {
		assertEquals(MoveType.LEFT.getDeltaC(), -1);
		assertEquals(MoveType.LEFT.getDeltaR(), 0);
	}
	
	@Test
	void testRight() {
		assertEquals(MoveType.RIGHT.getDeltaC(), 1);
		assertEquals(MoveType.RIGHT.getDeltaR(), 0);
	}
	
	@Test
	void testUp() {
		assertEquals(MoveType.UP.getDeltaC(), 0);
		assertEquals(MoveType.UP.getDeltaR(), -1);
	}
	
	@Test
	void testDown() {
		assertEquals(MoveType.DOWN.getDeltaC(), 0);
		assertEquals(MoveType.DOWN.getDeltaR(), 1);
	}

}
