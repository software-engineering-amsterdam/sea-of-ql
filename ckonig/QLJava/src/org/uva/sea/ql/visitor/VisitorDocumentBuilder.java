package org.uva.sea.ql.visitor;

import org.uva.sea.ql.ast.elements.Block;
import org.uva.sea.ql.ast.elements.Form;
import org.uva.sea.ql.ast.elements.IfStatement;
import org.uva.sea.ql.ast.elements.Question;
import org.uva.sea.ql.ast.expressions.Expr;

public class VisitorDocumentBuilder implements ASTVisitor {

	private QLDocument document;

	public VisitorDocumentBuilder(QLDocument document) {
		this.document = document;
	}

	@Override
	public void visit(Form form) throws VisitorException {
		document.setHeading(form.getName());
		form.getBlock().accept(this);
		document.create();
	}

	@Override
	public void visit(Block block) throws VisitorException {
		for (Expr e : block.getContent()) {
			if (e instanceof Question) {
				((Question) e).accept(this);
			}
			if (e instanceof IfStatement) {
				((IfStatement) e).accept(this);
			}
		}
	}

	@Override
	public void visit(Question question) throws VisitorException {
		document.appendQuestion(question);
	}

	@Override
	public void visit(IfStatement ifStatement) throws VisitorException {
		document.beginIf(ifStatement);
		ifStatement.getContent().accept(this);
		document.endIf();
	}

	public Object getOutput() {
		return document.getOutput();
	}

}
