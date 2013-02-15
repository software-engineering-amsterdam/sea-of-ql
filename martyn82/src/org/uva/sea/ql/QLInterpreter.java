package org.uva.sea.ql;

import java.util.List;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.visitor.evaluator.Environment;
import org.uva.sea.ql.visitor.evaluator.Error;
import org.uva.sea.ql.visitor.evaluator.Renderer;
import org.uva.sea.ql.visitor.typechecker.TypeChecker;

public class QLInterpreter {
	private final QLParser parser;
	private final TypeChecker typeChecker;
	private final ControlFactory factory;

	private Environment environment;
	private PanelControl result;

	public QLInterpreter( ControlFactory factory ) {
		this.parser = new QLParser();
		this.typeChecker = new TypeChecker();

		this.environment = new Environment();
		this.factory = factory;
	}

	public boolean evaluate( String source ) {
		Statement root = this.parse( source );
		this.typeChecker.check( root );

		if ( this.typeChecker.hasErrors() ) {
			this.dumpErrors();
			return false;
		}

		this.result = Renderer.render( root, this.factory );
		return true;
	}

	public boolean hasErrors() {
		return this.environment.getErrors().size() > 0;
	}

	public List<Error> getErrors() {
		return this.environment.getErrors();
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

	private void dumpErrors() {
		if ( !this.typeChecker.hasErrors() ) {
			return;
		}

		for ( Error error : this.typeChecker.getErrors() ) {
			System.err.println( error.toString() );
		}
	}

	public PanelControl getResult() {
		return this.result;
	}
}
