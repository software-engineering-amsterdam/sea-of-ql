package org.uva.sea.ql;

import javax.swing.JPanel;

import org.uva.sea.ql.evaluator.Error;
import org.uva.sea.ql.ui.Window;

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
			"	\"baz?\" baz: boolean\n" +
			"	if ( baz ) {\n" +
			"		\"fooz?\" fooz = baz\n" +
			"	}\n" +
			"	else {\n" +
			"		\"barz?\" barz: boolean\n" +
			"		\"bazz?\" bazz = baz || barz\n" +
			"	}\n" +
		"		\"bazzz?\" bazzz = baz\n" +
		"}";

		if ( !this.interpreter.evaluate( source ) ) {
			for ( Error error : this.interpreter.getEnvironment().getErrors() ) {
				System.err.println( error.toString() );
			}

			return;
		}

		JPanel form = this.interpreter.getResult();

		Window window = new Window( form.getName(), form );
		window.setVisible( true );
	}
}
