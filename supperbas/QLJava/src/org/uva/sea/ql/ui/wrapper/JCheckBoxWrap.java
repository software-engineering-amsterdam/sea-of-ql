package org.uva.sea.ql.ui.wrapper;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JCheckBox;


public class JCheckBoxWrap extends Wrapper {

	private JCheckBox checkbox;

	public JCheckBoxWrap() {
		this.checkbox = new JCheckBox();
	}

	@Override
	public void setEnabled(boolean enabled) {
		checkbox.setEnabled(enabled);
	}

	@Override
	public void setVisible(boolean visible) {
		checkbox.setVisible(visible);
	}

	@Override
	public void setValue(String value) {
		this.setValue(Boolean.parseBoolean(value));
	}

	public void setValue(boolean value) {
		checkbox.setSelected(value);
	}

	@Override
	public String getValue() {
		return (checkbox.isSelected() ? "true" : "false");
	}

	@Override
	public void addListener(final WrapperEventListener listener) {
		checkbox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent itemEvent) {
				JCheckBox component = (JCheckBox) itemEvent.getSource();
				JCheckBoxWrap.this.setValue(component.isSelected());
				listener.change(new WrapperEvent(JCheckBoxWrap.this));
			}
		});
	}

	public JCheckBox getComponent() {
		return checkbox;
	}
}
