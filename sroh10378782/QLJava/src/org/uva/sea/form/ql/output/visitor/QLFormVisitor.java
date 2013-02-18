package org.uva.sea.form.ql.output.visitor;

import java.awt.Color;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.uva.sea.ql.ast.expressions.Expr;
import org.uva.sea.ql.ast.nodes.statements.*;
import org.uva.sea.ql.ast.nodes.types.*;
import org.uva.sea.ql.ast.nodes.types.Float;
import org.uva.sea.ql.visitor.Visitor;

public class QLFormVisitor implements Visitor {
	
	JFrame formFrame = null;
	Container formContainer = null;
	
	@Override
	public void visit(Statement statement) {
		if(statement.isFormStatement()){
			Form form = (Form) statement;
			form.accept(this);
		}
	}
	
	@Override
	public void visit(Block block) {
		JPanel panel = new JPanel();
		panel.setBackground(Color.red);
		formContainer.add(panel);
		
		int counter = block.getValuesCount();
		for(int i = 0; i < counter; i++){
			Statement statement = block.getValue(i);
			if(statement.isQuestionStatement()){
				Question question = (Question)statement;
				question.accept(this);
			}
			/**
			if(statement.isConditionalStatement()) {
				ConditionalStatement conditionalStatement = (ConditionalStatement)statement;
				conditionalStatement.accept(this);
			}
			**/
		}
	}

	@Override
	public void visit(Question question) {
		// questions.add(question);
		Ident questionIdent = (Ident)question.getLhs();
		QuestionBody questionBody = (QuestionBody)question.getRhs();
		questionBody.accept(this);
		// types.put(questionIdent, tmpType);
	}

	@Override
	public void visit(Condition condition) {
		
	}

	@Override
	public void visit(ConditionalStatement conditionalStatement) {
		
	}

	@Override
	public void visit(Form form) {
		Ident key = (Ident)form.getLhs();
		formFrame = new JFrame();
		formFrame.setTitle(key.getValue());
		formFrame.setSize(400,400);
		formFrame.setLocationRelativeTo(null);
		formContainer = formFrame.getContentPane();
		// formFrame.setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
		Block block = (Block)form.getRhs();
		block.accept(this);
	}
	
	public JFrame getGeneratedForm(){
		return formFrame;
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
	
		@Override
	public void visit(Expr expr) {
		
	}

	@Override
	public void visit(Bool boolType) {
		
	}

	@Override
	public void visit(Int intType) {
		
	}

	@Override
	public void visit(Str strType) {
		
	}

	@Override
	public void visit(Float floatType) {
		
	}

	@Override
	public void visit(Money moneyType) {
		
	}	
}
