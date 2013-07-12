package org.uva.sea.ql.ast.value;

import javax.swing.JOptionPane;

public class IntValue extends Value<Integer> {
	
	Integer value;
	
	public IntValue(Integer i) {
		value = i;
	}

	@Override
	public Integer getValue() {
		return value;
	}
	
	@Override
	public boolean isNumeric() {
		return true;
	}

	@Override
	public boolean setValue(Integer val) {
		return setValue(val.toString());
	}
	
	public boolean setValue(String val) {
		
		try {
			int i = Integer.parseInt(val);
			value = i;
			
			
			if (countObservers() > 0) {
				setChanged();
				notifyObservers();
			}
				
		}
		catch(Exception exc) {
			JOptionPane.showMessageDialog(null, exc.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o instanceof IntValue) {
			IntValue i = (IntValue)o;
			
			return i.getValue().equals(this.getValue());
		}
			
		return false;
	}

}
