package project.model;

import java.util.ArrayList;
import java.util.Iterator;

public class Puzzle implements Iterable<Tile> {

	public final int width;
	public final int height;
	ArrayList<Tile> tiles = new ArrayList<Tile>();

	ArrayList<Tile> originals = new ArrayList<Tile>();

	public Puzzle(int w, int h) {
		this.width = w;
		this.height = h;
	}

	public int getWidth() { return width; }

	public int getHeight() { return height; }

	public ArrayList<Tile> getTileSet() { return tiles; }

	//adds Tile to set with given placement
	public void add(Tile t, int col, int row) {
		t.column = col;
		t.row = row;
		tiles.add(t);
		originals.add(t.copy());
	}


	//checks if given Coordinate contains a Tile
	public boolean isOccupied(Coordinate coord) {
		for (Tile t : tiles) {
			if (t.contains(coord)) {
				return true;
			}
		}

		return false;
	}


	//gets Tile from given Coordinate
	public Tile getTileFrom(Coordinate c) {
		for (Tile t : tiles) {
			if (t.contains(c)) {
				return t;
			}
		}

		return null;
	}

	public void setTileValue(Tile t, int newVal) {
		t.setValue(newVal);
	}

	public void remove(Coordinate c) {
		for (int i = 0; i < tiles.size(); i++) {
			if (tiles.get(i).equals(getTileFrom(c))) {
				tiles.remove(i);
			}
		}
	}

	@Override
	public Iterator<Tile> iterator() {
		return tiles.iterator();
	}

	public void reset() {
		tiles.clear();
		for (Tile t : originals) {
			tiles.add(t.copy());
		}
	}

	public boolean isWinCondition() {
		
		//in order to win, there should only be one Tile in the
		//puzzle which should be in the center spot
		Coordinate center = new Coordinate(1, 1);
		if (tiles.size() == 1 && isOccupied(center)) {
			return true;
		}
		return false;
	}


}
