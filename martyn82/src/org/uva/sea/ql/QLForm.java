package org.uva.sea.ql;

import java.util.Map;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluate.render.FormBuilder;
import org.uva.sea.ql.evaluate.typecheck.TypeChecker;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;

public class QLForm {
	private final ControlFactory factory;
	private final QLParser parser;
	private final TypeChecker checker;
	private final FormBuilder builder;
	private final String source;

	public QLForm( String source, ControlFactory factory ) {
		this.source = source;
		this.factory = factory;

		this.parser = new QLParser();
		this.checker = new TypeChecker();
		this.builder = new FormBuilder( this.factory );

		this.create();
	}

	private void create() {
		Statement ast = this.parse( source );

		if ( !this.typeCheck( ast ) ) {
			throw new RuntimeException( "TypeChecker failed" );
		}

		this.builder.createForm( ast );
	}

	private boolean typeCheck( Statement root ) {
		return this.checker.check( root );
	}

	private Statement parse( String source ) {
		Statement ast = null;

		try {
			ast = this.parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return ast;
	}

	public PanelControl getForm() {
		return this.builder.getFormPanel();
	}

	public Map<String, Object> getValues() {
		return this.builder.getValues();
	}

	public FormBuilder getBuilder() {
		return this.builder;
	}
}
