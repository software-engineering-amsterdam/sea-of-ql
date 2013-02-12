package org.uva.sea.ql.ui.swing;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.control.CheckBoxControl;

public class JCheckBoxControl extends CheckBoxControl {
	private final JCheckBox control;

	public JCheckBoxControl() {
		this.control = new JCheckBox();
	}

	@Override
	public JCheckBox getControl() {
		return this.control;
	}

	@Override
	public void setValue( Object value ) {
		this.setValue( (Boolean) value );
	}

	public void setValue( Boolean value ) {
		this.control.setSelected( value );
	}

	@Override
	public Boolean getValue() {
		return this.control.isSelected();
	}

	@Override
	public void setEnabled( boolean enabled ) {
		this.control.setEnabled( enabled );
	}

	@Override
	public void setVisible( boolean visible ) {
		this.control.setVisible( visible );
	}

	@Override
	public void addChangeListener( final ControlEventListener listener ) {
		this.control.addItemListener( new ItemListener() {
			@Override
			public void itemStateChanged( ItemEvent itemEvent ) {
				JCheckBox component = (JCheckBox) itemEvent.getSource();
				JCheckBoxControl.this.setValue( component.isSelected() );

				listener.itemChanged( new ControlEvent( JCheckBoxControl.this ) );
			}
		} );
	}
}
