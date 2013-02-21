package org.uva.sea.ql.ui.qlform;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.visitor.evaluator.values.BoolValue;
import org.uva.sea.ql.visitor.evaluator.values.Value;

public class QLCheckBox implements ActionListener,Observer {

	private final String varName;
	private  Map<String, Value> runTimeValues;
	private final JCheckBox chBox;
	public final static String QL_CHECKBOX_ID = "QL_CHECKBOX_ID";
	private final VariableUpdater varUpdater;
	


	public QLCheckBox(String varName, Map<String, Value> runTimeValues,VariableUpdater varUpdater) {
		chBox = new JCheckBox("No");
		chBox.setName(QL_CHECKBOX_ID);
		this.varName = varName;
		this.runTimeValues = runTimeValues;
		this.varUpdater=varUpdater;
		this.varUpdater.addObserver(this);
		setSettings();

	}

	public static JCheckBox responsiveCheckBox(String varName,Map<String, Value> declaredVar,VariableUpdater varUpdater) {
		QLCheckBox chBox = new QLCheckBox(varName, declaredVar,varUpdater);
		return chBox.getCheckBox();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		varUpdater.updateValues(varName, runTimeValues,new BoolValue(!getState()));
	
		
	}

	private void setSettings() {
		chBox.addActionListener(this);
		chBox.setSelected(getState());
		setStatusText();
		chBox.setBackground(Color.gray);
		chBox.setForeground(Color.white);
	}

	private JCheckBox getCheckBox() {
		return chBox;
	}

	private boolean getState() {
		return ((BoolValue) runTimeValues.get(varName)).getValue();
	}

	private void setStatusText() {
		if (getState()) {
			chBox.setText("Yes");
			return;
		}
		chBox.setText("No");

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		runTimeValues=varUpdater.getUpdatedValues();
		chBox.setSelected(getState());
		setStatusText();
		
		
	}

}
