package org.uva.sea.ql.swing;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.ScrollPane;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.interpreter.QLGenButton;

public class Renderer {
	private final List<JPanel> questionPanelList;
	private final JPanel content;
	private final JFrame frame;
	private static final String genButtonId="GEN_BUTTON";
	private final static String containerPanelId="QL_CONTAINER_PANEL";
	private final static String contentPanelId="QL_CONTENT_PANEL";
	private final static Component centerOfScreen=null;
	private final static ScrollPane containerPanel = new ScrollPane();
	
	static{
	      containerPanel.setSize(new Dimension(650,400));
	      containerPanel.setName(containerPanelId);

	}

	

	public Renderer(List<JPanel> questionPanelList, JFrame frame) {
		this.frame = frame;
		this.questionPanelList = questionPanelList;
		content = new JPanel(new MigLayout());
		content.setName(contentPanelId);

	}

	
	
	
	public void addQuestionsToPanel() {
		for (JPanel question : questionPanelList) {
			content.add(question, "align label,wrap");
		}     
        containerPanel.add(content);
      
        
		frame.add(containerPanel,"align center,wrap");
		frame.add(QLGenButton.responsiveButton(questionPanelList,frame),"align center");
		frame.setLocationRelativeTo(centerOfScreen);
		frame.setVisible(true);
	}

	public void refresh() {   
		 removeOldPanels();
		 addQuestionsToPanel();
	}

	
	/*
	 * Cleans frame from sub-components in order to display properly the new added one
	 */
	private void removeOldPanels() {
		Component[] components = frame.getContentPane().getComponents();
		try{
		for (int i = 0; i < components.length; i++) {
			if (components[i].getName().equals(containerPanelId) || components[i].getName().equals(genButtonId)) {
				frame.remove(components[i]);
			}
		}
		}
		catch(NullPointerException e){
			e.getStackTrace();
			System.out.println("sdsd");
		}

	}

}
