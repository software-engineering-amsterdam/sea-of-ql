package org.uva.sea.ql.ui.qlform;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;

public class ComputedQuestionPanel {
	private final JLabel label;
	private final JTextField computedField;
	private final JPanel panel;
	public final static String COM_QUESTION_PANEL="COM_QUESTION_PANEL";

	public ComputedQuestionPanel(ComputedQuestion qlElement,Map<String,Value> runTimeValues,VariableUpdater varUpdater){
		panel=QLRowPanel.getQLRowPanel();
		label=QLLabel.getQLLabel(qlElement.getLabel().getValue(),COM_QUESTION_PANEL);
		computedField=QLComputedField.getQLComputedField(qlElement,varUpdater,runTimeValues);
		addComponents();
	}
	
	private void addComponents(){
		panel.setLayout(new MigLayout());
		panel.add(label,"align label");
		panel.add(computedField,"push, al right,wrap");
		
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	
	



}
