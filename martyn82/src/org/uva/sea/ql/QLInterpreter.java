package org.uva.sea.ql;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.Error;
import org.uva.sea.ql.evaluator.Renderer;
import org.uva.sea.ql.evaluator.typechecker.QLTypeChecker;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;

public class QLInterpreter {
	private final QLParser parser;
	private final QLTypeChecker typeChecker;
	private final ControlFactory factory;

	private Environment environment;
	private PanelControl result;
	private Statement ast;

	public QLInterpreter( ControlFactory factory ) {
		this.parser = new QLParser();
		this.environment = new Environment();
		this.typeChecker = new QLTypeChecker( this.environment );
		this.factory = factory;
	}

	public Environment getEnvironment() {
		return this.environment;
	}

	public boolean typeCheck( Statement node, Environment environment ) {
		this.environment = environment;
		QLTypeChecker checker = new QLTypeChecker( environment );

		if ( !node.accept( checker ) ) {
			this.dumpErrors();
			return false;
		}

		return true;
	}

	public boolean evaluate( String source ) {
		try {
			this.ast = this.parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		if ( !this.ast.accept( this.typeChecker ) ) {
			this.dumpErrors();
			return false;
		}

		this.result = Renderer.render( this.ast, this.environment, this.factory );

		return true;
	}

	public Statement getAST() {
		return this.ast;
	}

	private void dumpErrors() {
		for ( Error error : this.environment.getErrors() ) {
			System.err.println( error.toString() );
		}
	}

	public PanelControl getResult() {
		return this.result;
	}
}
