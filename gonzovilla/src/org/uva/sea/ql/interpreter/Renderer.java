package org.uva.sea.ql.interpreter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import org.uva.sea.ql.ast.stat.FormUnit;

public class Renderer {
	
	public void render(FormUnit formUnit) {
		
		JFrame frame = new JFrame("QL Program");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		State state = new State();
		VisitorRenderer visitorRenderer = new VisitorRenderer(state);
		formUnit.accept(visitorRenderer);
		
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		panel.add(visitorRenderer.getPanel());
		panel.validate();
		
		frame.setContentPane(panel);
		frame.setSize(500, 500);
		frame.setLocation(200, 200);
		frame.pack();
		frame.setVisible(true);
	}
	
}
