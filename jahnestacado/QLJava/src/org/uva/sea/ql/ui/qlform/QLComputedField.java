package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import org.uva.sea.ql.ast.expr.Expr;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.visitor.evaluator.ExprEvaluator;
import org.uva.sea.ql.visitor.evaluator.values.Value;

public class QLComputedField implements Observer {
	private final JTextField txtField;
	public final static String QL_COMPUTED_FIELD_ID = "QL_COMPUTED_FIELD_ID";
	private final VariableUpdater varUpdater;
    private final Expr expr;
	

	private QLComputedField(ComputedQuestion qlElement,VariableUpdater varUpdater,Map<String,Value> runTimeValues) {
		txtField = new JTextField(8);
		this.varUpdater=varUpdater;
		this.varUpdater.addObserver(this);
		this.expr=qlElement.getExpr();
		txtField.setText(valueToString(runTimeValues));
		setSettings();
	}

	public static JTextField getQLComputedField(ComputedQuestion qlElement,VariableUpdater varUpdater,Map<String,Value> runTimeValues) {
		QLComputedField qlComputedField = new QLComputedField(qlElement,varUpdater,runTimeValues);
		return qlComputedField.getComputedField();
	}

	private JTextField getComputedField() {
		return txtField;
	}

	private void setSettings() {
		txtField.setForeground(Color.orange);
		txtField.setBackground(Color.gray);
		txtField.setBorder(BorderFactory.createLineBorder(Color.white));
		txtField.setHorizontalAlignment(JTextField.CENTER);
		txtField.setEditable(false);
		txtField.setName(QL_COMPUTED_FIELD_ID);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
       String value= valueToString(varUpdater.getUpdatedValues());
       txtField.setText(value);
	}
	
	
	private String valueToString(Map<String,Value> runTimeValues){
	   return ExprEvaluator.eval(expr, runTimeValues).getValue().toString();
	}
	
		
	

}

