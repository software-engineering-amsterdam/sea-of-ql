package org.uva.sea.ql.ui.components;

import java.awt.Component;

import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


import org.uva.sea.ql.interpreter.Value;

public class QuestionComponent extends BaseComponent {

	private final ActiveComponent answerField;
	private final BaseComponent labelField;
	private final JPanel component;
	private final String args; 
	
	public QuestionComponent(String sentence, boolean computed, ActiveComponent answerField) { 
		//super("growx, wrap");
		
		this.answerField = answerField;
		this.labelField = new LabelComponent(sentence, "align right");
		
		this.component = new JPanel(new MigLayout());
		component.add(labelField.getComponent(), labelField.getArgs());
		component.add(answerField.getComponent(), answerField.getArgs());
		
		if(computed){
			//TODO remove double dots. 
			answerField.getComponent().setEnabled(false);
		}
		args = "growx, wrap";
	}

	public void updateValue(Value newValue) {
		answerField.updateValue(newValue);
	}

	@Override
	public Component getComponent() {
		return component;
	}
	
	public void setVisibile(boolean visible) {
		//TODO pull down to answerfield (two dots! )
		answerField.getComponent().setVisible(visible);
		labelField.getComponent().setVisible(visible);
	}

	@Override
	public String getArgs() {
		return args; 
	}
}
