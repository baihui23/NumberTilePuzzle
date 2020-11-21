package project.controller;

import java.awt.Point;
import java.util.ArrayList;

import project.boundary.NumberPuzzleApp;
import project.boundary.UpdateButtons;
import project.model.Coordinate;
import project.model.Model;
import project.model.MoveType;
import project.model.Puzzle;
import project.model.Tile;

public class SelectPieceController {
	Model model;
	NumberPuzzleApp app;

	public SelectPieceController(Model m, NumberPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	public void processPoint(Point point) {
		Coordinate c = app.getPuzzlePanel().pointToCoord(point);
		
		Puzzle puzzle = model.getPuzzle();
		for (Tile t : puzzle) {
			if (t.contains(c)) {
				model.clearSelected();
				model.setSelected(t);
				
				ArrayList<MoveType> moves = model.availableMoves(t);
				UpdateButtons.enableButtons(app, moves);
				
				app.repaint();
			}
		}
		
		
		
	}
}
