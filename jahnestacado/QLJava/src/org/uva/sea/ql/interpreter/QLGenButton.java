package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class QLGenButton implements ActionListener {

	private final JButton button = new JButton("Submit");
	private final List<JPanel> questionPanelList;
	private final JFrame frame;
	private static final String genButtonId="GEN_BUTTON";
	

	private QLGenButton(List<JPanel> questionPanelList,JFrame frame) {
		this.questionPanelList = questionPanelList;
		this.frame=frame;
		button.addActionListener(this);
		button.setName(genButtonId);
	}

	public static JButton responsiveButton(List<JPanel> questionPanelList,JFrame frame) {
		QLGenButton genButton = new QLGenButton(questionPanelList,frame);
		return genButton.getButton();
	}

	private JButton getButton() {
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		QLOutputState outputState=new OutputData(questionPanelList,frame).getOutputData();
		if(!outputState.hasError()){
			showSelectorDialog(outputState);
		}
	
	}

	
	private void showSelectorDialog(QLOutputState outputState){
		String formName=frame.getTitle();
		QLOutputSelectorFrame.showFormatSelector(formName,outputState);
		
	}

}
