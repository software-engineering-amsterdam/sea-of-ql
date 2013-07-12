package org.uva.sea.ql.ast.value;

import javax.swing.JOptionPane;

public class BoolValue extends Value<Boolean> {
	
	private Boolean value;
	
	public BoolValue(Boolean b) {
		value = b;
	}

	@Override
	public Boolean getValue() {
		return value;
	}
	
	@Override
	public boolean isBoolean() {
		return true;
	}

	@Override
	public boolean setValue(Boolean val) {
		return setValue(val.toString());
	}

	@Override
	public boolean setValue(String s) {
		try {
			boolean b = Boolean.parseBoolean(s);
			value = b;
			
			setChanged();
			notifyObservers();
		}
		catch(Exception exc) {
			JOptionPane.showMessageDialog(null, exc.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}

}
