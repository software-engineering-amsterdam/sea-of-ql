package org.uva.sea.ql;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluate.Error;
import org.uva.sea.ql.evaluate.render.Form;
import org.uva.sea.ql.evaluate.typecheck.TypeChecker;
import org.uva.sea.ql.export.Exporter;
import org.uva.sea.ql.export.XmlExporter;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;
import org.uva.sea.ql.ui.ButtonControlEventListener;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.ui.swing.SwingControlFactory;

public class Program {
	private final static String SUBMIT_BUTTON_TEXT = "Save";
	private final ControlFactory factory;

	public static void main( String[] args ) {
		Program program = new Program();
		program.run();
	}

	public Program() {
		this.factory = new SwingControlFactory();
	}

	public void run() {
		String source = this.getProgramSource();

		Statement astRoot = this.parse( source );
		this.typeCheck( astRoot );
		PanelControl panel = this.render( astRoot );

		this.factory.createWindow( panel.getName(), panel ).show();
	}

	private Statement parse( String source ) {
		QLParser parser = new QLParser();
		Statement ast;

		try {
			ast = parser.parse( source );
		}
		catch ( ParseError e ) {
			e.printStackTrace();
			throw new RuntimeException( e );
		}

		return ast;
	}

	private boolean typeCheck( Statement root ) {
		TypeChecker checker = new TypeChecker();
		checker.check( root );

		if ( checker.hasErrors() ) {
			for ( Error each : checker.getErrors() ) {
				System.err.println( each.toString() );
			}

			return false;
		}

		return true;
	}

	private PanelControl render( Statement root ) {
		final Form form = new Form( root, this.factory );
		form.addButton( SUBMIT_BUTTON_TEXT, new ButtonControlEventListener() {
			@Override
			public void buttonClicked( ControlEvent event ) {
				DateFormat format = new SimpleDateFormat( "yyyyMMdd_HHmmss" );
				String dateString = format.format( new Date() );

				Exporter exporter = new XmlExporter( form.getName(), form.getValues() );
				exporter.export( System.getProperty( "user.dir" ) + "/formdata/" + dateString + ".xml" );
			}
		} );
		return form.getFormPanel();
	}

	private String getProgramSource() {
		return TextFileLoader.getFileContents( System.getProperty( "user.dir" ) + "/assets/sample.ql" );
	}
}
