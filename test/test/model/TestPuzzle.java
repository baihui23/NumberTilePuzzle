package test.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import project.model.Coordinate;
import project.model.Puzzle;
import project.model.Tile;

class TestPuzzle {
	
	Puzzle p = new Puzzle(3, 3);

	@Test
	void testInitial() {
		assertEquals(p.getHeight(), 3);
		assertEquals(p.getWidth(), 3);
		
		ArrayList<Tile> tiles = new ArrayList<Tile>();
		assertEquals(p.getTileSet(), tiles);
	}
	
	@Test
	void testGetTile() {
		Tile t = new Tile(5);
		p.add(t, 1, 1);
		
		assertEquals(p.isOccupied(new Coordinate(1, 1)), true);
		assertEquals(p.isOccupied(new Coordinate(1, 2)), false);
		
		assertEquals(p.getTileFrom(new Coordinate(1, 1)), t);
		assertEquals(p.getTileFrom(new Coordinate(1, 2)), null);
	}
	
	@Test
	void testSetVal() {
		Tile t = new Tile(5);
		p.add(t, 1, 1);
		p.setTileValue(t, 2);
		
		assertEquals(p.getTileFrom(new Coordinate(1, 1)).getValue(), 2);
	}
	
	@Test
	void testWin() {
		Tile t = new Tile(5);
		p.add(t, 1, 1);
		
		assertEquals(p.isWinCondition(), true);
	}
	
	@Test
	void testNotWin() {
		//single Tile in center
		Tile t = new Tile(5);
		p.add(t, 1, 1);
		assertEquals(p.isWinCondition(), true);
		
		//single Tile but not in center
		p.remove(new Coordinate(1, 1));
		p.add(new Tile(3), 0, 0);
		assertEquals(p.isWinCondition(), false);
		
		//no tiles
		p.getTileSet().clear();
		assertEquals(p.isWinCondition(), false);

		//multiple Tiles
		p.add(new Tile(3), 0, 0);
		p.add(new Tile(5), 0, 1);
		assertEquals(p.isWinCondition(), false);
	}

}
