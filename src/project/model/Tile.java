package project.model;

public class Tile {

	int value;
	int column;
	int row;
	
	public Tile(int value) {
		this.value = value;
	}
	
	public Tile copy() {
		Tile t = new Tile(value);
		t.column = column;
		t.row = row;
		return t;
	}
	
	public int getValue() { return value; }
	public void setValue(int v) { value = v; }
	
	public int getRow() { return row; }
	public void setRow(int r) { row = r; }
	
	public int getColumn() { return column; }
	public void setColumn(int c) { column = c; }
	
	public Coordinate getWhere() { return new Coordinate(column, row); }
	
	
	public boolean contains(Coordinate c) {
		
		//the column and row of a Tile should be equal to
		//the Coordinate that was clicked
		if((c.col == column) && (c.row == row)) {
			return true;
		}
		return false;
	}
	
	public void move(MoveType direction) {
		if (direction == MoveType.NONE) { return; }
		
		this.column += direction.deltaC;
		this.row += direction.deltaR;

	}

	
}
