package org.uva.sea.ql.visitor.eval;

import javax.swing.JScrollPane;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.visitor.IForm;
import org.uva.sea.ql.visitor.IStatement;
import org.uva.sea.ql.visitor.eval.ui.Application;
import org.uva.sea.ql.visitor.eval.ui.Panel;

public class Form implements IForm<Application> {

	@Override
	public Application visit(Question form) {
		Application application = new Application();

		Ident ident = form.getIdent();
		application.getGui().setTitle(ident.getName());

		Block statements = form.getStatements();
		IStatement<Panel> statementVisitor = new Statement(
				application.getEnvironment());
		Panel container = statements.accept(statementVisitor);

		JScrollPane scrollableContainer = new JScrollPane(container);
		application.getGui().add(scrollableContainer);

		return application;
	}

}
