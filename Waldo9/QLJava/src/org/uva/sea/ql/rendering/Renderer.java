package org.uva.sea.ql.rendering;

import javax.swing.JFrame;

import org.uva.sea.ql.ast.statements.Statement;

public class Renderer {
	
	private static final String WINDOW_TITLE = "QL demo";

	public void render(Statement statement) {
		JFrame frame = new JFrame(WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		State state = new State();
		RenderingVisitor renderingVisitor = new RenderingVisitor(state);
		statement.accept(renderingVisitor);
		frame.setContentPane(renderingVisitor.getPanel());
		frame.pack();
		frame.setVisible(true);
	}

}
