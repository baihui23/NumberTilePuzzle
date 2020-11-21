package project.model;

/* 
 * A Coordinate will be a location (col, row) not based on pixels.
 * The boundaries for a location is defined within PuzzlePanel as
 * tileSize.
 */

public class Coordinate {
	public final int col;
	public final int row;

	public Coordinate(int col, int row) {
		this.col = col;
		this.row = row;
	}

}
