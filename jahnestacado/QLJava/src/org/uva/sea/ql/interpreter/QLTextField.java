package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.expr.values.Value;

@SuppressWarnings("rawtypes")
public class QLTextField extends JTextField implements ActionListener{
	private final String varName;
	private final Map<String, Value> declaredVar;
	private final String value;
	
	
	public QLTextField(String varName,Map<String, Value> declaredVar){
		super(10);
		this.varName=varName;
		this.declaredVar=declaredVar;
		value=((StringLit) declaredVar.get(varName)).getValue();
	}
	
	public static JTextField responsiveTextField(String varName,Map<String, Value> declaredVar) {
		QLTextField txtField = new QLTextField(varName, declaredVar);
		return txtField.getTextField();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input=this.getText();
		VariableEnvironment.refreshForm(varName, declaredVar, new StringLit(input));

	}
	
	private JTextField getTextField() {
		this.addActionListener(this);
		this.setText(value);
		return this;
	}

}
