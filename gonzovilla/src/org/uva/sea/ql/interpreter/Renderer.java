package org.uva.sea.ql.interpreter;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
		JButton button = new JButton("Save Form");
		button.addActionListener(visitorRenderer.getState());
		panel.add(button);
		panel.validate();
		
		frame.setContentPane(panel);
		frame.setSize(380, 300);
		frame.setLocation(400, 200);
		frame.setVisible(true);
	}
	
}
