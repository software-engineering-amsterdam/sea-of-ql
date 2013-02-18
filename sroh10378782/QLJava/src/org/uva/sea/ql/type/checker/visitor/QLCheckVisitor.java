package org.uva.sea.ql.type.checker.visitor;

import java.util.ArrayList;
import java.util.HashMap;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.nodes.statements.*;
import org.uva.sea.ql.ast.nodes.types.*;
import org.uva.sea.ql.ast.nodes.types.Float;
import org.uva.sea.ql.type.checker.QLTypeCheckError;
import org.uva.sea.ql.visitor.Visitor;

public class QLCheckVisitor implements Visitor {
	
	private ArrayList<Block> blocks = new ArrayList<Block>();
	private ArrayList<Question> questions = new ArrayList<Question>();
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
	private ArrayList<QLTypeCheckError> errors = new ArrayList<QLTypeCheckError>();
	
	private HashMap<Ident,Form> forms = new HashMap<Ident, Form>();
	private HashMap<Ident,Type> types = new HashMap<Ident, Type>();
	// private HashMap<Type,Expr> computations = new HashMap<Type, Expr>();
	
	private int lineNumber = 0;
	private Type tmpType = null;
	
	@Override
	public void visit(Statement statement) {
		if(statement.isFormStatement()){
			this.incrementInternalLineNumber();
			Form form = (Form) statement;
			form.accept(this);
		} else {
			this.errors.add(new QLTypeCheckError("No Form entry found !", this.lineNumber));
		}
	}
	
	@Override
	public void visit(Block block) {
		this.incrementInternalLineNumber();
		blocks.add(block);
		int counter = block.getValuesCount();
		for(int i = 0; i < counter; i++){
			this.incrementInternalLineNumber();
			Statement statement = block.getValue(i);
			boolean handled = false;
			if(statement.isQuestionStatement()){
				Question question = (Question)statement;
				question.accept(this);
				handled = true;
			}
			if(statement.isConditionalStatement()) {
				ConditionalStatement conditionalStatement = (ConditionalStatement)statement;
				conditionalStatement.accept(this);
				handled = true;
			}
			
			if(!handled){
				this.errors.add(new QLTypeCheckError("No suitable Block entry found !", this.lineNumber));
			}
		}
	}

	@Override
	public void visit(Question question) {
		questions.add(question);
		Ident questionIdent = (Ident)question.getLhs();
		QuestionBody questionBody = (QuestionBody)question.getRhs();
		questionBody.accept(this);
		types.put(questionIdent, tmpType);
	}

	@Override
	public void visit(Condition condition) {
		conditions.add(condition);
	}

	@Override
	public void visit(ConditionalStatement conditionalStatement) {
		Condition condition = (Condition)conditionalStatement.getLhs();
		condition.accept(this);
		Block block = (Block)conditionalStatement.getRhs();
		block.accept(this);
	}

	@Override
	public void visit(Form form) {
		Ident key = (Ident)form.getLhs();
		forms.put(key, form);
		Block block = (Block)form.getRhs();
		block.accept(this);
	}

	@Override
	public void visit(QuestionBody questionBody) {
		Type temporaryType = (Type)questionBody.getRhs();
		if(temporaryType.isBoolType()){
			Bool boolType = (Bool)temporaryType;
			boolType.accept(this);
		}
		if(temporaryType.isFloatType()){
			Float floatType = (Float)temporaryType;
			floatType.accept(this);
		}
		if(temporaryType.isIntType()){
			Int intType = (Int)temporaryType;
			intType.accept(this);
		}
		if(temporaryType.isMoneyType()){
			Money moneyType = (Money)temporaryType;
			moneyType.accept(this);
		}
		if(temporaryType.isStrType()){
			Str strType = (Str)temporaryType;
			strType.accept(this);
		}
		if(temporaryType.isIdentType()){
			Ident identType = (Ident)temporaryType;
			identType.accept(this);
		}
	}
	
	private void incrementInternalLineNumber(){
		this.lineNumber++;
	}

	@Override
	public void visit(Expr expr) {
		
	}

	@Override
	public void visit(Bool boolType) {
		
		if(boolType.isComputatedType()){
			Expr expr = boolType.getExpr();
			expr.accept(this);
		} else {
			System.out.print("Simple Bool found \n");
			tmpType = boolType;
		}
	}

	@Override
	public void visit(Int intType) {
		if(intType.isComputatedType()){
			Expr expr = intType.getExpr();
			expr.accept(this);
		} else {
			tmpType = intType;
		}
	}

	@Override
	public void visit(Str strType) {
		tmpType = strType;
	}

	@Override
	public void visit(Float floatType) {
		if(floatType.isComputatedType()){
			Expr expr = floatType.getExpr();
			expr.accept(this);
		} else {
			tmpType = floatType;
		}
	}

	@Override
	public void visit(Money moneyType) {
		if(moneyType.isComputatedType()){
			Expr expr = moneyType.getExpr();
			expr.accept(this);
		} else {
			tmpType = moneyType;
		}
	}	
}
