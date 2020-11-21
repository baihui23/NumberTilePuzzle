package project.model;

import java.util.ArrayList;

import project.boundary.UpdateButtons;

public class Model {

	Puzzle puzzle;
	boolean gameOver = false;
	Tile selected;
	int numMoves = 0;

	public Model() {
		/*
		 * This is the assigned starting placements 
		 * for each tile with its initial value:
		 * 
		 * 		5	|	9	|	6
		 * 		-----------------
		 * 		8	|	7	|	3
		 * 		-----------------
		 * 		4	|	2	|	1
		 */
		
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
		
		setPuzzle(puzzle);
	}

	public boolean tryMove(MoveType direction) {
		if(selected == null) { return false; }

		for (MoveType move : availableMoves(selected)) {
			if (direction == move && direction != MoveType.NONE) {
				return true;
			}
		}
		return false;
	}

	

	public ArrayList<MoveType> availableMoves() {
		ArrayList<MoveType> moves = new ArrayList<>();

		if(selected == null) {
			return moves;
		}

		availableMoves(selected);
		return moves;
	}


	//check where a specific Tile can move to
	//the result must be a non-negative integer
	public ArrayList<MoveType> availableMoves(Tile t) {
		ArrayList<MoveType> moves = new ArrayList<>();
		Coordinate c = t.getWhere();

		//check left of Tile
		Coordinate toLeft = new Coordinate(c.col + MoveType.LEFT.deltaC, c.row + MoveType.LEFT.deltaR);
		//the move cannot return a negative value
		if (puzzle.isOccupied(toLeft) && (puzzle.getTileFrom(toLeft).getValue() - t.getValue()) >= 0) {
			moves.add(MoveType.LEFT);
		}

		//check right
		Coordinate toRight = new Coordinate(c.col + MoveType.RIGHT.deltaC, c.row + MoveType.RIGHT.deltaR);
		if (puzzle.isOccupied(toRight)) {
			moves.add(MoveType.RIGHT);
		}

		//check above
		Coordinate toUp = new Coordinate(c.col + MoveType.UP.deltaC, c.row + MoveType.UP.deltaR);
		if (puzzle.isOccupied(toUp)) {
			moves.add(MoveType.UP);
		}

		//check below
		Coordinate toDown = new Coordinate(c.col + MoveType.DOWN.deltaC, c.row + MoveType.DOWN.deltaR);
		//the move cannot return a non-integer value
		if (puzzle.isOccupied(toDown) && (((double)puzzle.getTileFrom(toDown).getValue() / (double)t.getValue()) % 1) == 0) {
			moves.add(MoveType.DOWN);
		}
		return moves;
	}


	public Puzzle getPuzzle() { return puzzle; }
	public void setPuzzle(Puzzle p) { 
		puzzle = p; 
		numMoves = 0;
		selected = null;
		gameOver = false;
	}
	
	public Tile getTileFrom(Coordinate c) { return puzzle.getTileFrom(c); }
 
	public Tile getSelected() { return selected; }
	public void setSelected(Tile t) { selected = t; } 
	public void clearSelected() { selected = null; }

	public int getNumMoves() { return numMoves; }
	public void setNumMoves(int n) { numMoves = n; }

	public boolean isGameOver() { return gameOver; }
	public void setGameOver(boolean b) { gameOver = b; }

	public void resetPuzzle() {
		puzzle.reset();
		numMoves = 0;
		selected = null;
		gameOver = false;
	}

	public boolean isWinCondition() {
		Coordinate center = new Coordinate (1, 1);
		if (puzzle.getTileSet().size() == 1 && puzzle.isOccupied(center)) {
			return true;
		}
		return false;
	}

	public boolean isLoseCondition() {
		
		//check for one tile but not in center
		Coordinate center = new Coordinate(1, 1);
		if (puzzle.getTileSet().size() == 1 && !puzzle.isOccupied(center)) {
			return true;
		}
		
		//check for multiple Tiles
		boolean lose = false;
		if (puzzle.getTileSet().size() > 1) {
			
			for (Tile t : puzzle.getTileSet()) {
				if (availableMoves(t).size() == 0) {
					lose = true;
				} else {
					lose = false;
				}
			}
			
		} else {
			lose = false;
		}

		return lose;
	}

}
