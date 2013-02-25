package org.uva.sea.ql.evaluate.render;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ui.ButtonControlEventListener;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.ButtonControl;
import org.uva.sea.ql.ui.control.PanelControl;

public class Form {
	private final ControlFactory factory;
	private final StatementRenderer renderer;

	public Form( Statement root, ControlFactory factory ) {
		BindingEnvironment environment = new BindingEnvironment();

		this.factory = factory;
		this.renderer = new StatementRenderer( factory, environment );
		root.accept( this.renderer );
	}

	public void addButton( String text ) {
		ButtonControl button = this.factory.createButton( text );
		this.getFormPanel().addControl( button );
	}

	public void addButton( String text, ButtonControlEventListener clickListener ) {
		ButtonControl button = this.factory.createButton( text );
		button.addClickListener( clickListener );
		this.getFormPanel().addControl( button );
	}

	public ValueMap getValues() {
		return this.renderer.getValues();
	}

	public String getName() {
		return this.getFormPanel().getName();
	}

	public PanelControl getFormPanel() {
		return this.renderer.getPanel();
	}
}
