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
		//TODO: make message: '<variable-name or datatype-name>' is an invalid datatype for '<token>'
		return "Invalid datatype for " + (handSide != null ? handSide + " part of " : "") + "'" + token + "'";
	}

	private boolean isValidExpression(Expression expression) {
		return expression.accept(this);
	}
	
	private boolean isValidInteger(Expression expression, String token) {
		return isValidInteger(expression, token, null);
	}

	private boolean isValidInteger(Expression lhs, Expression rhs, String token) {
		return isValidInteger(lhs, token, "left") &&
				isValidInteger(rhs, token, "right");
	}

	private boolean isValidInteger(Expression expression, String token, String handSide) {
		// check if the expression is valid
		if (isValidExpression(expression)) {
			Datatype datatype = expression.typeOf(symbols);
			//TODO: only an error message when datatype != null (otherwise invalid identifiers also generate an error?)
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
		return isValidBoolean(lhs, token, "left") &&
				isValidBoolean(rhs, token, "right");
	}

	private boolean isValidBoolean(Expression expression, String token, String handSide) {
		// check if the expression is valid
		if (isValidExpression(expression)) {
			Datatype datatype = expression.typeOf(symbols);
			//TODO: only an error message when datatype != null (otherwise invalid identifiers also generate an error?)
			if ((datatype != null) && (datatype.isCompatibleToBoolean())) {
				return true;
			}
			addError(makeError(token, handSide));
		}
		return false;
	}

	private boolean areEqualityDatatypes(Expression lhs, Expression rhs, String token) {
		if (isValidExpression(lhs) && isValidExpression(rhs)) {
			Datatype lhsDatatype = lhs.typeOf(symbols);
			Datatype rhsDatatype = rhs.typeOf(symbols);
			
			//TODO: only an error message when datatype != null (otherwise invalid identifiers also generate an error?)
			// check if lefthandside and righthandside are the same datatypes
			if ((lhsDatatype != null) && (rhsDatatype != null) && (lhsDatatype.isCompatibleTo(rhsDatatype))) {
				return true;
			}
//			if ((lhsDatatype.isCompatibleToString() && rhsDatatype.isCompatibleToString())
//					|| (lhsDatatype.isCompatibleToInteger() && rhsDatatype.isCompatibleToInteger())
//					|| (lhsDatatype.isCompatibleToBoolean() && rhsDatatype.isCompatibleToBoolean())) {
//				return true;
//			}

			//TODO: add specifi error eg. "datatypes are not the same type for '=='
			addError(makeError(token));
		}
		return false;
	}

	private boolean areRelationalDatatypes(Expression lhs, Expression rhs, String token) {
		if (isValidExpression(lhs) && isValidExpression(rhs)) {
			Datatype lhsDatatype = lhs.typeOf(symbols);
			Datatype rhsDatatype = rhs.typeOf(symbols);
			
			//TODO: only an error message when datatype != null (otherwise invalid identifiers also generate an error?)
			// check if lefthandside and righthandside are the same datatypes for a relational expression
			if ((lhsDatatype != null) && (rhsDatatype != null)) {
				if ((lhsDatatype.isCompatibleToString() && rhsDatatype.isCompatibleToString()) ||
					(lhsDatatype.isCompatibleToInteger() && rhsDatatype.isCompatibleToInteger())) {
					return true;
				}
				//TODO: add specifi error eg. "datatypes are not the same type for '=='
				addError(makeError(token));
			}
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
	public Boolean visit(Form node) {
		//TODO: check identifier?? add identifier?
		return node.getStatements().accept(this);
	}

	@Override
	public Boolean visit(StatementList node) {
		//TODO: or quit as soon as 'false' is found
		boolean result = true;
		for (Statement e : node.getList()) {
			result = result && e.accept(this);
		}
		return result;
	}

	//TODO: make this method return true/false
	private boolean addQuestionIdentifier(Identifier identifier, Datatype datatype) {
		if (symbols.contains(identifier.getName())) {
			addError("Question identifier '" + identifier.getName() + "' already defined");
			return false;
		}
		symbols.put(identifier.getName(), datatype);
		return true;
	}
	
	@Override
	public Boolean visit(Question node) {
		return addQuestionIdentifier(node.getIdentifier(), node.getDatatype());
	}

	@Override
	public Boolean visit(ComputedQuestion node) {
		if (!addQuestionIdentifier(node.getIdentifier(), node.getDatatype())) {
			return false;
		}
		if (!isValidExpression(node.getExpression())) {
			return false;
		}
		// check if expression of computed question is same datatype as question identifier
		Datatype exprDatatype = node.getExpression().typeOf(symbols);
		if (!exprDatatype.isCompatibleTo(node.getDatatype())) {
			addError("Expression of computed question '" + node.getIdentifier().getName() + "' is not of correct datatype");
			return false;
		}

		//TODO: check if expression uses question identifier (not allowed!)
		return true;
	}

	@Override
	public Boolean visit(IfStatement node) {
		return isValidBoolean(node.getExpression(), "if") &&
				node.getStatements().accept(this);
	}
}
