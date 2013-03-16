package org.uva.sea.ql.visitor.ui.widgets;

import java.awt.Component;
import java.awt.Dimension;
import java.text.Format;

import javax.swing.JFormattedTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public abstract class FormattedTextWidget extends Widget implements DocumentListener {

	private static final long serialVersionUID = -132604908899541084L;
	
	private final WidgetObserver widgetObserver;
	protected final Format format;
	protected JFormattedTextField jFormattedTextfield;

	public FormattedTextWidget(final String description, final WidgetObserver widgetObserver, final Format format) {
		super(description);
		
		this.widgetObserver = widgetObserver;
		this.format = format;
	}

	public Component createInputComponent() {
		jFormattedTextfield = new JFormattedTextField(format);
		
		jFormattedTextfield.getDocument().addDocumentListener(this);
		
		jFormattedTextfield.setMinimumSize(new Dimension(250, (int)jFormattedTextfield.getMinimumSize().getHeight()));
		jFormattedTextfield.setPreferredSize(jFormattedTextfield.getMinimumSize());
		return jFormattedTextfield;
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