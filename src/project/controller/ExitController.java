package project.controller;

import javax.swing.JOptionPane;

import project.boundary.NumberPuzzleApp;

public class ExitController {
	
	NumberPuzzleApp app;
	
	public ExitController(NumberPuzzleApp app) {
		this.app = app;
	}
	
	public void exit() {
		int choice = JOptionPane.showConfirmDialog(app, "Do you wish to exit?");
		if(choice == JOptionPane.OK_OPTION) {
			app.setVisible(false);
			app.dispose();
		}
	}

}
