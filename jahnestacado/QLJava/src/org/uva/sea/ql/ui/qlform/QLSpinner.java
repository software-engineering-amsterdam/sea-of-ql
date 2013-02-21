package org.uva.sea.ql.ui.qlform;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;
import org.uva.sea.ql.visitor.evaluator.values.IntValue;
import org.uva.sea.ql.visitor.evaluator.values.Value;

public class QLSpinner implements Observer  {
	private final String varName;
	private  Map<String, Value> declaredVar;
	private final JSpinner spinner=new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
	public final static String QL_SPINNER_ID="QLSPINNER";
	private final VariableUpdater varUpdater;


   
	
	
	private QLSpinner(String varName,Map<String, Value> declaredVar, VariableUpdater varUpdater){
		this.varName=varName;
		this.declaredVar=declaredVar;
		spinner.setName("QLSPINNER");
		this.varUpdater=varUpdater;
		this.varUpdater.addObserver(this);
	
	}
	
	public static JSpinner responsiveSpinner(String varName,Map<String, Value> declaredVar, VariableUpdater varUpdater) {
		QLSpinner spinner = new QLSpinner(varName, declaredVar,varUpdater);
		return spinner.getSpinner();
	}

	
	
	private JSpinner getSpinner() {

		spinner.setValue(getCurrentDisplayedValue());
		JFormattedTextField tf = ((JSpinner.DefaultEditor)spinner.getEditor()).getTextField();
		tf.setEditable(false);
				  
		for (Component child : spinner.getComponents()) {
	        if ("Spinner.nextButton".equals(child.getName())) {
	            ((JButton) child).addActionListener(new UpButton());
	        }
	        if ("Spinner.previousButton".equals(child.getName())) {
	            ((JButton) child).addActionListener(new DownButton());
	        }
	    }
		return spinner;
	}

	

   
	private class UpButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			increaseValueByOne();			
		}
		
	}
	
	private class DownButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(getCurrentDisplayedValue()==0) return;
			decreaseValueByOne();			
		}
		
	}


	
	private void increaseValueByOne(){
		updateDisplay(getCurrentDisplayedValue()+1);
	}
	
	private void decreaseValueByOne(){
		updateDisplay(getCurrentDisplayedValue()-1);

	}
	
	private void updateDisplay(int value){
		varUpdater.updateValues(varName, declaredVar, new IntValue(value));
		
		
	}
    
    
	private int getCurrentDisplayedValue(){
		return ((IntValue) declaredVar.get(varName)).getValue();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		declaredVar=varUpdater.getUpdatedValues();
	}
	
    }