package org.uva.sea.ql.visitor.eval;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.visitor.IForm;
import org.uva.sea.ql.visitor.IStatement;

public class Form implements IForm<JFrame> {

	@Override
	public JFrame visit(Question form) {
		JFrame frame = new JFrame();

		Ident ident = form.getIdent();
		frame.setTitle(ident.getName());

		Block statements = form.getStatements();
		IStatement<JPanel> statementVisitor = new Statement(new Environment());
		JPanel container = statements.accept(statementVisitor);

		JScrollPane scrollableContainer = new JScrollPane(container);
		frame.add(scrollableContainer);

		return frame;
	}

}
