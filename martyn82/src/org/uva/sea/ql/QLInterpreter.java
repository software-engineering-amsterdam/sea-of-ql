package org.uva.sea.ql;

import java.util.List;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.Error;
import org.uva.sea.ql.evaluator.Renderer;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;
import org.uva.sea.ql.typechecker.TypeChecker;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;

public class QLInterpreter {
	private final QLParser parser;
	private final TypeChecker typeChecker;
	private final ControlFactory factory;

	private PanelControl result;

	public QLInterpreter( ControlFactory factory ) {
		this.parser = new QLParser();
		this.typeChecker = new TypeChecker();
		this.factory = factory;
	}

	public boolean evaluate( String source ) {
		Statement root = this.parse( source );
		this.typeChecker.check( root );

		if ( this.typeChecker.hasErrors() ) {
			return false;
		}

		this.result = Renderer.render( root, this.factory );

		return true;
	}

	public PanelControl getResult() {
		return this.result;
	}

	public boolean hasErrors() {
		return this.typeChecker.hasErrors();
	}

	public List<Error> getErrors() {
		return this.typeChecker.getErrors();
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
}
