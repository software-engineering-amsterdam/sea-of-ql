package org.uva.sea.ql.interpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.uva.sea.ql.ast.expr.values.DecimalLit;
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
		VariableUpdater varUpdater=new VariableUpdater(varName, declaredVar, new StringLit(input));
		List<JPanel> questionList=new ArrayList<JPanel>();
		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		new SwingVisitor(questionList,varUpdater.getUpdatedValues()).regenerate(frame);

	}
	
	private JTextField getTextField() {
		this.addActionListener(this);
		this.setText(value);
		return this;
	}

}
