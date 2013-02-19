package org.uva.sea.ql;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.FormBuilder;
import org.uva.sea.ql.evaluator.export.Exporter;
import org.uva.sea.ql.evaluator.export.XmlExporter;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;
import org.uva.sea.ql.typechecker.TypeChecker;
import org.uva.sea.ql.ui.ControlEvent;
import org.uva.sea.ql.ui.ControlEventListener;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.visitor.Error;

public class QLInterpreter implements ControlEventListener {
	private final static String SUBMIT_BUTTON_TEXT = "Save";

	private final QLParser parser;
	private final TypeChecker typeChecker;
	private final FormBuilder builder;

	private PanelControl panel;

	public QLInterpreter( ControlFactory factory ) {
		this.parser = new QLParser();
		this.typeChecker = new TypeChecker();
		this.builder = new FormBuilder( factory );
	}

	public boolean evaluate( String source ) {
		Statement root = this.parse( source );
		this.typeChecker.check( root );

		if ( this.typeChecker.hasErrors() ) {
			return false;
		}

		this.builder.createFromTree( root );
		this.builder.addButton( SUBMIT_BUTTON_TEXT, this );
		this.panel = this.builder.getPanel();

		return true;
	}

	public PanelControl getPanel() {
		return this.panel;
	}

	public boolean hasErrors() {
		return this.typeChecker.hasErrors();
	}

	public List<Error> getErrors() {
		return this.typeChecker.getErrors();
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

	@Override
	public void itemChanged( ControlEvent event ) {
		DateFormat format = new SimpleDateFormat( "yyyyMMdd_HHmmss" );
		String dateString = format.format( new Date() );

		Exporter exporter = new XmlExporter( panel.getName(), this.builder.getFormValues() );
		exporter.export( System.getProperty( "user.dir" ) + "/formdata/" + dateString + ".xml" );
	}
}
