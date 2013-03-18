package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.uva.sea.ql.value.TextValue;
import org.uva.sea.ql.value.Value;

public class TextWidget extends Widget implements DocumentListener {

	private static final long serialVersionUID = -132604908899541084L;
	
	private final WidgetObserver widgetObserver;
	
	private JTextField jTextField;

	public TextWidget(final String description, final WidgetObserver widgetObserver) {
		super(description);
		
		this.widgetObserver = widgetObserver;
	}

	@Override
	protected JTextField createInputComponent() {
		jTextField = new JTextField();
		jTextField.getDocument().addDocumentListener(this);
		jTextField.setMinimumSize(new Dimension(250, (int)jTextField.getMinimumSize().getHeight()));
		jTextField.setPreferredSize(jTextField.getMinimumSize());
		return jTextField;
	}

	@Override
	public Value getValue() {
		return new TextValue(jTextField.getText());
	}
	
	@Override
	public void changedUpdate(DocumentEvent e) {
		widgetObserver.widgetUpdate(this);
	}


	@Override
	public void insertUpdate(DocumentEvent e) {
		widgetObserver.widgetUpdate(this);
	}


	@Override
	public void removeUpdate(DocumentEvent e) {
		widgetObserver.widgetUpdate(this);
	}

}