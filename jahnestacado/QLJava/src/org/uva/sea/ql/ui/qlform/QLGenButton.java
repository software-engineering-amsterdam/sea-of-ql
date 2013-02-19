package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.ui.qlform.output.OutputData;
import org.uva.sea.ql.ui.qlform.output.QLOutputSelectorFrame;
import org.uva.sea.ql.ui.qlform.output.QLOutputState;


public class QLGenButton implements ActionListener {

	private final JButton button = new JButton("Submit");
	private final List<JPanel> questionPanelList;
	private final JFrame frame;
	private final VariableUpdater varUpdater;
	public static final String genButtonId = "GEN_BUTTON";
	

	private QLGenButton(List<JPanel> questionPanelList,JFrame frame,VariableUpdater varUpdater) {
		this.questionPanelList = questionPanelList;
		this.varUpdater=varUpdater;
		this.frame=frame;
		setSettings();
	}
	
	private void setSettings(){
		button.addActionListener(this);
		button.setName(genButtonId);
		button.setBackground(Color.DARK_GRAY);
		button.setForeground(Color.white);
		
	}

	public static JButton responsiveButton(List<JPanel> questionPanelList,JFrame frame,VariableUpdater varUpdater) {
		QLGenButton genButton = new QLGenButton(questionPanelList,frame,varUpdater);
		return genButton.getButton();
	}

	private JButton getButton() {
		return button;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		QLOutputState outputState=new OutputData(questionPanelList,frame,varUpdater).getOutputData();
		if(!outputState.hasError()){
			showSelectorDialog(outputState);
		}
	
	}

	
	private void showSelectorDialog(QLOutputState outputState){
		String formName=frame.getTitle();
		QLOutputSelectorFrame.showFormatSelector(formName,outputState);
		
	}

}
