package org.uva.sea.ql.runtime;

import javax.swing.JComponent;

public abstract class Binding<TComponent extends JComponent> {

	private final Variable variable;
	private final TComponent guiElem;
	private boolean isChanging = false;
	
	private IPropertyChangeListener<Variable> modelListener;
	
	
	
	public Binding(Variable variable, TComponent component) {
		this.variable = variable;
		this.guiElem = component;
		
		this.modelListener = new IPropertyChangeListener<Variable>() {
			@Override
			public void onValueChanged(Variable value) {
				Binding.this.onModelChanged(value);
			}
		};
		variable.addValueChangedListener(this.modelListener);
	}
	
	public TComponent getGuiComponent() {
		return this.guiElem;
	}
	
	protected abstract void setGuiValue(Value value);
	
	protected void onGuiChanged(Value newValue) {
		if (this.isChanging) {
			return;
		}
		this.isChanging = true;
		this.variable.setValue(newValue);
		this.isChanging = false;
	}
	private void onModelChanged(Variable varWithNewValue) {
		if (this.isChanging) {
			return;
		}
		this.isChanging = true;
		this.setGuiValue(varWithNewValue.getValue());
		this.isChanging = false;
		
		
	}
}
