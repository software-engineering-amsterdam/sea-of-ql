package khosrow.uva.sea.ql.ui.controls;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JTextField;

import khosrow.uva.sea.ql.ast.expr.Ident;
import khosrow.uva.sea.ql.ui.State;
import khosrow.uva.sea.ql.values.Value;

public abstract class TextInputControl extends Control {
	protected final JTextField component; 
	protected abstract Control getControl();
	protected abstract Value getValue();

	public TextInputControl(){
		this.component = new JTextField();
	}
	
	public String getInput() {
		return component.getText();
	}
	
	public void setBorder(Color color) {
		component.setBorder(BorderFactory.createLineBorder(color));
	}
	
	@Override
	public Component getComponent(){
		return component;
	}
	
	@Override
	public void setValue(Value value) {
		component.setText(value.toString());		
	}

	@Override
	public void setVisible(boolean isVisible) {
		component.setVisible(isVisible);		
	}

	@Override
	public void setEnabled(boolean isEnabled) {
		component.setEnabled(isEnabled);		
	}

	@Override
	public void addListener(final Ident name, final State state) {
		component.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {				
				if(!InputVerifier.Verify(getControl())){					
					return;
				}
				state.assignValue(name, getValue());
				state.notifyObervers(name);
			}			
		});			
	}
}
