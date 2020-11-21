package project.controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import project.boundary.NumberPuzzleApp;
import project.boundary.UpdateButtons;
import project.model.Coordinate;
import project.model.Model;
import project.model.MoveType;
import project.model.Tile;

public class MovePieceController {

	Model model;
	NumberPuzzleApp app;

	public MovePieceController(Model m, NumberPuzzleApp app) {
		this.model = m;
		this.app = app;
	}

	//pop up for winning game
	public void winGame() {
		JOptionPane.showMessageDialog(app, "Congratulations, you won!");
	}

	//pop up for losing game
	public void loseGame() {
		JOptionPane.showMessageDialog(app, "Oops, looks like you've lost. Don't give up!");
	}

	public boolean move(MoveType direction) {		
		if (model.getSelected() == null) { return false; }

		if (model.tryMove(direction)) {

			//make Coordinate for Tile of calculation being performed on
			Coordinate used = new Coordinate(model.getSelected().getColumn() + direction.getDeltaC(), 
					model.getSelected().getRow() + direction.getDeltaR());

			//move and perform calculation on selected Tile
			calculateMove(used, direction);

			//increment move count
			model.setNumMoves(model.getNumMoves() + 1);
			app.getNumMovesLabel().setText("" + model.getNumMoves());

			//reset buttons
			UpdateButtons.enableButtons(app, new ArrayList<>());

			//remove Tile used for calculations
			model.getPuzzle().remove(used);

			//move selected Tile to specified direction
			model.getSelected().move(direction);

			//unselect Tile moved
			model.clearSelected();

			//check for win/lose condition
			if (model.isWinCondition()) {
				model.setGameOver(true);
				app.repaint();
				winGame();
				return true;
			}
			if (model.isLoseCondition()) {
				model.setGameOver(true);
				app.repaint();
				loseGame();
				return true;
			}

			app.repaint();
		}
		return true;
	}

	public void calculateMove(Coordinate used, MoveType move) {
		/*
		 * Coord "used" refers to the Tile used for the calculation.
		 * The used Tile is removed from the puzzle after use, and the
		 * selected Tile is moved into the spot of the used Tile
		 * 
		 * Guide for calculations: 
		 * (t1 refers to selected tile and t2 is the Tile where t1 is replacing)
		 * 
		 * left: t2-t1
		 * right: t2+t1
		 * up: t2*t1
		 * down: t2/t1
		 * 
		 * As with the check for available moves (in Model class), result
		 * must be a non-negative integer.
		 */


		if (move == MoveType.LEFT) {
			model.getSelected().setValue(
					model.getPuzzle().getTileFrom(used).getValue() - model.getSelected().getValue()
					);

		} else if (move == MoveType.RIGHT) {
			model.getSelected().setValue(
					model.getPuzzle().getTileFrom(used).getValue() + model.getSelected().getValue()
					);

		} else if (move == MoveType.UP) {
			model.getSelected().setValue(
					model.getPuzzle().getTileFrom(used).getValue() * model.getSelected().getValue()
					);

		} else if (move == MoveType.DOWN) {
			model.getSelected().setValue(
					model.getPuzzle().getTileFrom(used).getValue() / model.getSelected().getValue()
					);

		}

	}

	//helper function to more easily access a Tile's value from a given Coordinate
	public int getValFrom(Coordinate c) {
		return model.getPuzzle().getTileFrom(c).getValue();
	}

}
