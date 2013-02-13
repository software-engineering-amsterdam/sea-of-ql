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


public class QLNumField  implements ActionListener{
	private final String varName;
	private final Map<String, Value> declaredVar;
	private final Float value;
	private final JTextField txtField;
	
	
	public QLNumField(String varName,Map<String, Value> declaredVar){
		txtField=new JTextField(8);
		txtField.setName("QLNUMFIELD");
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
		
		String txt=txtField.getText();
		if(!QLInputVerifier.isNumChar(txt)) return;
		
		Float input=Float.parseFloat(txtField.getText());
		VariableUpdater varUpdater=new VariableUpdater(varName, declaredVar, new DecimalLit(input));
		List<JPanel> questionList=new ArrayList<JPanel>();
		
		JFrame frame = (JFrame) SwingUtilities.getRoot(txtField);
		new SwingVisitor(questionList,varUpdater.getUpdatedValues()).regenerate(frame);

	}
	
	private JTextField getTextField() {
		txtField.addActionListener(this);
		txtField.setText(value.toString());
		return txtField;
	}

}
