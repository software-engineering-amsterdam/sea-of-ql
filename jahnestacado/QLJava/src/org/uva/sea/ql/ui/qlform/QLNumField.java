package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
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
import org.uva.sea.ql.ui.qlform.interpreter.SwingGenerator;
import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;


public class QLNumField  implements ActionListener{
	private final String varName;
	private final Map<String, Value> declaredVar;
	private final Float value;
	private final JTextField txtField;
	private final static Color defaultColor= new Color(238,238,238);
	public final static String NUM_FIELD_ID="QLNUMFIELD";
	
	
	public QLNumField(String varName,Map<String, Value> runTimeValues){
		txtField=new JTextField(8);
		this.varName=varName;
		this.declaredVar=runTimeValues;
		value=((DecimalLit) runTimeValues.get(varName)).getValue();
		setSettings();
	}
	
	private void setSettings(){
		txtField.setName(NUM_FIELD_ID);
		txtField.setBackground(defaultColor);
	}
	
	public static JTextField responsiveNumField(String varName,Map<String, Value> runTimeValues) {
		QLNumField numField = new QLNumField(varName, runTimeValues);
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
		new SwingGenerator(questionList,varUpdater.getUpdatedValues()).regenerate(frame);

	}
	
	private JTextField getTextField() {
		txtField.addActionListener(this);
		String roundedDisplayedValue=String.valueOf(roundTo2Decimals(value));
		txtField.setText(roundedDisplayedValue);
		return txtField;
	}
	
	public static float roundTo2Decimals(float num){
		return Math.round(num*100.0)/100.0f;
	}

}
