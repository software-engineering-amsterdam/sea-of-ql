package org.uva.sea.ql.interpreter;

import java.awt.Color;
import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.ComputedQuestion;

public class ComputedQuestionPanel extends JPanel {
	private final JLabel label;
	private final ComputedQuestion qlElement;
	private final JTextField computedValue;
	private static final long serialVersionUID = 1L;

	public ComputedQuestionPanel(ComputedQuestion qlElement,Map<String,Value> declaredVar){
	    this.qlElement=qlElement;
		label=new JLabel(qlElement.getLabel().getValue().replaceAll("\"", ""));
		computedValue=new JTextField(8);
		computedValue.setForeground(Color.blue);
		computedValue.setBackground(Color.white);
		computedValue.setHorizontalAlignment(JTextField.CENTER);
		computedValue.setText(ExprEvaluator.eval(qlElement.getExpr(), declaredVar).getValue().toString());
		computedValue.setEditable(false);
		addComponents();
	}
	
	private void addComponents(){
		this.setLayout(new MigLayout());
		this.add(label,"align label");
		this.add(computedValue,"wrap");
		
	}
	
	public JPanel getPanel(){
		return this;
	}
	
	
	



}
