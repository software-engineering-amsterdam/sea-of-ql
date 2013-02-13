package org.uva.sea.ql.swing;

import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.interpreter.QLGenButton;

public class Renderer {
	private final List<JPanel> questionPanelList;
	private final JPanel content;
	private final JFrame frame;
	private final static String containerPanelId="QL_CONTAINER_PANEL";
	private final static String contentPanelId="QL_CONTENT_PANEL";

	

	public Renderer(List<JPanel> questionPanelList, JFrame frame) {
		this.frame = frame;
		frame.setResizable(false);
		this.questionPanelList = questionPanelList;
		content = new JPanel(new MigLayout());
		content.setName(contentPanelId);

	}

	
	
	
	public void addQuestionsToPanel() {
		for (JPanel question : questionPanelList) {
			content.add(question, "align label,wrap");
		}
        content.add(QLGenButton.responsiveButton(questionPanelList,frame),"align center");
		JPanel containerPanel = new JPanel();
		containerPanel.setName(containerPanelId);
		containerPanel.add(content);
		frame.add(containerPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void refresh() {   
		cleanOldPanels();
		addQuestionsToPanel();

	}

	/*
	 * Cleans frame from sub-panels in order to display properly the new one
	 */
	private void cleanOldPanels() {
		Component[] components = frame.getContentPane().getComponents();
		for (int i = 0; i < components.length; i++) {
			if (components[i] instanceof JPanel) {
				frame.remove(components[i]);
			}
		}

	}

}
