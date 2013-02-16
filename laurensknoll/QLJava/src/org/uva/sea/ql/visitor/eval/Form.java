package org.uva.sea.ql.visitor.eval;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expr.atom.Ident;
import org.uva.sea.ql.ast.form.Question;
import org.uva.sea.ql.visitor.IForm;

public class Form implements IForm<JFrame> {

	private final Environment environment;

	public Form() {
		this.environment = new Environment();
	}

	@Override
	public JFrame visit(Question questionForm) {
		JFrame frame = new JFrame();

		Ident id = questionForm.getIdent();

		// TODO: Create a container that holds the type and value.
		this.environment.declare(id, null);

		Statement statementVisitor = new Statement(this.environment);
		JPanel panel = questionForm.getStatements().accept(statementVisitor);
		frame.add(panel);

		return frame;
	}

}
