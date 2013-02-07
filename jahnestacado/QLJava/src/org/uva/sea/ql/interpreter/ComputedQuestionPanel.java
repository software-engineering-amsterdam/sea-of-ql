package org.uva.sea.ql.interpreter;

import java.awt.Color;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.BoolLit;
import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.StringLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.ComputedQuestion;

public class ComputedQuestionPanel {
	private final JLabel label;
	private final JTextField computedValue;
	private final JPanel panel;

	public ComputedQuestionPanel(ComputedQuestion qlElement,Map<String,Value> declaredVar){
		panel=new JPanel(new MigLayout());
		label=new JLabel(qlElement.getLabel().getValue().replaceAll("\"", ""));
		
		computedValue=new JTextField(8);
		computedValue.setForeground(Color.blue);
		computedValue.setBackground(Color.white);
		computedValue.setHorizontalAlignment(JTextField.CENTER);
		computedValue.setText(valueToString(qlElement, declaredVar));
		computedValue.setEditable(false);
		addComponents();
	}
	
	private void addComponents(){
		panel.setLayout(new MigLayout());
		panel.add(label,"align label");
		panel.add(computedValue,"wrap");
		
	}
	
	public JPanel getPanel(){
		return panel;
	}
	
	
	private String valueToString(ComputedQuestion qlElement, Map<String,Value> declaredVar){
		if(qlElement.getType().isCompatibleToIntType()){
			return String.valueOf(((IntegerLit) ExprEvaluator.eval(qlElement.getExpr(), declaredVar)).getValue());
		}
		else if(qlElement.getType().isCompatibleToMoneyType()){
			return String.valueOf(((DecimalLit) ExprEvaluator.eval(qlElement.getExpr(), declaredVar)).getValue());
		}
		else if(qlElement.getType().isCompatibleToBoolType()){
			return String.valueOf(((BoolLit) ExprEvaluator.eval(qlElement.getExpr(), declaredVar)).getValue());
		}
		return (((StringLit) ExprEvaluator.eval(qlElement.getExpr(), declaredVar)).getValue());
		
	}
	
	



}
