package org.uva.sea.ql.swing;

import java.awt.Component;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.interpreter.QLContentPanel;
import org.uva.sea.ql.interpreter.QLGenButton;
import org.uva.sea.ql.interpreter.QLScrollBar;

public class Renderer  {
	public final static Component centerOfScreen=null;
	private final List<JPanel> questionPanelList;
	private final JPanel contentPanel;
	private final JFrame frame;
	private final static QLScrollBar scrollBar = new QLScrollBar();
	

	public Renderer(List<JPanel> questionPanelList, JFrame frame) {
		this.frame = frame;
		this.questionPanelList = questionPanelList;
		contentPanel = QLContentPanel.getContentPanel();
	}
	
	
	public void addQuestionsToPanel() {
		for (JPanel question : questionPanelList) {
			contentPanel.add(question, "align label,wrap");
		}
		scrollBar.add(contentPanel);
		frame.add(scrollBar, "align center,wrap");
		frame.add(QLGenButton.responsiveButton(questionPanelList, frame),"align center");
		frame.setLocationRelativeTo(centerOfScreen);
		frame.setVisible(true);
	}

	public void refresh() {
		int verticalPosition = scrollBar.getVerticalPosition();
		removeOldPanels();
		addQuestionsToPanel();
		scrollBar.maintainPosition(verticalPosition);
	}

	
	/*
	 * Cleans frame from sub-components, in this case it removes the root component scrollBar which contains everything,
	 *  in order to display properly the updated frame properly
	 */
	private void removeOldPanels() {
		Component[] components = frame.getContentPane().getComponents();
		try{
		for (int i = 0; i < components.length; i++) {
			if (components[i].getName().equals(QLScrollBar.containerScrollPanelId) || components[i].getName().equals(QLGenButton.genButtonId)) {
				frame.remove(components[i]);
			}
		}
		}
		catch(NullPointerException e){
			e.getStackTrace();
			System.out.println("sdsd"); ///////////////////////
		}

	}





}
