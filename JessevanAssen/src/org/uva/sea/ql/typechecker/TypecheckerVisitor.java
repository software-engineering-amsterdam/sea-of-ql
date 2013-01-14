package org.uva.sea.ql.typechecker;

import java.util.HashMap;
import java.util.Map;

import org.uva.sea.ql.ASTNodeVisitor;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.type.*;

import sun.org.mozilla.javascript.internal.ast.UnaryExpression;

public class TypecheckerVisitor implements ASTNodeVisitor<Type, Map<Ident, Type>> {

	private static final Type BOOL_TYPE   = new org.uva.sea.ql.ast.type.Bool(),
			                  INT_TYPE    = new org.uva.sea.ql.ast.type.Int(),
			                  STRING_TYPE = new org.uva.sea.ql.ast.type.Str();
	
	
	public void typecheck(Form form) {
		form.accept(this, new HashMap<Ident, Type>());
	}	
	
	
	// Form operations
	@Override
	public Type visit(Computed astNode, Map<Ident, Type> param) {
        astNode.getExpression().accept(this, param);
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
	public Type visit(Form astNode, Map<Ident, Type> param) {
		for(FormElement formElement : astNode.getBody())
			formElement.accept(this, param);
		
		return null;			
	}
	
	@Override
	public Type visit(Ident astNode, Map<Ident, Type> param) {
		if(param.containsKey(astNode))
			return param.get(astNode);
		else
			throw new TypecheckerException(
				String.format("Identity '%s' has not yet been declared!", astNode.getName()));
	}
	
	@Override
	public Type visit(If astNode, Map<Ident, Type> param) {
		astNode.getCondition().accept(this, param);
		for(ASTNode x : astNode.getIfBody())
			x.accept(this, param);
		for(ASTNode x : astNode.getElseBody())
			x.accept(this, param);
		
		return null;
	}
	
	@Override
	public Type visit(Question astNode, Map<Ident, Type> param) {
		astNode.getDeclaration().accept(this, param);
		return null;
	}
	
	
	// Value operations
	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Bool astNode, Map<Ident, Type> param) {
		return BOOL_TYPE;
	}

	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Int astNode, Map<Ident, Type> param) {
		return INT_TYPE;
	}

	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Str astNode, Map<Ident, Type> param) {
		return STRING_TYPE;
	}


	// Integer operations
	@Override
	public Type visit(Add astNode, Map<Ident, Type> param) {
		checkBothSidesAreInts(astNode, param, "+");
		return INT_TYPE;
	}
	@Override
	public Type visit(Div astNode, Map<Ident, Type> param) {
		checkBothSidesAreInts(astNode, param, "/");
		return INT_TYPE;
	}
	
	@Override
	public Type visit(GEq astNode, Map<Ident, Type> param) {
		checkBothSidesAreInts(astNode, param, ">=");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(GT astNode, Map<Ident, Type> param) {
		checkBothSidesAreInts(astNode, param, ">");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(LEq astNode, Map<Ident, Type> param) {
		checkBothSidesAreInts(astNode, param, "<=");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(LT astNode, Map<Ident, Type> param) {
		checkBothSidesAreInts(astNode, param, "<");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(Mul astNode, Map<Ident, Type> param) {
		checkBothSidesAreInts(astNode, param, "*");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(Sub astNode, Map<Ident, Type> param) {
		checkBothSidesAreInts(astNode, param, "-");
		return INT_TYPE;
	}
	
	@Override
	public Type visit(Neg astNode, Map<Ident, Type> param) {
		checkExpressionIsInt(astNode, param, "-");
		return INT_TYPE;
	}
	
	@Override
	public Type visit(Pos astNode, Map<Ident, Type> param) {
		checkExpressionIsInt(astNode, param, "+");
		return INT_TYPE;
	}
	
	
	// Boolean operations
	@Override
	public Type visit(And astNode, Map<Ident, Type> param) {
		checkBothSidesAreBools(astNode, param, "||");
		return BOOL_TYPE;
	}


	@Override
	public Type visit(Not astNode, Map<Ident, Type> param) {
		checkExpressionIsBool(astNode, param, "!");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(Or astNode, Map<Ident, Type> param) {
		checkBothSidesAreBools(astNode, param, "||");
		return BOOL_TYPE;
	}

	// Same type on both sides
	@Override
	public Type visit(Eq astNode, Map<Ident, Type> param) {
		checkBothSidesAreOfSameType(astNode, param, "==");
		return BOOL_TYPE;
	}

	@Override
	public Type visit(NEq astNode, Map<Ident, Type> param) {
        checkBothSidesAreOfSameType(astNode, param, "!=");
        return BOOL_TYPE;
	}

	
	private void checkBothSidesAreBools(BinaryExpr expression, Map<Ident, Type> param, String operator) {
		if(
			expression.getLeftExpression().accept(this, param) != BOOL_TYPE ||
			expression.getRightExpression().accept(this, param) != BOOL_TYPE)
			
			throw new TypecheckerException(String.format("Both sides of the '%s' have to be of type boolean.", operator));
	}
	
	private void checkBothSidesAreInts(BinaryExpr expression, Map<Ident, Type> param, String operator) {
		if(
			expression.getLeftExpression().accept(this, param) != INT_TYPE ||
			expression.getRightExpression().accept(this, param) != INT_TYPE)
			
			throw new TypecheckerException(String.format("Both sides of the '%s' have to be of type integer.", operator));
	}

    private void checkBothSidesAreOfSameType(BinaryExpr expression, Map<Ident, Type> param, String operator) {
        if (
            expression.getLeftExpression().accept(this, param) !=
                expression.getRightExpression().accept(this, param))
            throw new TypecheckerException(String.format("The left and right side of the '%s' operator need to be of the same type.", operator));
    }
	
	private void checkExpressionIsBool(UnaryExpr expression, Map<Ident, Type> param, String operator) {
		if(expression.getExpression().accept(this, param) != BOOL_TYPE)
			throw new TypecheckerException(String.format("The expression of the '%s' operator has to be of type boolean.", operator));
	}
	
	private void checkExpressionIsInt(UnaryExpr expression, Map<Ident, Type> param, String operator) {
		if(expression.getExpression().accept(this, param) != INT_TYPE)
			throw new TypecheckerException(String.format("The expression of the '%s' operator has to be of type boolean.", operator));
	}
}
