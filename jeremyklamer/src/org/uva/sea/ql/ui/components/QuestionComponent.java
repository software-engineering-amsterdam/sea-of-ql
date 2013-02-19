package org.uva.sea.ql.ui.components;


import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.interpreter.Value;

public class QuestionComponent extends BaseComponent {

	private final ActiveComponent answerField;
	private final BaseComponent labelField;
	private final JPanel panel;
	private final String args; 
	
	public QuestionComponent(String sentence, boolean computed, ActiveComponent answerField) { 
		this.answerField = answerField;
		this.labelField = new LabelComponent(sentence, "align right");
		
		this.panel = new JPanel(new MigLayout());
		panel.add(labelField.getComponent(), labelField.getArgs());
		panel.add(answerField.getComponent(), answerField.getArgs());
		if(computed){ 
			answerField.setEnabled(false);
		}
		args = "growx, wrap";
	}

	public void updateValue(Value newValue) {
		answerField.updateValue(newValue);
	}
	
	public ActiveComponent getAnswerField() {
		return answerField;
	}
	
	public Value getValue() {
		return answerField.getValue();
	}

	@Override
	public JComponent getComponent() {
		return panel;
	}

	@Override
	public String getArgs() {
		return args; 
	}

	@Override
	public void setVisible(boolean visible) {
		panel.setVisible(visible);
	}

}
