package org.uva.sea.ql.swing;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class Renderer {
	private final  List<JPanel> questionList;
	private static JPanel content;
	private static JFrame frame;
	private static String qlName;

	public Renderer(List<JPanel> questionList) {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(700, 600));
		frame.setTitle("QL-" + qlName);
		this.questionList = questionList;
		content = new JPanel();
		addQuestionsToPanel();
		frame.setVisible(true);

	}
	
	

	private void addQuestionsToPanel() {
		content.setLayout(new MigLayout());

		for (JPanel question : questionList) {
			content.add(question, "align label,wrap");
		}

		JPanel containerPanel = new JPanel();
		containerPanel.add(content);
		frame.add(containerPanel);
	}

	
	public static void refresh(List<JPanel> questionList) {
		System.out.println("refresh");
		content.removeAll();

		for (JPanel question : questionList) {
			content.add(question, "wrap");
		}

		JPanel containerPanel = new JPanel();
		containerPanel.add(content);
		frame.add(containerPanel);
		frame.setVisible(true);
		frame.validate();
	}

	

	public static void setName(String name) {
		qlName = name;
	}

}
