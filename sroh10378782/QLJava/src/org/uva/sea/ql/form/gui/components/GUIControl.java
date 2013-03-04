package org.uva.sea.ql.form.gui.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.AbstractButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.form.gui.state.State;
import org.uva.sea.ql.values.VBool;
import org.uva.sea.ql.values.VMoney;
import org.uva.sea.ql.values.VStr;
import org.uva.sea.ql.values.Value;

public class GUIControl extends Observable {
	
	private final JPanel panel;
	private final List<Observer> observers;
	
	private Value value;
	private Ident ident;
	private State state;
	private Component comp;
	
	public GUIControl(){
		this.panel = new JPanel();
		this.panel.setLayout(null);
		this.observers = new ArrayList<Observer>();
	}
	
	public void setValue(Value value){
		this.value = value;
		JTextField f = (JTextField)this.comp;
		f.setText(""+((VMoney)value).getValue());
	}
	
	public Value getValue(){
		return this.value;
	}
	
	public void setReadOnly(boolean readOnly){
		Component[] c = this.panel.getComponents();
		for (int i = 0; i < c.length; i++) {  
		     c[i].setEnabled(!readOnly);
		}
	}
	
	public void setVisible(boolean visible){
		this.panel.setVisible(visible);
		this.panel.repaint();
	}
	
	public JPanel getPanel(){
		return this.panel;
	}
	
	public void addCheckBox(JCheckBox component){
		component.setVisible(true);
		component.setSelected(false);
		component.setBounds(5, 5, 20, 20);
		
		component.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AbstractButton abstractButton = (AbstractButton) e.getSource();
		        boolean selected = abstractButton.getModel().isSelected();
				state.putValue(ident, new VBool(selected));
				state.notify(ident);
			}
		});
		
		this.panel.add(component);
		this.panel.setVisible(true);
		component.repaint();
	}
	
	public void addNumericTextkBox(JTextField component){
		component.setVisible(true);
		component.setBounds(5, 5, 200, 20);
		component.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
                JTextField field = (JTextField)e.getSource();
				if (validate(field.getText(),true)) {
                   field.setBackground(Color.red);
                } else {
                	state.notify(ident);
                	Double input = Double.parseDouble(field.getText());
                	state.putValue(ident, new VMoney(input));
                	field.setBackground(Color.green);
                }
			}
		});
		this.comp = component;
		this.panel.add(component);
	}
	
	public void addTextkBox(JTextField component){
		component.setVisible(true);
		component.setBounds(5, 5, 200, 20);
		component.addKeyListener(new KeyAdapter() {
			
			public void keyReleased(KeyEvent e) {
                JTextField field = (JTextField)e.getSource();
				if (validate(field.getText(),false)) {
                   field.setBackground(Color.red);
                } else {
                	state.notify(ident);
                	String input = field.getText();
    				state.putValue(ident, new VStr(input));
                	field.setBackground(Color.green);
                }
			}
		});
		this.comp = component;
		this.panel.add(component);
	}
	
	public void registerListener(Ident ident, State state) {
		this.ident = ident;
		this.state = state;
	}
	
	@Override
	public synchronized void addObserver(Observer o) {
		this.observers.add(o);
	}
	
	@Override
	public synchronized int countObservers() {
		return this.observers.size();
	}
	
	@Override
	public void notifyObservers() {
		for(Observer o : this.observers){
			o.update(null, null);
		}
	}
	
	/**
	 * validation method to check the input String
	 * @param input String to check
	 * @param mode numeric = true, false no validation
	 * @return valid
	 */
	private boolean validate(String input, boolean mode){
		boolean error = false;
		if(mode){
			if(input.length() == 0){
				error = true;
			}
			for(int i = 0; i < input.length(); i++){
			    char c = input.charAt(i);        
			    if(!(c >= '0' && c <= '9' || c == '.')){
			    	error = true;
			    }
			}
		}
		return error;
	}
}