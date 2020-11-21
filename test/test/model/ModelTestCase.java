package test.model;

import java.util.Optional;

import org.junit.Before;

import project.model.Coordinate;
import project.model.Model;
import project.model.Puzzle;
import project.model.Tile;

public abstract class ModelTestCase {

	protected Model model;
	
	//easier way to get a Tile from Model class using a Coordinate
	protected Optional<Tile> getTile(Coordinate c) {
		for (Tile t : model.getPuzzle()) {
			if (t.contains(c)) {
				return Optional.of(t);
			}
		}
		return Optional.empty();
	}

	@Before
	public void setUp() {
		model = new Model();  
		Puzzle puzzle = new Puzzle(3, 3);

		puzzle.add(new Tile(5), 0, 0);
		puzzle.add(new Tile(9), 1, 0);	
		puzzle.add(new Tile(6), 2, 0);

		puzzle.add(new Tile(8), 0, 1);
		puzzle.add(new Tile(7), 1, 1);
		puzzle.add(new Tile(3), 2, 1);

		puzzle.add(new Tile(4), 0, 2);
		puzzle.add(new Tile(2), 1, 2);
		puzzle.add(new Tile(1), 2, 2);

		model.setPuzzle(puzzle);
	}

}

