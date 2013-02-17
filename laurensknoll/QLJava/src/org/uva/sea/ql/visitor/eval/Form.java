package org.uva.sea.ql.visitor.eval;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.visitor.IForm;

public class Form implements IForm<JFrame> {

	@Override
	public JFrame visit(Question form) {
		JFrame frame = new JFrame();

		Ident ident = form.getIdent();
		frame.setTitle(ident.getName());

		Block statements = form.getStatements();
		Statement visitor = new Statement(new Environment());
		JPanel container = statements.accept(visitor);

		JScrollPane scrollableContainer = new JScrollPane(container);
		frame.add(scrollableContainer);

		frame.setSize(400, 600);

		return frame;
	}

}
