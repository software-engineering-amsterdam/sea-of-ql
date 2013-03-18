package org.uva.sea.ql.visitor;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.expression.Add;
import org.uva.sea.ql.ast.expression.And;
import org.uva.sea.ql.ast.expression.BinaryExpression;
import org.uva.sea.ql.ast.expression.Div;
import org.uva.sea.ql.ast.expression.Eq;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.ExpressionVisitor;
import org.uva.sea.ql.ast.expression.GEq;
import org.uva.sea.ql.ast.expression.GT;
import org.uva.sea.ql.ast.expression.Identifier;
import org.uva.sea.ql.ast.expression.LEq;
import org.uva.sea.ql.ast.expression.LT;
import org.uva.sea.ql.ast.expression.Mul;
import org.uva.sea.ql.ast.expression.NEq;
import org.uva.sea.ql.ast.expression.Neg;
import org.uva.sea.ql.ast.expression.Not;
import org.uva.sea.ql.ast.expression.Or;
import org.uva.sea.ql.ast.expression.Pos;
import org.uva.sea.ql.ast.expression.Sub;
import org.uva.sea.ql.ast.expression.UnaryExpression;
import org.uva.sea.ql.ast.expression.literal.BooleanLiteral;
import org.uva.sea.ql.ast.expression.literal.IntLiteral;
import org.uva.sea.ql.ast.expression.literal.TextLiteral;
import org.uva.sea.ql.ast.statement.CompoundStatement;
import org.uva.sea.ql.ast.statement.Form;
import org.uva.sea.ql.ast.statement.IfElseStatement;
import org.uva.sea.ql.ast.statement.IfStatement;
import org.uva.sea.ql.ast.statement.Label;
import org.uva.sea.ql.ast.statement.Question;
import org.uva.sea.ql.ast.statement.Statement;
import org.uva.sea.ql.ast.statement.StatementVisitor;
import org.uva.sea.ql.ast.type.AnyType;
import org.uva.sea.ql.ast.type.BooleanType;
import org.uva.sea.ql.ast.type.NumericType;
import org.uva.sea.ql.ast.type.Type;
import org.uva.sea.ql.ast.type.UndefType;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class TypeCheckVisitor implements ExpressionVisitor<Boolean>, StatementVisitor<Void> {

	private final Map<Identifier, Type> typeEnv;

	private final List<TypeCheckError> errorList = Lists.newArrayList();
	
	public TypeCheckVisitor(){
		typeEnv = Maps.newHashMap();
	}
	
	public TypeCheckVisitor(final Map<Identifier, Type> typeEnv){
		this.typeEnv = typeEnv;
	}

	public boolean hasTypeCheckErrors() {
		return !errorList.isEmpty();
	}

	public Iterator<TypeCheckError> getTypeCheckErrorIterator() {
		return this.errorList.iterator();
	}

	@Override
	public Boolean visit(Identifier identifier) {
		Type type = identifier.typeOf(typeEnv);
		if(new UndefType().equals(type)){
			newTypeCheckError("Identifier '"+identifier.getName()+"' is undefined.");
			return false;
		}
		return true;
	}

	@Override
	public Boolean visit(BooleanLiteral literal) {
		return true;
	}

	@Override
	public Boolean visit(IntLiteral literal) {
		return true;
	}

	@Override
	public Boolean visit(TextLiteral literal) {
		return true;
	}

	@Override
	public Boolean visit(Add expression) {
		return visitBinaryExpression(expression, "Addition", new NumericType());
	}

	@Override
	public Boolean visit(Div expression) {
		return visitBinaryExpression(expression, "Division", new NumericType());
	}

	@Override
	public Boolean visit(Mul expression) {
		return visitBinaryExpression(expression, "Multiplication", new NumericType());
	}

	@Override
	public Boolean visit(Sub expression) {
		return visitBinaryExpression(expression, "Subtraction", new NumericType());
	}

	@Override
	public Boolean visit(And expression) {
		return visitBinaryExpression(expression, "And", new BooleanType());
	}

	@Override
	public Boolean visit(Eq expression) {
		return visitBinaryExpression(expression, "Equals", new AnyType());
	}

	@Override
	public Boolean visit(GEq expression) {
		return visitBinaryExpression(expression, "GreaterEquals", new NumericType());
	}

	@Override
	public Boolean visit(LEq expression) {
		return visitBinaryExpression(expression, "LesserEquals", new NumericType());
	}

	@Override
	public Boolean visit(GT expression) {
		return visitBinaryExpression(expression, "GreaterThan", new NumericType());
	}

	@Override
	public Boolean visit(LT expression) {
		return visitBinaryExpression(expression, "LesserThan", new NumericType());
	}

	@Override
	public Boolean visit(NEq expression) {
		return visitBinaryExpression(expression, "NotEquals", new AnyType());
	}

	@Override
	public Boolean visit(Or expression) {
		return visitBinaryExpression(expression, "Or", new BooleanType());
	}

	@Override
	public Boolean visit(Neg expression) {
		return visitUnaryExpression(expression, "Negative", new NumericType());
	}

	@Override
	public Boolean visit(Pos expression) {
		return visitUnaryExpression(expression, "Positive", new NumericType());
	}

	@Override
	public Boolean visit(Not expression) {
		return visitUnaryExpression(expression, "Not", new BooleanType());
	}
	
	@Override
	public Void visit(Form form) {
		form.getCompoundStatement().accept(this);
		return null;
	}

	@Override
	public Void visit(CompoundStatement statement) {
		Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			statementIterator.next().accept(this);
		}
		return null;
	}

	@Override
	public Void visit(Question question) {
		typeEnv.put(question.getIdent(), question.getType());
		return null;
	}

	@Override
	public Void visit(Label label) {
		final Iterator<Expression> expressionIterator = label.getExpressions();
		while(expressionIterator.hasNext()){
			expressionIterator.next().accept(this);
		}
		return null;
	}

	@Override
	public Void visit(IfStatement statement) {
		final boolean exprOk = statement.getExpression().accept(this);

		final Type type = statement.getExpression().typeOf(typeEnv);
		// only check compatibility with boolean type when expression is ok
		if (exprOk && !type.isCompatibleToBoolean()) {
			newTypeCheckError("Expression in if-statement is not compatible to boolean.");
		}
		
		statement.getStatement().accept(this);
		return null;
	}

	@Override
	public Void visit(IfElseStatement statement) {
		// first visit as it was a normal ifstatement
		this.visit((IfStatement)statement);
		// now only visit the else statement
		statement.getElseStatement().accept(this);
		return null;
	}
	
	private void newTypeCheckError(String errorMessage) {
		errorList.add(new TypeCheckError(errorMessage));
	}
	
	
	private boolean visitBinaryExpression(final BinaryExpression expression, final String expressionName, final Type supportedOperandType) {
		final boolean lhsOk = expression.getLhs().accept(this);
		final boolean rhsOk = expression.getRhs().accept(this);
		
		if(!(lhsOk && rhsOk)){
			return false;
		}
		
		final Type lhsType = expression.getLhs().typeOf(typeEnv);
		final Type rhsType = expression.getRhs().typeOf(typeEnv);
		
		if(lhsType.isCompatibleTo(rhsType) == false){
			newTypeCheckError("Left-hand-side expression of " + expressionName + " is not compatible to right-hand-side expression");
			return false;
		}
		
		boolean isOk = true;
		if (lhsType.isCompatibleTo(supportedOperandType) == false) {
			newTypeCheckError("Left-hand-side expression of " + expressionName + " is not compatible to " + supportedOperandType);
			isOk = false;
		}
		if (rhsType.isCompatibleTo(supportedOperandType) == false) {
			newTypeCheckError("Right-hand-side expression of " + expressionName + " is not compatible to " + supportedOperandType);
			isOk = false;
		}

		return isOk;
	}
	
	private boolean visitUnaryExpression(final UnaryExpression expression, final String expressionName, final Type supportedOperandType) {
		final boolean exprOk = expression.getExpr().accept(this);
		
		if(!exprOk){
			return false;
		}
		
		final Type exprType = expression.getExpr().typeOf(typeEnv);
		
		if (exprType.isCompatibleTo(supportedOperandType) == false) {
			newTypeCheckError("Operand expression of " + expressionName + " is not compatible to " + supportedOperandType);
			return false;
		}
		
		return true;
	}

}