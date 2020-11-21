package test.controller;

import org.junit.jupiter.api.Test;

import project.boundary.NumberPuzzleApp;
import project.controller.ResetController;
import project.model.Model;

class TestResetController {
	
	Model model = new Model();
	NumberPuzzleApp app = new NumberPuzzleApp(model);
	ResetController rc = new ResetController(model, app);

	@Test
	void test() {
		rc.reset();
	}

}
