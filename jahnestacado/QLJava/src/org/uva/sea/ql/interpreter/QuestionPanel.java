package org.uva.sea.ql.interpreter;

import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;

public class QuestionPanel {

	private final JLabel label;
	private final JComponent inputComponent;
	private final JPanel panel;
	
	
	public QuestionPanel(Question qlElement,Map<String,Value> declaredVar){
		panel=new JPanel(new MigLayout());
		label=new JLabel(qlElement.getLabel().getValue().toString().replaceAll("\"", ""));
		inputComponent=setInputComponent(qlElement.getId().getName(),qlElement.getType(),declaredVar);
		addComponents();
	}
	
	private void addComponents(){
		
		panel.add(label,"align label");
		panel.add(inputComponent,"wrap");
		
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	private JComponent setInputComponent(final String varName,Type type,final Map<String,Value> declaredVar){
	
		if (type.isCompatibleToStringType()) {
			return QLTextField.responsiveTextField(varName, declaredVar);
		} 
		else if (type.isCompatibleToBoolType()) {
			return QLCheckBox.responsiveCheckBox(varName, declaredVar);
		}
		if (type.isCompatibleToIntType()) {
			return QLSpinner.responsiveSpinner(varName, declaredVar);
		}
		if (type.isCompatibleToMoneyType()) {
			return QLNumField.responsiveNumField(varName, declaredVar);
		} 
		return null;
	}

	



}
