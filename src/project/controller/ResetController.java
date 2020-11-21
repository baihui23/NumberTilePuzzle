package project.controller;

import project.boundary.NumberPuzzleApp;
import project.boundary.UpdateButtons;
import project.model.Model;

public class ResetController {
	
	Model model;
	NumberPuzzleApp app;

	public ResetController(Model m, NumberPuzzleApp app) {
		this.model = m;
		this.app = app;
	}
	
	public void reset() {
		model.resetPuzzle();
		UpdateButtons.enableButtons(app, model.availableMoves());
		app.getNumMovesLabel().setText("" + model.getNumMoves());
		
		app.repaint();
	}

}
