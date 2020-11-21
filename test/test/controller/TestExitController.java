package test.controller;

import org.junit.jupiter.api.Test;

import project.boundary.NumberPuzzleApp;
import project.controller.ExitController;
import project.model.Model;

class TestExitController {
	
	Model model = new Model();
	NumberPuzzleApp app = new NumberPuzzleApp(model);
	ExitController ec = new ExitController(app);

	@Test
	void test() {
		app.setVisible(true);
		ec.exit();
	}
	
}
