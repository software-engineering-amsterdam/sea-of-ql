package org.uva.sea.ql;

import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.type.Bool;
import org.uva.sea.ql.evaluator.Environment;
import org.uva.sea.ql.evaluator.value.form.Form;
import org.uva.sea.ql.evaluator.value.form.Question;

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
			"form Foo {\n" +
			"	\"Bar?\" baz: boolean\n" +
			"	if ( baz ) {\n" +
			"		\"Fooz\" fooz = baz\n" +
			"	}\n" +
			"	else {\n" +
			"		\"Barz\" barz: boolean\n" +
			"		\"Bazz\" bazz = baz && barz\n" +
			"	}\n" +
		"}";

		if ( !this.interpreter.evaluate( source ) ) {
			return;
		}

		Statement ast = this.interpreter.getAST();
		Form form = this.interpreter.getResult();
		System.out.println( "Questions:" + form.getQuestionCount() );
		for ( Question q : form.getQuestions() ) {
			System.out.println( q.getLabel() );
		}

		Environment env = new Environment();
		env.declareType( new Ident( "baz" ), new Bool() );
		env.declareVariable( new Ident( "baz" ), new org.uva.sea.ql.evaluator.value.Boolean( true ) );

		if ( !this.interpreter.typeCheck( ast, env ) ) {
			return;
		}

		this.interpreter.evaluate( ast, env );

		form = this.interpreter.getResult();
		System.out.println( "Questions:" + form.getQuestionCount() );
		for ( Question q : form.getQuestions() ) {
			System.out.println( q.getLabel() );
		}

	}
}
