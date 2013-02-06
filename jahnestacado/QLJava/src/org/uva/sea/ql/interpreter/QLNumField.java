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
		VariableUpdater varUpdater=new VariableUpdater(varName, declaredVar, new DecimalLit(input));
		List<JPanel> questionList=new ArrayList<JPanel>();
		JFrame frame = (JFrame) SwingUtilities.getRoot(this);
		new SwingVisitor(questionList,varUpdater.getUpdatedValues()).regenerate(frame);

	}
	
	private JTextField getTextField() {
		this.addActionListener(this);
		this.setText(value.toString());
		return this;
	}

}
