package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.visitor.evaluator.values.StrValue;
import org.uva.sea.ql.visitor.evaluator.values.Value;

public class QLTextField implements ActionListener, Observer{
	private final String varName;
	private final Map<String, Value> runTimeValues;
	private String value;
	private final JTextField txtField;
	private final static Color defaultColor= new Color(238,238,238);
	public final static String QL_TXT_FIELD_ID="QL_TXT_FIELD_ID";
	private final VariableUpdater varUpdater;



	
	public QLTextField(String varName,Map<String, Value> runTimeValues, VariableUpdater varUpdater){
		txtField=new JTextField(8);
		setSettings();
		this.varName=varName;
		this.runTimeValues=runTimeValues;
		value=((StrValue) runTimeValues.get(varName)).getValue();
		this.varUpdater=varUpdater;
		this.varUpdater.addObserver(this);
		
		
	}
	
	private void setSettings(){
		txtField.setName(QL_TXT_FIELD_ID);
		txtField.setName("QLNUMFIELD");
		txtField.setBackground(defaultColor);
	}
	
	public static JTextField responsiveTextField(String varName,Map<String, Value> runTimeValues,VariableUpdater varUpdater) {
		QLTextField txtField = new QLTextField(varName, runTimeValues,varUpdater);
		return txtField.getTextField();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String input=txtField.getText();
		if(!QLInputVerifier.isStringChar(input)) return;
		
		 varUpdater.updateValues(varName, runTimeValues, new StrValue(input));
		

	}
	
	private JTextField getTextField() {
		txtField.addActionListener(this);
		txtField.setText(value);
		return txtField;
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		value=((StrValue) varUpdater.getUpdatedValues().get(varName)).getValue();
		txtField.setText(value);		
	}
	
	
	

}
