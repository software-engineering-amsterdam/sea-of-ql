package org.uva.sea.ql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.control.WindowControl;
import org.uva.sea.ql.ui.swing.SwingControlFactory;
import org.uva.sea.ql.visitor.evaluator.Error;

public class Program {
	private final QLInterpreter interpreter;
	private final ControlFactory factory;

	public static void main( String[] args ) {
		Program program = new Program();
		program.run();
	}

	public Program() {
		this.factory = new SwingControlFactory();
		this.interpreter = new QLInterpreter( this.factory );
	}

	public void run() {
		String source = this.getFileContents( System.getProperty( "user.dir" ) + "/assets/sample.ql" );

		this.interpreter.evaluate( source );

		if ( this.interpreter.hasErrors() ) {
			for ( Error error : this.interpreter.getErrors() ) {
				System.err.println( error.toString() );
			}

			return;
		}

		PanelControl formPanel = this.interpreter.getResult();

		WindowControl window = this.factory.createWindow( formPanel.getName(), formPanel );
		window.show();
	}

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
