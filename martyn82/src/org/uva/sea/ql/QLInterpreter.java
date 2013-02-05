package org.uva.sea.ql;

import javax.swing.JPanel;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.Error;
import org.uva.sea.ql.evaluator.Renderer;
import org.uva.sea.ql.evaluator.typechecker.QLTypeChecker;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;

public class QLInterpreter {
	private final QLParser parser;
	private final QLTypeChecker typeChecker;

	private Environment environment;
	private JPanel result;
	private Statement ast;

	public QLInterpreter() {
		this.parser = new QLParser();
		this.environment = new Environment();
		this.typeChecker = new QLTypeChecker( this.environment );
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

		this.result = Renderer.render( this.ast, this.environment );

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

	public JPanel getResult() {
		return this.result;
	}
}
