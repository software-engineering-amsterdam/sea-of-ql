package org.uva.sea.ql.interpreter;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingUtilities;

import org.uva.sea.ql.ast.expr.values.DecimalLit;
import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.Value;

public class QLSpinner  {
	private final String varName;
	private final Map<String, Value> declaredVar;
	private final JSpinner spinner;

   
	
	
	private QLSpinner(String varName,Map<String, Value> declaredVar){
		spinner=new JSpinner(new SpinnerNumberModel(0, 0, 10000, 1));
		this.varName=varName;
		this.declaredVar=declaredVar;
	
	}
	
	public static JSpinner responsiveSpinner(String varName,Map<String, Value> declaredVar) {
		QLSpinner spinner = new QLSpinner(varName, declaredVar);
		return spinner.getSpinner();
	}

	
	
	private JSpinner getSpinner() {

		spinner.setValue(getCurrentValue());
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
			if(getCurrentValue()==0) return;
			decreaseValueByOne();			
		}
		
	}


	
	private void increaseValueByOne(){
		VariableUpdater varUpdater=new VariableUpdater(varName, declaredVar, new IntegerLit(getCurrentValue()+1));
		List<JPanel> questionList=new ArrayList<JPanel>();
		JFrame frame = (JFrame) SwingUtilities.getRoot(spinner);
		new SwingVisitor(questionList,varUpdater.getUpdatedValues()).regenerate(frame);

	}
	
	private void decreaseValueByOne(){
		VariableUpdater varUpdater=new VariableUpdater(varName, declaredVar, new IntegerLit(getCurrentValue()-1));
		List<JPanel> questionList=new ArrayList<JPanel>();
		JFrame frame = (JFrame) SwingUtilities.getRoot(spinner);
		new SwingVisitor(questionList,varUpdater.getUpdatedValues()).regenerate(frame);

	}
    
    
	
	private int getCurrentValue(){
		return ((IntegerLit) declaredVar.get(varName)).getValue();
	}
	
    }