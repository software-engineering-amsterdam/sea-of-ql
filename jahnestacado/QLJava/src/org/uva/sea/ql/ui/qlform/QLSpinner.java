package org.uva.sea.ql.ui.qlform;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import org.uva.sea.ql.ast.expr.values.IntegerLit;
import org.uva.sea.ql.ast.expr.values.Value;
import org.uva.sea.ql.ui.qlform.interpreter.SwingGenerator;
import org.uva.sea.ql.ui.qlform.interpreter.VariableUpdater;

public class QLSpinner  {
	private final String varName;
	private final Map<String, Value> declaredVar;
	private final JSpinner spinner=new JSpinner(new SpinnerNumberModel(0, 0, 1000, 1));
	public final static String QL_SPINNER_ID="QLSPINNER";

   
	
	
	private QLSpinner(String varName,Map<String, Value> declaredVar){
		this.varName=varName;
		this.declaredVar=declaredVar;
		spinner.setName("QLSPINNER");
	
	}
	
	public static JSpinner responsiveSpinner(String varName,Map<String, Value> declaredVar) {
		QLSpinner spinner = new QLSpinner(varName, declaredVar);
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
		update(getCurrentDisplayedValue()+1);
	}
	
	private void decreaseValueByOne(){
		update(getCurrentDisplayedValue()-1);

	}
	
	private void update(int value){
		VariableUpdater varUpdater=new VariableUpdater(varName, declaredVar, new IntegerLit(value));
		List<JPanel> questionList=new ArrayList<JPanel>();
		JFrame frame = (JFrame) SwingUtilities.getRoot(spinner);
		new SwingGenerator(questionList,varUpdater.getUpdatedValues()).regenerate(frame);
		
	}
    
    
	
	private int getCurrentDisplayedValue(){
		return ((IntegerLit) declaredVar.get(varName)).getValue();
	}
	
    }