package org.uva.sea.ql.evaluator;

import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.evaluator.environment.ValueEnvironment;
import org.uva.sea.ql.ui.ControlFactory;
import org.uva.sea.ql.ui.control.PanelControl;

public class FormCreator {
	private final StatementMapper mapper;

	public FormCreator( ControlFactory factory ) {
		this.mapper = new StatementMapper( factory, new ValueEnvironment() );
	}

	public PanelControl create( Statement statement ) {
		statement.accept( this.mapper );
		return this.mapper.getPanel();
	}
}
