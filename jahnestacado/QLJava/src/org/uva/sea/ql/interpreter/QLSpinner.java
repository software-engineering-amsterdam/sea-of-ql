package org.uva.sea.ql.interpreter;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.Value;

public class QLSpinner extends JSpinner  {
	private final String varName;
	private final Map<String, Value> declaredVar;
	private final Integer value;
   
	
	
	public QLSpinner(String varName,Map<String, Value> declaredVar){
		super(new SpinnerNumberModel(0, 0, 1000, 1));
		this.varName=varName;
		this.declaredVar=declaredVar;
		value=(Integer) declaredVar.get(varName).getValue();
		
	}
	
	public static JSpinner responsiveSpinner(String varName,Map<String, Value> declaredVar) {
		QLSpinner spinner = new QLSpinner(varName, declaredVar);
		return spinner.getSpinner();
	}

	
	
	private JSpinner getSpinner() {
		this.setValue((Integer) value);
		JFormattedTextField tf = ((JSpinner.DefaultEditor)this.getEditor()).getTextField();
		tf.setEditable(false);
				  
		for (Component child : this.getComponents()) {
	        if ("Spinner.nextButton".equals(child.getName())) {
	            ((JButton) child).addActionListener(new UpButton());
	        }
	        if ("Spinner.previousButton".equals(child.getName())) {
	            ((JButton) child).addActionListener(new DownButton());
	        }
	    }
		return this;
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
			if(value==0) return;
			decreaseValueByOne();			
		}
		
	}


	
	private void increaseValueByOne(){
		VariableEnvironment.refreshForm(varName, declaredVar, new IntegerLit(value+1));		

	}
	
	private void decreaseValueByOne(){
		VariableEnvironment.refreshForm(varName, declaredVar, new IntegerLit(value-1));		

	}
    
    
	
	
	
    }