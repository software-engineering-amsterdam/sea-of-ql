package org.uva.sea.ql.visitor.eval;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.visitor.IForm;
import org.uva.sea.ql.visitor.IStatement;
import org.uva.sea.ql.visitor.eval.ui.Application;
import org.uva.sea.ql.visitor.eval.ui.statement.Panel;

public class Form implements IForm<Application> {

	@Override
	public Application visit(Question form) {
		Application application = new Application(form.getIdent());

		Block statements = form.getStatements();
		IStatement<Panel> statementVisitor = new Statement(
				application.getEnvironment());
		Panel container = statements.accept(statementVisitor);
		application.addScrollablePanel(container);

		return application;
	}

}
