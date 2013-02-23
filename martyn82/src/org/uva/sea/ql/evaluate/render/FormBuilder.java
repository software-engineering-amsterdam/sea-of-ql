package org.uva.sea.ql.evaluate.render;

import java.util.Map;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ui.ButtonControlEventListener;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.ButtonControl;
import org.uva.sea.ql.ui.control.PanelControl;

public class FormBuilder {
	private final ControlFactory factory;
	private final Renderer renderer;

	public FormBuilder( ControlFactory factory ) {
		this.factory = factory;
		this.renderer = new Renderer( this.factory, new BindingEnvironment() );
	}

	public void createForm( Statement root ) {
		root.accept( this.renderer );
	}

	public void addButton( String text ) {
		ButtonControl button = this.factory.createButton( text );
		this.renderer.addControl( button );
	}

	public void addButton( String text, ButtonControlEventListener clickListener ) {
		ButtonControl button = this.factory.createButton( text );
		button.addClickListener( clickListener );
		this.renderer.addControl( button );
	}

	public Map<String, Object> getValues() {
		return this.renderer.getValues();
	}

	public PanelControl getFormPanel() {
		return this.renderer.getPanel();
	}
}
