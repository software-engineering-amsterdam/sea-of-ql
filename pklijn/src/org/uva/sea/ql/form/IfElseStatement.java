package org.uva.sea.ql.form;

import java.awt.Component;
import java.awt.Container;
import java.awt.Label;
import java.util.List;

import net.miginfocom.swing.MigLayout;

import org.uva.sea.ql.ast.eval.Env;
import org.uva.sea.ql.ast.expressions.Expr;

public class IfElseStatement extends IfStatement {

	private final List<FormItem> elseBody;
	
	public IfElseStatement(Expr expression, List<FormItem> ifBody, List<FormItem> elseBody) {
		super(expression, ifBody);
		this.elseBody = elseBody;
	}

	
	public List<FormItem> getElseBody() {
		return elseBody;
	}

	@Override
	public void print(int level) {
		printIndent(level);
		System.out.println("IF expr: "+ getExpression());
		printErrors();
		for (FormItem f : getIfBody()) {
			f.print(level + 1);
		}
		printIndent(level);
		System.out.println("ELSE");
		for (FormItem f : elseBody) {
			f.print(level + 1);
		}
	}
	
	@Override
	public boolean validate(Env environment) {
		boolean valid = super.validate(environment);
		Env elseBodyEnvironment = new Env(environment);
		for (FormItem f : elseBody) {
			if (!f.validate(elseBodyEnvironment))
				valid = false;
		}
		return errors.size() == 0 && valid;
	}
	
//	@Override
//	public Component getFormComponent() {
//		Container ifContainer = (Container)super.getFormComponent();
//		Container elseBodyContainer = new Container();
//		elseBodyContainer.setLayout(new MigLayout("wrap 1, debug"));
//		for (FormItem f : elseBody) {
//			elseBodyContainer.add(f.getFormComponent());
//		}
//		ifContainer.add(new Label("ELSE"), "wrap");
//		ifContainer.add(elseBodyContainer, "wrap");
//		return ifContainer;
//	}
}
