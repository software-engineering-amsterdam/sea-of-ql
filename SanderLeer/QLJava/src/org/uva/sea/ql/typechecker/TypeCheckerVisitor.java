package org.uva.sea.ql.typechecker;

import java.util.ArrayList;
import org.uva.sea.ql.ast.*;
import org.uva.sea.ql.ast.datatype.*;
import org.uva.sea.ql.ast.expression.*;
import org.uva.sea.ql.ast.expression.binary.*;
import org.uva.sea.ql.ast.expression.literal.*;
import org.uva.sea.ql.ast.expression.unary.*;
import org.uva.sea.ql.ast.statement.*;

class TypeCheckerVisitor implements Visitor<Boolean> {
	private final SymbolTable symbols;
	private final ArrayList<String> errors;

	public TypeCheckerVisitor(SymbolTable symboltable, ArrayList<String> errors) {
		this.symbols = symboltable;
		this.errors = errors;
	}

	private void addError(String s) {
		errors.add(s);
	}

	private String makeError(String token) {
		return makeError(token, null);
	}
	
	private String makeError(String token, String handSide) {
		return "Invalid datatype for " + (handSide != null ? handSide + " part of " : "") + "'" + token + "'";
	}

	private boolean isValidExpression(Expression expression) {
		return expression.accept(this);
	}
	
	private boolean isValidInteger(Expression expression, String token) {
		return isValidInteger(expression, token, null);
	}

	private boolean isValidInteger(Expression lhs, Expression rhs, String token) {
		boolean validLhs = isValidInteger(lhs, token, "left"); 
		boolean validRhs = isValidInteger(rhs, token, "right"); 
		return validLhs && validRhs;
	}

	private boolean isValidInteger(Expression expression, String token, String handSide) {
		// check if the expression is valid
		if (isValidExpression(expression)) {
			Datatype datatype = expression.typeOf(symbols);
			if ((datatype != null) && (datatype.isCompatibleToInteger())) {
				return true;
			}
			addError(makeError(token, handSide));
		}
		return false;
	}

	private boolean isValidBoolean(Expression expression, String token) {
		return isValidBoolean(expression, token, null);
	}

	private boolean isValidBoolean(Expression lhs, Expression rhs, String token) {
		boolean validLhs = isValidBoolean(lhs, token, "left"); 
		boolean validRhs = isValidBoolean(rhs, token, "right"); 
		return validLhs && validRhs;
	}

	private boolean isValidBoolean(Expression expression, String token, String handSide) {
		// check if the expression is valid
		if (isValidExpression(expression)) {
			Datatype datatype = expression.typeOf(symbols);
			if ((datatype != null) && (datatype.isCompatibleToBoolean())) {
				return true;
			}
			addError(makeError(token, handSide));
		}
		return false;
	}

	private boolean areEqualityDatatypes(Expression lhs, Expression rhs, String token) {
		boolean validLhs = isValidExpression(lhs); 
		boolean validRhs = isValidExpression(rhs); 

		if (validLhs && validRhs) {
			Datatype lhsDatatype = lhs.typeOf(symbols);
			Datatype rhsDatatype = rhs.typeOf(symbols);
			
			// check if LHS and RHS are the same datatypes for a equality expression
			if ((lhsDatatype != null) && (rhsDatatype != null) &&
				(lhsDatatype.isCompatibleTo(rhsDatatype))) {
				return true;
			}
			addError(makeError(token));
		}
		return false;
	}

	private boolean areRelationalDatatypes(Expression lhs, Expression rhs, String token) {
		boolean validLhs = isValidExpression(lhs); 
		boolean validRhs = isValidExpression(rhs); 

		if (validLhs && validRhs) {
			Datatype lhsDatatype = lhs.typeOf(symbols);
			Datatype rhsDatatype = rhs.typeOf(symbols);
			
			// check if LHS and RHS are the same datatypes for a relational expression
			// this excludes boolean types 
			if (((lhsDatatype != null) && (rhsDatatype != null)) &&
				((lhsDatatype.isCompatibleToString() && rhsDatatype.isCompatibleToString()) ||
				 (lhsDatatype.isCompatibleToInteger() && rhsDatatype.isCompatibleToInteger()))) {
					return true;
			}
			addError(makeError(token));
		}
		return false;
	}

	@Override
	public Boolean visit(Pos node) {
		return isValidInteger(node.getOperand(), "+");
	}

	@Override
	public Boolean visit(Neg node) {
		return isValidInteger(node.getOperand(), "-");
	}

	@Override
	public Boolean visit(Not node) {
		return isValidBoolean(node.getOperand(), "!");
	}

	@Override
	public Boolean visit(Mul node) {
		return isValidInteger(node.getLhs(), node.getRhs(), "*");
	}

	@Override
	public Boolean visit(Div node) {
		return isValidInteger(node.getLhs(), node.getRhs(), "/");
	}

	@Override
	public Boolean visit(Add node) {
		return isValidInteger(node.getLhs(), node.getRhs(), "+");
	}

	@Override
	public Boolean visit(Sub node) {
		return isValidInteger(node.getLhs(), node.getRhs(), "-");
	}

	@Override
	public Boolean visit(Eq node) {
		return areEqualityDatatypes(node.getLhs(), node.getRhs(), "==");
	}

	@Override
	public Boolean visit(NEq node) {
		return areEqualityDatatypes(node.getLhs(), node.getRhs(), "!=");
	}

	@Override
	public Boolean visit(GT node) {
		return areRelationalDatatypes(node.getLhs(), node.getRhs(), ">");
	}

	@Override
	public Boolean visit(LT node) {
		return areRelationalDatatypes(node.getLhs(), node.getRhs(), "<");
	}

	@Override
	public Boolean visit(GEq node) {
		return areRelationalDatatypes(node.getLhs(), node.getRhs(), ">=");
	}

	@Override
	public Boolean visit(LEq node) {
		return areRelationalDatatypes(node.getLhs(), node.getRhs(), "<=");
	}

	@Override
	public Boolean visit(And node) {
		return isValidBoolean(node.getLhs(), node.getRhs(), "&&");
	}

	@Override
	public Boolean visit(Or node) {
		return isValidBoolean(node.getLhs(), node.getRhs(), "||");
	}

	@Override
	public Boolean visit(IntegerLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(BooleanLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(StringLiteral node) {
		return true;
	}

	@Override
	public Boolean visit(IntegerType node) {
		return true;
	}

	@Override
	public Boolean visit(StringType node) {
		return true;
	}

	@Override
	public Boolean visit(BooleanType node) {
		return true;
	}

	@Override
	public Boolean visit(Identifier node) {
		if (!symbols.contains(node.getName())) {
			addError("Variable '" + node.getName() + "' not defined");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(StatementList node) {
		boolean result = true;
		for (Statement e : node.getList()) {
			if (!e.accept(this)) {
				result = false;
			}
		}
		return result;
	}

	@Override
	public Boolean visit(Form node) {
		return node.getStatements().accept(this);
	}

	private boolean addIdentifier(Identifier identifier, Datatype datatype) {
		if (symbols.contains(identifier.getName())) {
			addError("Identifier '" + identifier.getName() + "' already defined");
			return false;
		}
		symbols.put(identifier.getName(), datatype);
		return true;
	}
	
	@Override
	public Boolean visit(Question node) {
		return addIdentifier(node.getIdentifier(), node.getDatatype());
	}

	@Override
	public Boolean visit(ComputedQuestion node) {
		boolean validIdentifier = addIdentifier(node.getIdentifier(), node.getDatatype());
		boolean validExpression = isValidExpression(node.getExpression());

		// check if expression of computed question is the same datatype as question identifier
		boolean validDatatype;
		Datatype exprDatatype = node.getExpression().typeOf(symbols);
		if ((exprDatatype != null) && (!exprDatatype.isCompatibleTo(node.getDatatype()))) {
			addError("Expression of computed question '" + node.getIdentifier().getName() + "' is not of correct datatype");
			validDatatype = false;
		} else {
			validDatatype = true;
		}

		return validIdentifier && validExpression && validDatatype; 
	}

	@Override
	public Boolean visit(IfStatement node) {
		boolean validCondition = isValidBoolean(node.getExpression(), "if");
		boolean validStatements = node.getStatements().accept(this);
		return validCondition && validStatements;
	}
}
