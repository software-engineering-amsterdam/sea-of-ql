package org.uva.sea.ql;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.Environment;

/**
 * Main program.
 */
public class Program {
	/**
	 * Holds the interpreter.
	 */
	private final QLInterpreter interpreter;

	/**
	 * Main application entry point.
	 *
	 * @param args
	 */
	public static void main( String[] args ) {
		Program program = new Program();
		program.run();
	}

	/**
	 * Constructs a new Program instance.
	 */
	public Program() {
		this.interpreter = new QLInterpreter();
	}

	/**
	 * Runs the program.
	 */
	public void run() {
		String source = "" +
			"form Foo {" +
			"	\"Bar?\" baz = false" +
			"	if ( baz ) {" +
			"		x = true" +
			"	}" +
			"	else {" +
			"		x = false" +
			"	}" +
		"}";

		Environment env = this.interpreter.getEnvironment();
		this.interpreter.evaluate( source );
		Statement ast = this.interpreter.getAST();
		System.out.println( env.lookup( new Ident( "x" ) ).getValue() );

		env.declareVariable( new Ident( "baz" ), new org.uva.sea.ql.evaluator.value.Boolean( true ) );
		this.interpreter.evaluate( ast, env );
		System.out.println( env.lookup( new Ident( "x" ) ).getValue() );
	}
}
