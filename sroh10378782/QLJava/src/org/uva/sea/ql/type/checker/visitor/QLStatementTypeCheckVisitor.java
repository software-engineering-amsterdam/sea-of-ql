package org.uva.sea.ql.type.checker.visitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.nodes.expressions.Ident;
import org.uva.sea.ql.ast.nodes.statements.Block;
import org.uva.sea.ql.ast.nodes.statements.ComputedQuestion;
import org.uva.sea.ql.ast.nodes.statements.Form;
import org.uva.sea.ql.ast.nodes.statements.IfThen;
import org.uva.sea.ql.ast.nodes.statements.IfThenElse;
import org.uva.sea.ql.ast.nodes.statements.Question;
import org.uva.sea.ql.ast.nodes.statements.Statement;
import org.uva.sea.ql.ast.statements.visitor.Visitor;
import org.uva.sea.ql.type.checker.QLErrorMessage;
import org.uva.sea.ql.types.Type;

public class QLStatementTypeCheckVisitor implements Visitor {
	
	private final Map<Ident, Type> typeEnv;
	private ArrayList<Question> questionDeclarations;
	private ArrayList<ComputedQuestion> computedQuestionDeclarations;
	
	private final List<QLErrorMessage> messages;
	
	private QLStatementTypeCheckVisitor(Map<Ident, Type> typeEnv, List<QLErrorMessage> messages) {
		this.typeEnv  = typeEnv;
		this.messages = messages;
		this.questionDeclarations = new ArrayList<Question>();
		this.computedQuestionDeclarations = new ArrayList<ComputedQuestion>();
	}
	
	public static void check(Statement statement, Map<Ident, Type> typeEnv, List<QLErrorMessage> errs) {
		QLStatementTypeCheckVisitor check = new QLStatementTypeCheckVisitor(typeEnv, errs);
		statement.accept(check);
	}
	
	private void addError(QLErrorMessage error){
		this.messages.add(error);
	}
	
	@Override
	public void visit(Form form) {
		Block block = form.getBlock();
		block.accept(this);
	}

	@Override
	public void visit(Block block) {
		List<Statement> statements = block.getValues();
		for(Statement stat : statements){
			stat.accept(this);
		}
	}

	@Override
	public void visit(Question question) {
		this.questionDeclarations.add(question);
		this.typeEnv.put(question.getIdent(),question.getType());
	}

	@Override
	public void visit(ComputedQuestion computedQuestion) {
		this.computedQuestionDeclarations.add(computedQuestion);
		this.typeEnv.put(computedQuestion.getIdent(),computedQuestion.getType());
		boolean check = QLExpressionTypeCheckVisitor.check(computedQuestion.getExpr(), typeEnv, messages);
		if(!check){
			addError(new QLErrorMessage("Computed Question: " + computedQuestion.getIdent().toString() + " Expr Type Check Failed"));
		}
	}

	@Override
	public void visit(IfThen ifThen) {
		boolean check = QLExpressionTypeCheckVisitor.check(ifThen.getCondition(), typeEnv, messages);
		if(!check){
			addError(new QLErrorMessage("IfThen Condition: Expr Type Check Failed"));
		}
		ifThen.getBlock().accept(this);
	}

	@Override
	public void visit(IfThenElse ifThenElse) {
		boolean check = QLExpressionTypeCheckVisitor.check(ifThenElse.getCondition(), typeEnv, messages);
		if(!check){
			addError(new QLErrorMessage("IfThenElse Condition: Expr Type Check Failed"));
		}
		ifThenElse.getIfBlock().accept(this);
		ifThenElse.getElseBlock().accept(this);
	}

	@Override
	public String toString() {
		return "QLStatementTypeCheckVisitor";
	}
}
