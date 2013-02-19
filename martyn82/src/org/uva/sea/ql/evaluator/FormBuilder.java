package org.uva.sea.ql.evaluator;

import java.util.Map;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.environment.Binding;
import org.uva.sea.ql.evaluator.environment.BindingEnvironment;
import org.uva.sea.ql.ui.ButtonControlEventListener;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.ButtonControl;
import org.uva.sea.ql.ui.control.PanelControl;

public class FormBuilder {
	private final Renderer mapper;
	private final ControlFactory factory;

	public FormBuilder( ControlFactory factory ) {
		this.factory = factory;
		this.mapper = new Renderer( this.factory, new BindingEnvironment() );
	}

	public void createFromTree( Statement root ) {
		root.accept( this.mapper );
	}

	public void addButton( String text ) {
		ButtonControl button = this.factory.createButton( text );
		this.mapper.addControl( button );
	}

	public void addButton( String text, ButtonControlEventListener clickListener ) {
		ButtonControl button = this.factory.createButton( text );
		button.addClickListener( clickListener );
		this.mapper.addControl( button );
	}

	public PanelControl getPanel() {
		return this.mapper.getPanel();
	}

	public Map<String, Binding> getFormValues() {
		return this.mapper.getBoundValues();
	}
}
