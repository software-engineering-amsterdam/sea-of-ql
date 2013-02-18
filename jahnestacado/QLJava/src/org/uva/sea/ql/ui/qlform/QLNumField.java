package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;


public class QLNumField  implements ActionListener, Observer{
	private final String varName;
	private final Map<String, Value> declaredVar;
	private  Float value;
	private final JTextField txtField;
	private final static Color defaultColor= new Color(238,238,238);
	public final static String NUM_FIELD_ID="QLNUMFIELD";
	private final VariableUpdater varUpdater;
	
	
	public QLNumField(String varName,Map<String, Value> runTimeValues, VariableUpdater varUpdater){
		txtField=new JTextField(8);
		this.varName=varName;
		this.declaredVar=runTimeValues;
		value=((DecimalLit) runTimeValues.get(varName)).getValue();
		
		this.varUpdater=varUpdater;
		this.varUpdater.addObserver(this);
		setSettings();
	}
	
	private void setSettings(){
		txtField.setName(NUM_FIELD_ID);
		txtField.setBackground(defaultColor);
	}
	
	public static JTextField responsiveNumField(String varName,Map<String, Value> runTimeValues, VariableUpdater varUpdater) {
		QLNumField numField = new QLNumField(varName, runTimeValues,varUpdater);
		return numField.getTextField();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String txt=txtField.getText();
		if(!QLInputVerifier.isNumChar(txt)) return;
		
		Float input=Float.parseFloat(txtField.getText());
		varUpdater.updateValues(varName, declaredVar, new DecimalLit(input));

		

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

	@Override
	public void update(Observable arg0, Object arg1) {
		value=((DecimalLit) varUpdater.getUpdatedValues().get(varName)).getValue();
		String roundedDisplayedValue=String.valueOf(roundTo2Decimals(value));
		txtField.setText(roundedDisplayedValue);
	
        
	}

}
