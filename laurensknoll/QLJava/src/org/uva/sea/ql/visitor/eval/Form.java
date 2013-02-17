package org.uva.sea.ql.visitor.eval;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.ast.statement.Block;
import org.uva.sea.ql.visitor.IForm;

public class Form implements IForm<JFrame> {

	@Override
	public JFrame visit(Question questionForm) {
		JFrame frame = new JFrame();

		Block statements = questionForm.getStatements();

		Statement visitor = new Statement(new Environment());
		JPanel panel = statements.accept(visitor);
		frame.add(panel);

		return frame;
	}

}
