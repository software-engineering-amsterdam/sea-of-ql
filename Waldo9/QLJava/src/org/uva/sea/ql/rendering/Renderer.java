package org.uva.sea.ql.rendering;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.statements.Statement;

public class Renderer {
	
	private static final String WINDOW_TITLE = "QL demo";

	public void render(Statement statement) {
		JFrame frame = new JFrame(WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		State state = new State();
		RenderingVisitor renderingVisitor = new RenderingVisitor(state);
		statement.accept(renderingVisitor);
		JPanel panel = new JPanel();
		panel.add(renderingVisitor.getPanel());
		JButton button = new JButton("Save");
		button.addActionListener(renderingVisitor.getState());
		panel.add(button);
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
