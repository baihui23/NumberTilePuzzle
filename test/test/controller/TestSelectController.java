package test.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Point;

import org.junit.jupiter.api.Test;

import project.boundary.NumberPuzzleApp;
import project.controller.SelectPieceController;
import project.model.Model;

class TestSelectController {
	
	Model model = new Model();
	NumberPuzzleApp app = new NumberPuzzleApp(model);
	SelectPieceController spc = new SelectPieceController(model, app);

	@Test
	void test() {
		Point p = new Point(10, 10);
		spc.processPoint(p);
	}

}
