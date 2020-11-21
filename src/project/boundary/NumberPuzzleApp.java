package project.boundary;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import project.controller.MovePieceController;
import project.controller.ResetController;
import project.controller.SelectPieceController;
import project.model.Model;
import project.model.MoveType;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;

public class NumberPuzzleApp extends JFrame {

	private JPanel contentPane;
	PuzzlePanel panel;
	Model model;

	JButton upBtn, downBtn, leftBtn, rightBtn, resetBtn;

	JLabel numMovesLabel; 

	public JButton getUpButton() { return upBtn; }
	public JButton getDownButton() { return downBtn; }
	public JButton getLeftButton() { return leftBtn; }
	public JButton getRightButton() { return rightBtn; }

	public JLabel getNumMovesLabel() { return numMovesLabel; }

	public PuzzlePanel getPuzzlePanel() { return panel; }

	public NumberPuzzleApp(Model m) {
		this.model = m;

		setTitle("Number Puzzle App");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 551, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		panel = new PuzzlePanel(model);
		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me) {
				new SelectPieceController(model, NumberPuzzleApp.this).processPoint(me.getPoint());
			}
		});

		JLabel movesLabel = new JLabel("Number of Moves:");
		numMovesLabel = new JLabel("" + model.getNumMoves());

		resetBtn = new JButton("Reset");
		resetBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				new ResetController(model, NumberPuzzleApp.this).reset();
			}
		});		

		upBtn = new JButton("^");
		upBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				new MovePieceController(model, NumberPuzzleApp.this).move(MoveType.UP);
			}
		});

		downBtn = new JButton("v");
		downBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				new MovePieceController(model, NumberPuzzleApp.this).move(MoveType.DOWN);
			}
		});

		leftBtn = new JButton("<");
		leftBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				new MovePieceController(model, NumberPuzzleApp.this).move(MoveType.LEFT);
			}
		});

		rightBtn = new JButton(">");
		rightBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent a) {
				new MovePieceController(model, NumberPuzzleApp.this).move(MoveType.RIGHT);
			}
		});



		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
				gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(resetBtn)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(movesLabel)
												.addGroup(gl_contentPane.createSequentialGroup()
														.addComponent(leftBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
														.addPreferredGap(ComponentPlacement.RELATED)
														.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
																.addComponent(downBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(upBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(numMovesLabel, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE)
												.addComponent(rightBtn))
										.addGap(34)))
						.addContainerGap(227, Short.MAX_VALUE))
				);
		gl_contentPane.setVerticalGroup(
				gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(resetBtn)
										.addGap(36)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
												.addComponent(movesLabel)
												.addComponent(numMovesLabel))
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(upBtn, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
												.addComponent(rightBtn, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
														.addComponent(downBtn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
														.addComponent(leftBtn, GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))))
								.addComponent(panel, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
						.addContainerGap())
				);
		contentPane.setLayout(gl_contentPane);
		UpdateButtons.enableButtons(this, new ArrayList<MoveType>());;
	}
}
