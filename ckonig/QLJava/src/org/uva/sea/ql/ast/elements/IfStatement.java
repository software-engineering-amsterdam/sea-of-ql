package org.uva.sea.ql.ast.elements;

import java.util.ArrayList;
import java.util.List;

import org.uva.sea.ql.ast.BinaryExpr;
import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.visitor.ASTElement;
import org.uva.sea.ql.visitor.ASTVisitor;
import org.uva.sea.ql.visitor.VisitorException;

public class IfStatement extends Expr implements ASTElement {
	private Expr condition;
	private Block content;

	public IfStatement(Expr condition, Block content) {
		this.condition = condition;
		this.content = content;
	}

	public Expr getCondition() {
		return condition;
	}

	public Block getContent() {
		return content;
	}

	@Override
	public void accept(ASTVisitor visitor) throws VisitorException{
		visitor.visit(this);
	}
	public List<Ident> getIdents(){
		return getIdents(condition);
	}
	private List<Ident> getIdents(Expr e) {
		List<Ident> idents = new ArrayList<>();
		if (e.getClass().equals(Ident.class)) {
			idents.add((Ident) e);
		}
		if (e instanceof BinaryExpr) {
			BinaryExpr b = (BinaryExpr) e;
			idents.addAll(getIdents(b.getLeft()));
			idents.addAll(getIdents(b.getRight()));
		}
		return idents;
	}
}
