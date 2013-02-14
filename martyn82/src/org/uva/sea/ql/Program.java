package org.uva.sea.ql;

import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
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
		String source = this.getProgramSource();
		this.interpreter.evaluate( source );

		if ( this.interpreter.hasErrors() ) {
			this.dumpErrors();
			return;
		}

		PanelControl formPanel = this.interpreter.getResult();
		this.factory.createWindow( formPanel.getName(), formPanel ).show();
	}

	private String getProgramSource() {
		return FileLoader.getFileContents( System.getProperty( "user.dir" ) + "/assets/sample.ql" );
	}

	private void dumpErrors() {
		for ( Error error : this.interpreter.getErrors() ) {
			System.err.println( error.toString() );
		}
	}
}