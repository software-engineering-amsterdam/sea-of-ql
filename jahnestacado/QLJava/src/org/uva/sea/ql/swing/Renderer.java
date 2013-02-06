package org.uva.sea.ql.swing;

import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Renderer {
	private static List<JPanel> questionList;
	private JPanel content;
	private JFrame frame;

	public Renderer(List<JPanel> questionList, JFrame frame) {
		this.frame = frame;
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		this.questionList = questionList;
		content = new JPanel(new MigLayout());

	}

	public void addQuestionsToPanel() {
		for (JPanel question : questionList) {
			content.add(question, "align label,wrap");
		}

		JPanel containerPanel = new JPanel();
		containerPanel.add(content);
		frame.add(containerPanel);
		frame.pack();
		frame.setVisible(true);
	}

	public void refresh() {
		cleanOldPanels();
		addQuestionsToPanel();

	}

	private void cleanOldPanels() {
		Component[] components = frame.getContentPane().getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JPanel) {
				frame.remove(components[i]);
			}
		}

	}

}
