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

public class QuestionPanel extends JPanel{

	private final JLabel label;
	private final Question qlElement;
	private final JComponent inputComponent;
	
	
	public QuestionPanel(Question qlElement,Map<String,Value> declaredVar){
	    this.qlElement=qlElement;
		
		label=new JLabel(qlElement.getLabel().getValue().toString().replaceAll("\"", ""));
		inputComponent=setInputComponent(qlElement.getId().getName(),qlElement.getType(),declaredVar);
		addComponents();
	}
	
	private void addComponents(){
		this.setLayout(new MigLayout());
		this.add(label,"align label");
		this.add(inputComponent,"wrap");
		
	}
	
	public JPanel getPanel(){
		return this;
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
