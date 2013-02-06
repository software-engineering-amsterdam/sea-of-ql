package org.uva.sea.ql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.uva.sea.ql.evaluator.Error;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.control.WindowControl;
import org.uva.sea.ql.ui.swing.SwingControlFactory;

/**
 * Main program.
 */
public class Program {
	/**
	 * Holds the interpreter.
	 */
	private final QLInterpreter interpreter;

	private final ControlFactory factory;

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
		this.factory = new SwingControlFactory();
		this.interpreter = new QLInterpreter( this.factory );
	}

	/**
	 * Runs the program.
	 */
	public void run() {
//		String source = "" +
//			"form Foo {\n" +
//			"	\"Q1?\" q1: boolean\n" +
//			"	\"Q2?\" q2: boolean\n" +
//			"	if ( q1 ) {\n" +
//			"		\"Q1.1?\" q11 = q1\n" +
//			"	}\n" +
//			"	else if ( q2 ) {\n" +
//			"		\"Q2.1?\" q21: boolean\n" +
//			"	}\n" +
//			"	else {\n" +
//			"		\"Q3.1?\" q31: boolean\n" +
//			"		\"Q3.2?\" q32 = q1\n" +
//			"	}\n" +
//		"		\"Q5?\" q5 = q2\n" +
//		"}";

		String source = this.getFileContents( System.getProperty( "user.dir" ) + "/assets/sample.ql" );

		if ( !this.interpreter.evaluate( source ) ) {
			for ( Error error : this.interpreter.getEnvironment().getErrors() ) {
				System.err.println( error.toString() );
			}

			return;
		}

		PanelControl formPanel = this.interpreter.getResult();

		WindowControl window = this.factory.createWindow( formPanel.getName(), formPanel );
		window.show();
	}

	/**
	 * Retrieves contents of given file.
	 *
	 * @param fileName
	 *
	 * @return The contents.
	 */
	private String getFileContents( String fileName ) {
		BufferedReader br = null;
		StringBuffer sb = new StringBuffer();
		String line;

		try {
			br = new BufferedReader( new FileReader( fileName ) );

			while ( ( line = br.readLine() ) != null ) {
				sb.append( line );
			}
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
		finally {
			if ( br != null ) {
				try {
					br.close();
				}
				catch ( IOException e ) {
					e.printStackTrace();
				}
			}
		}

		return sb.toString();
	}
}
