package org.uva.sea.ql;

import java.util.List;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.FormCreator;
import org.uva.sea.ql.parser.ParseError;
import org.uva.sea.ql.parser.jacc.QLParser;
import org.uva.sea.ql.typechecker.TypeChecker;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;
import org.uva.sea.ql.visitor.Error;

public class QLInterpreter {
	private final QLParser parser;
	private final TypeChecker typeChecker;
	private final FormCreator formCreator;

	private PanelControl panel;

	public QLInterpreter( ControlFactory factory ) {
		this.parser = new QLParser();
		this.typeChecker = new TypeChecker();
		this.formCreator = new FormCreator( factory );
	}

	public boolean evaluate( String source ) {
		Statement root = this.parse( source );
		this.typeChecker.check( root );

		if ( this.typeChecker.hasErrors() ) {
			return false;
		}

		this.panel = this.formCreator.create( root );

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
}
