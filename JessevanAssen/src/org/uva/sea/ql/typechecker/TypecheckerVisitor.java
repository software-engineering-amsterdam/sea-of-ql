package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.Message;
import org.uva.sea.ql.Error;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.expr.*;
import org.uva.sea.ql.ast.type.*;

public class TypecheckerVisitor implements ASTNodeVisitor<Type, TypecheckerVisitor.Context> {

    public static class Context {
        private final Map<Ident, Type> symbolTable;
        private final List<Message> errors;

        public Context() {
            this.symbolTable = new HashMap<Ident, Type>();
            this.errors = new ArrayList<Message>();
        }

        public List<Message> getErrors() { return errors; }
        public Map<Ident, Type> getSymbolTable() { return symbolTable; }
    }

	private static final Type BOOL_TYPE    = new org.uva.sea.ql.ast.type.Bool(),
			                  INT_TYPE     = new org.uva.sea.ql.ast.type.Int(),
			                  STRING_TYPE  = new org.uva.sea.ql.ast.type.Str(),
			                  VOID_TYPE    = new org.uva.sea.ql.ast.type.Void(),
			                  UNKNOWN_TYPE = new org.uva.sea.ql.ast.type.Unknown();

    /**
     * Private constructor to indicate that no instance should be made of this class.
     */
    private TypecheckerVisitor() { }

    /**
     * This method checks a form for errors.
     * @return A list of errors. When no errors are found, an empty list is returned.
     */
	public static List<Message> typecheck(Form form) {
        TypecheckerVisitor typecheckerVisitor = new TypecheckerVisitor();
		Context context = new Context();
        form.accept(typecheckerVisitor, context);
        return context.getErrors();
    }
	
	// Form operations
	@Override
	public Type visit(Computed astNode, Context context) {
        astNode.getExpression().accept(this, context);
		return VOID_TYPE;
	}

    @Override
    public Type visit(CompositeFormElement astNode, Context context) {
        for(FormElement formElement : astNode.getFormElements())
            formElement.accept(this, context);
        return VOID_TYPE;
    }

	@Override
	public Type visit(Form astNode, Context context) {
		astNode.getBody().accept(this, context);
		return VOID_TYPE;
	}
	
	@Override
	public Type visit(Ident astNode, Context context) {
		if(context.getSymbolTable().containsKey(astNode))
			return context.getSymbolTable().get(astNode);
		else {
			context.errors.add(new Error(String.format("Identifier '%s' has not yet been declared!", astNode.getName())));
            /**
             * We are trying to retrieve the type of an undefined variable. There is no way we can determine
             * what type an undefined variable has, because it is literally unknown.
             * To avoid null checks everywhere where a type is used, return an 'null' implementation of the
             * Type interface.
             */
            return UNKNOWN_TYPE;
        }
	}

    @Override
    public Type visit(If astNode, Context context) {
        Type type = astNode.getCondition().accept(this, context);
        if(!type.equals(BOOL_TYPE))
            context.getErrors().add(new Error("The condition of an if-statement should have type boolean."));

        astNode.getIfBody().accept(this, context);

        return VOID_TYPE;
    }

    @Override
    public Type visit(IfElse astNode, Context context) {
        Type type = astNode.getCondition().accept(this, context);
        if(!type.equals(BOOL_TYPE))
            context.getErrors().add(new Error("The condition of an if-statement should have type boolean."));

        astNode.getIfBody().accept(this, context);
        astNode.getElseBody().accept(this, context);

        return VOID_TYPE;
    }
	
	@Override
	public Type visit(Question astNode, Context context) {
        if(!context.getSymbolTable().containsKey(astNode.getIdentifier()))
            context.getSymbolTable().put(astNode.getIdentifier(), astNode.getType());
        else
            context.getErrors().add(new Error(String.format("The identifier '%s' is already declared!", astNode.getIdentifier().getName())));

		return VOID_TYPE;
	}
	
	
	// Value operations
	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Bool astNode, Context context) {
		return BOOL_TYPE;
	}

	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Int astNode, Context context) {
		return INT_TYPE;
	}

	@Override
	public Type visit(org.uva.sea.ql.ast.expr.value.Str astNode, Context context) {
		return STRING_TYPE;
	}


	// Integer operations
	@Override
	public Type visit(Add astNode, Context context) {
		checkBothSidesAreInts(astNode, context, "+");
		return INT_TYPE;
	}
	@Override
	public Type visit(Div astNode, Context context) {
		checkBothSidesAreInts(astNode, context, "/");
		return INT_TYPE;
	}
	
	@Override
	public Type visit(GEq astNode, Context context) {
		checkBothSidesAreInts(astNode, context, ">=");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(GT astNode, Context context) {
		checkBothSidesAreInts(astNode, context, ">");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(LEq astNode, Context context) {
		checkBothSidesAreInts(astNode, context, "<=");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(LT astNode, Context context) {
		checkBothSidesAreInts(astNode, context, "<");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(Mul astNode, Context context) {
		checkBothSidesAreInts(astNode, context, "*");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(Sub astNode, Context context) {
		checkBothSidesAreInts(astNode, context, "-");
		return INT_TYPE;
	}
	
	@Override
	public Type visit(Neg astNode, Context context) {
		checkExpressionIsInt(astNode, context, "-");
		return INT_TYPE;
	}
	
	@Override
	public Type visit(Pos astNode, Context context) {
		checkExpressionIsInt(astNode, context, "+");
		return INT_TYPE;
	}
	
	
	// Boolean operations
	@Override
	public Type visit(And astNode, Context context) {
		checkBothSidesAreBools(astNode, context, "&&");
		return BOOL_TYPE;
	}


	@Override
	public Type visit(Not astNode, Context context) {
		checkExpressionIsBool(astNode, context, "!");
		return BOOL_TYPE;
	}
	
	@Override
	public Type visit(Or astNode, Context context) {
		checkBothSidesAreBools(astNode, context, "||");
		return BOOL_TYPE;
	}

	// Same type on both sides
	@Override
	public Type visit(Eq astNode, Context context) {
		checkBothSidesAreOfSameType(astNode, context, "==");
		return BOOL_TYPE;
	}

	@Override
	public Type visit(NEq astNode, Context context) {
        checkBothSidesAreOfSameType(astNode, context, "!=");
        return BOOL_TYPE;
	}

	
	private void checkBothSidesAreBools(BinaryExpr expression, Context context, String operator) {
		if(
			!expression.getLeftExpression().accept(this, context).equals(BOOL_TYPE) ||
			!expression.getRightExpression().accept(this, context).equals(BOOL_TYPE))
			
			context.getErrors().add(new Error(String.format("Both sides of the '%s' have to be of type boolean.", operator)));
	}
	
	private void checkBothSidesAreInts(BinaryExpr expression, Context context, String operator) {
		if(
			!expression.getLeftExpression().accept(this, context).equals(INT_TYPE) ||
			!expression.getRightExpression().accept(this, context).equals(INT_TYPE))
			
			context.getErrors().add(new Error(String.format("Both sides of the '%s' have to be of type integer.", operator)));
	}

    private void checkBothSidesAreOfSameType(BinaryExpr expression, Context context, String operator) {
        if (
            !expression.getLeftExpression().accept(this, context).equals(
                expression.getRightExpression().accept(this, context)))
            context.getErrors().add(new Error(String.format("The left and right side of the '%s' operator need to be of the same type.", operator)));
    }
	
	private void checkExpressionIsBool(UnaryExpr expression, Context context, String operator) {
		if(!expression.getExpression().accept(this, context).equals(BOOL_TYPE))
            context.getErrors().add(new Error(String.format("The expression of the '%s' operator has to be of type boolean.", operator)));
	}
	
	private void checkExpressionIsInt(UnaryExpr expression, Context context, String operator) {
		if(!expression.getExpression().accept(this, context).equals(INT_TYPE))
            context.getErrors().add(new Error(String.format("The expression of the '%s' operator has to be of type boolean.", operator)));
	}
}
