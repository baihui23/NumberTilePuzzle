package project.boundary;

import java.util.ArrayList;

import project.model.MoveType;

public class UpdateButtons {

	public static void enableButtons(NumberPuzzleApp app, ArrayList<MoveType> moves) {
		app.getUpButton().setEnabled(false);
		app.getDownButton().setEnabled(false);
		app.getLeftButton().setEnabled(false);
		app.getRightButton().setEnabled(false);

		for (MoveType mt : moves) {
			if (mt == MoveType.UP) {
				app.getUpButton().setEnabled(true);
			} else if (mt == MoveType.DOWN) {
				app.getDownButton().setEnabled(true);
			} else if (mt == MoveType.LEFT) {
				app.getLeftButton().setEnabled(true);
			} else if (mt == MoveType.RIGHT) {
				app.getRightButton().setEnabled(true);
			}
		}
	}
	
	
}