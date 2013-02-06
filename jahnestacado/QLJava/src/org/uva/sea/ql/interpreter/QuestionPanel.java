package org.uva.sea.ql.interpreter;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;

public class QuestionPanel {

	private final JLabel label;
	private final JComponent inputComponent;
	private final JPanel panel;
	private boolean needsVerifier;
	private final Type type;
	
	
	public QuestionPanel(Question qlElement,Map<String,Value> declaredVar){
		this.type=qlElement.getType();
		this.panel=new JPanel(new MigLayout());
		this.label=new JLabel(qlElement.getLabel().getValue().toString().replaceAll("\"", ""));
		this.inputComponent=setInputComponent(qlElement.getId().getName(),type,declaredVar);
		addComponents();
	}
	
	
	
	public JPanel getPanel(){
		return panel;
	}
	
	private JComponent setInputComponent(final String varName,Type type,final Map<String,Value> declaredVar){
	
		if (type.isCompatibleToStringType()) {
			needsVerifier=true;
			return QLTextField.responsiveTextField(varName, declaredVar);
		} 
		else if (type.isCompatibleToBoolType()) {
			return QLCheckBox.responsiveCheckBox(varName, declaredVar);
		}
		if (type.isCompatibleToIntType()) {
			return QLSpinner.responsiveSpinner(varName, declaredVar);
		}
		if (type.isCompatibleToMoneyType()) {
			needsVerifier=true;
			return QLNumField.responsiveNumField(varName, declaredVar);
		} 
		return null;
	}

	


	
	private void addComponents() {
		if (needsVerifier) {
			panel.add(label, "align label");
			panel.add(inputComponent);
			panel.add(QLInputVerifier.getVerifier(inputComponent, type), "wrap");
		} else {
			panel.add(label, "align label");
			panel.add(inputComponent, "wrap");
		}
	}

}
