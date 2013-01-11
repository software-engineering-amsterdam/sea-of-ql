package org.uva.sea.ql.typechecker;

import org.uva.sea.ql.ASTNodeVisitor;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.expr.value.*;

public class TypecheckerVisitor implements ASTNodeVisitor<Void, Void> {

	@Override
	public Void visit(Add astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(And astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Bool astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Computed astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Declaration astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Div astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Eq astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Form astNode, Void param) {
		for(FormElement formElement : astNode.getBody())
			formElement.accept(this, param);
		
		return null;			
	}

	@Override
	public Void visit(GEq astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(GT astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Ident astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(If astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Int astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(LEq astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(LT astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Mul astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Neg astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(NEq astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Not astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Or astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Pos astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Question astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Str astNode, Void param) {
		return null;
	}

	@Override
	public Void visit(Sub astNode, Void param) {
		return null;
	}

}
