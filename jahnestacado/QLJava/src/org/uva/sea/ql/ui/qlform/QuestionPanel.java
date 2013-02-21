package org.uva.sea.ql.ui.qlform;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;
import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.visitor.evaluator.values.Value;

public class QuestionPanel {

	private final JLabel label;
	private final JComponent inputComponent;
	private final JPanel panel;
	private boolean needsVerifier;
	private final Type type;
	public final static String QL_QUESTION_LABEL_ID="QL_QUESTION_LABEL_ID";
	private  VariableUpdater varUpdater;

	
	
	public QuestionPanel(Question qlElement,Map<String,Value> runTimeValues, VariableUpdater varUpdater){
		this.varUpdater=varUpdater;
		type=qlElement.getType();
		panel=QLRowPanel.getQLRowPanel();
		label=QLLabel.getQLLabel(qlElement.getLabel().getValue(),QL_QUESTION_LABEL_ID);
		inputComponent=setInputComponent(qlElement.getId().getName(),type,runTimeValues);
		addComponents();
	}
	
	
	
	public JPanel getPanel(){
		return panel;
	}
	
	private JComponent setInputComponent(final String varName,Type type,final Map<String,Value> runTimeValues){
	
		if (type.isCompatibleToStringType()) {
			needsVerifier=true;
			return QLTextField.responsiveTextField(varName, runTimeValues,varUpdater);
		} 
		else if (type.isCompatibleToBoolType()) {
			return QLCheckBox.responsiveCheckBox(varName, runTimeValues,varUpdater);
		}
		if (type.isCompatibleToIntType()) {
			return QLSpinner.responsiveSpinner(varName, runTimeValues,varUpdater);
		}
		if (type.isCompatibleToMoneyType()) {
			needsVerifier=true;
			return QLNumField.responsiveNumField(varName, runTimeValues,varUpdater);
		} 
		return null;
	}


	
	private void addComponents() {
		if (needsVerifier) {
			panel.add(label, "align label");
			panel.add(inputComponent,"push, al right");
			panel.add(QLInputVerifier.getVerifier(inputComponent, type), "wrap");
		} else {
			panel.add(label, "align label");
			panel.add(inputComponent,"push, al right,wrap");
		}
	}

}
