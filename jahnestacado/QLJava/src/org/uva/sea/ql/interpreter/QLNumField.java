package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.Value;

@SuppressWarnings("rawtypes")
public class QLNumField extends JTextField implements ActionListener{
	private final String varName;
	private final Map<String, Value> declaredVar;
	private final Float value;
	
	
	public QLNumField(String varName,Map<String, Value> declaredVar){
		super(10);
		this.varName=varName;
		this.declaredVar=declaredVar;
		value=((DecimalLit) declaredVar.get(varName)).getValue();
	}
	
	public static JTextField responsiveNumField(String varName,Map<String, Value> declaredVar) {
		QLNumField numField = new QLNumField(varName, declaredVar);
		return numField.getTextField();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Float input=Float.parseFloat(this.getText());
		VariableEnvironment.refreshForm(varName, declaredVar, new DecimalLit(input));

	}
	
	private JTextField getTextField() {
		this.addActionListener(this);
		this.setText(value.toString());
		return this;
	}

}
