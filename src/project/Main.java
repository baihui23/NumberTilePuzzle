package project;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import project.boundary.NumberPuzzleApp;
import project.controller.ExitController;
import project.model.Model;
import project.model.Puzzle;
import project.model.Tile;

public class Main {
	
	public static void main (String[] args) {
		
		Model model = new Model();
		
		NumberPuzzleApp app = new NumberPuzzleApp(model);
		
		app.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent we) {
				new ExitController(app).exit();
			}
		});
		
		app.setVisible(true);
		
	}

}
