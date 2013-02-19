package org.uva.sea.ql.ui.components;


import javax.swing.JComponent;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;


import org.uva.sea.ql.interpreter.Value;

public class QuestionComponent extends BaseComponent {

	private final ActiveComponent answerField;
	private final BaseComponent labelField;
	private final JPanel component;
	private final String args; 
	
	public QuestionComponent(String sentence, boolean computed, ActiveComponent answerField) { 
		
		this.answerField = answerField;
		this.labelField = new LabelComponent(sentence, "align right");
		
		this.component = new JPanel(new MigLayout());
		component.add(labelField.getComponent(), labelField.getArgs());
		component.add(answerField.getComponent(), answerField.getArgs());
		if(computed){ 
			answerField.setEnabled(false);
		}
		args = "growx, wrap";
	}

	public void updateValue(Value newValue) {
		answerField.updateValue(newValue);
	}

	@Override
	public JComponent getComponent() {
		return component;
	}

	@Override
	public String getArgs() {
		return args; 
	}

	@Override
	public void setVisible(boolean visible) {
		answerField.setVisible(visible);
		labelField.setVisible(visible);
	}
}
