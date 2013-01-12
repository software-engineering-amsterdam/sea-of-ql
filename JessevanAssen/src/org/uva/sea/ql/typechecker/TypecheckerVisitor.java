package org.uva.sea.ql.typechecker;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ASTNodeVisitor;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.type.*;

public class TypecheckerVisitor implements ASTNodeVisitor<Type, Map<Ident, Type>> {

	public void typecheck(Form form) {
		form.accept(this, new HashMap<Ident, Type>());
	}
	
	@Override
	public Type visit(Add astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(And astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Bool astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Computed astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Declaration astNode, Map<Ident, Type> param) {
		if(param.containsKey(astNode.getIdentity()))
			throw new TypecheckerException(String.format("The identity '%s' is already declared!", astNode.getIdentity().getName()));
		
		param.put(astNode.getIdentity(), astNode.getType());
		
		return null;
	}

	@Override
	public Type visit(Div astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Eq astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Form astNode, Map<Ident, Type> param) {
		for(FormElement formElement : astNode.getBody())
			formElement.accept(this, param);
		
		return null;			
	}

	@Override
	public Type visit(GEq astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(GT astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Ident astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(If astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Int astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(LEq astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(LT astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Mul astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Neg astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(NEq astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Not astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Or astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Pos astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Question astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Str astNode, Map<Ident, Type> param) {
		return null;
	}

	@Override
	public Type visit(Sub astNode, Map<Ident, Type> param) {
		return null;
	}

}
