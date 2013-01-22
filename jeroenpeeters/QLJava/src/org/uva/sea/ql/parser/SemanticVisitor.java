package org.uva.sea.ql.parser;

import java.util.HashMap;
import java.util.Iterator;

import org.uva.sea.ql.ast.CompoundStatement;
import org.uva.sea.ql.ast.DataType;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.IfStatement;
import org.uva.sea.ql.ast.Question;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.expression.BinaryExpr;
import org.uva.sea.ql.ast.expression.BooleanExpression;
import org.uva.sea.ql.ast.expression.Expression;
import org.uva.sea.ql.ast.expression.Ident;
import org.uva.sea.ql.ast.expression.Literal;
import org.uva.sea.ql.ast.expression.UnaryExpr;

public class SemanticVisitor implements ASTVisitor {
	
	private final HashMap<Ident, Question> identQuestionMap = new HashMap<>();
	private final HashMap<Expression, DataType> expressionTypeMap = new HashMap<>();

	@Override
	public void visit(Form form) throws SemanticException {
		form.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(CompoundStatement statement) throws SemanticException {
		Iterator<Statement> statementIterator = statement.getStatementIterator();
		while(statementIterator.hasNext()){
			statementIterator.next().accept(this);
		}
	}

	@Override
	public void visit(Question question) throws SemanticException {
		identQuestionMap.put(question.getIdent(), question);
	}

	@Override
	public void visit(IfStatement statement) throws SemanticException {
		statement.getExpression().accept(this);
		
		checkCast(DataType.BOOLEAN, expressionTypeMap.get(statement.getExpression()));
		
		statement.getCompoundStatement().accept(this);
	}

	@Override
	public void visit(BinaryExpr expression) throws SemanticException {
		expression.getLhs().accept(this);
		expression.getRhs().accept(this);
		
		final DataType lhsType = expressionTypeMap.get(expression.getLhs());
		final DataType rhsType = expressionTypeMap.get(expression.getRhs());
		
		checkCast(lhsType, rhsType);
		
		expressionTypeMap.put(expression, expression instanceof BooleanExpression ? DataType.BOOLEAN : expressionTypeMap.get(expression.getLhs()));
	}

	@Override
	public void visit(final UnaryExpr expression) throws SemanticException {
		expression.getExpr().accept(this);
		
		if(expression instanceof BooleanExpression){
			checkCast(DataType.BOOLEAN, expressionTypeMap.get(expression.getExpr()));
			
		}
		expressionTypeMap.put(expression, expressionTypeMap.get(expression.getExpr()));
	}

	@Override
	public void visit(final Ident ident) throws SemanticException {
		if(!this.identQuestionMap.containsKey(ident)){
			throw new SemanticException("Undeclared referenced identity '" + ident.getName() + "'");
		}
		
		expressionTypeMap.put(ident, identQuestionMap.get(ident).getDataType());
	}

	@Override
	public void visit(final Literal literal) throws SemanticException {
		expressionTypeMap.put(literal, literal.getDataType());
	}
	
	private void checkCast(final DataType type1, final DataType type2) throws SemanticException{
		if(type1 == type2){
			return;
		}
		if(isNumeric(type1) && isNumeric(type2)){
			return;
		}
		throw new SemanticException(type2 + " not castable to " + type1);
	}
	
	
	private boolean isNumeric(final DataType type){
		return type == DataType.INTEGER || type == DataType.MONEY;
	}
	
}