package org.uva.sea.ql.interpreter;

import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ast.form.ComputedQuestion;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.types.Type;

public class ComputedQuestionPanel extends JPanel {
	private final JLabel label;
	private final ComputedQuestion qlElement;
	private final JTextField computedValue;
	private static final long serialVersionUID = 1L;

	public ComputedQuestionPanel(ComputedQuestion qlElement,Map<String,Value> declaredVar){
	    this.qlElement=qlElement;
		label=new JLabel(qlElement.getLabel().getValue());
		computedValue=new JTextField(10);
		computedValue.setText(ExprEvaluator.eval(qlElement.getExpr(), declaredVar).getValue().toString());
		computedValue.setEditable(false);
		addComponents();
	}
	
	private void addComponents(){
		this.setLayout(new MigLayout("","[right][]","[]"));
		this.add(label,"align right");
		this.add(computedValue,"wrap");
		
	}
	
	public JPanel getPanel(){
		return this;
	}
	
	
	



}
