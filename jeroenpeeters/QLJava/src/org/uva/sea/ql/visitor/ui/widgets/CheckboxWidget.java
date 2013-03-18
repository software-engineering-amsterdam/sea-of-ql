package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Component;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.event.ChangeEvent;

import org.uva.sea.ql.value.BooleanValue;
import org.uva.sea.ql.value.Value;

public class CheckboxWidget extends Widget implements ItemListener {

	private static final long serialVersionUID = 2789085532540606840L;
	
	private JCheckBox jCheckBox;
	private final WidgetObserver widgetObserver;
	
	public CheckboxWidget(final String description, final WidgetObserver widgetObserver) {
		super(description);
		
		this.widgetObserver = widgetObserver;
	}

	@Override
	protected Component createInputComponent() {
		this.jCheckBox = new JCheckBox();
		this.jCheckBox.addItemListener(this);
		return jCheckBox;
	}

	@Override
	public Value getValue() {
		return new BooleanValue(this.jCheckBox.isSelected());
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		widgetObserver.widgetUpdate(this);
	}

}