package org.uva.sea.ql.swing;

import java.awt.Dimension;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import net.miginfocom.swing.MigLayout;

public class Renderer {
	private static  List<JPanel> questionList;
	private  JPanel content;
	private  JFrame frame;
	private static String qlName;

	public Renderer(List<JPanel> questionList,JFrame frame) {
		this.frame=frame;
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

	
	public  void refresh() {
		content.removeAll();
		content.updateUI();

		for (JPanel question : questionList) {
			content.add(question, "wrap");
		}

		JPanel containerPanel = new JPanel();
		containerPanel.add(content);
		frame.add(containerPanel);
		frame.pack();
		frame.invalidate();
	}

	
	

}
