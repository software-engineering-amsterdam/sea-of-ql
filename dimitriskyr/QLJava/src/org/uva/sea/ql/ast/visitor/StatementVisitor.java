package org.uva.sea.ql.ast.visitor;

import java.util.List;
import java.util.Map;

import org.uva.sea.ql.ast.Expr;
import org.uva.sea.ql.ast.Form;
import org.uva.sea.ql.ast.Statement;
import org.uva.sea.ql.ast.Type;
import org.uva.sea.ql.ast.statements.Block;
import org.uva.sea.ql.ast.statements.ComQuestion;
import org.uva.sea.ql.ast.statements.IfThen;
import org.uva.sea.ql.ast.statements.IfThenElse;
import org.uva.sea.ql.ast.statements.QuestionElement;
import org.uva.sea.ql.ast.statements.SimpleQuestion;
import org.uva.sea.ql.ast.statements.StatementElement;
import org.uva.sea.ql.ast.values.Ident;

public class StatementVisitor implements IStatementVisitor {

	private final Map<Ident, Type> typeEnv;
	private final List<String> errormessages;
	
	public StatementVisitor(Map<Ident, Type> tenv, List<String> messages) {
	this.typeEnv = tenv;
	this.errormessages = messages;
	}
	
	public List<String> getErrormessages() {
		return errormessages;
	}
	
	@Override
	public void visit(Form form) {
		form.getBlock().accept(this);
	}
	
	@Override
	public void visit(Block block) {
		for(Statement formBody : block.getBody()){
			formBody.accept(this);
		}
	}

	@Override
	public void visit(QuestionElement questionElement) {
	// TODO Auto-generated method stub
	
	}

	@Override
	public void visit(StatementElement statementElement) {
		// TODO Auto-generated method stub
	
	}

	@Override
	public void visit(IfThen ifthen) {
	checkCondition(ifthen);
	ifthen.getIfBlock().accept(this);
	}  

	@Override
	public void visit(IfThenElse ifThenElse) {
	checkCondition(ifThenElse);
	ifThenElse.getIfBlock().accept(this);
	ifThenElse.getElseBlock().accept(this);
	}
	
	@Override
	public void visit(SimpleQuestion simpleQuestion) {
	checkName(simpleQuestion, simpleQuestion.getType());
	}

	@Override
	public void visit(ComQuestion comQuestions) {
	checkName(comQuestions, comQuestions.getExpression().typeOf(typeEnv));
	checkExpr(comQuestions, comQuestions.getExpression());
	}

private void checkName(QuestionElement question, Type type) {
	Ident questionId= question.getIdent();
	Type questionType= type;
	if(typeEnv.containsKey(questionId)){
		errormessages.add("The name" + questionId + "is invalid because it has already been declared");
	}
	typeEnv.put(questionId, questionType);
}

private void checkExpr(QuestionElement comQuestions, Expr expression) {
	Type questionType = comQuestions.getType();
	Type expressionType = expression.typeOf(typeEnv);
	CheckExpr.check(expression,typeEnv,errormessages);
	
	if (!(questionType.isCompatibleTo(expressionType))){
		errormessages.add("Error. The type of the question("+ questionType +") is different than the type of the expression("+ expressionType +")");
		}
	}
	
	private void checkCondition(StatementElement statement) {
		Expr expr= statement.getExpression();
		CheckExpr.check(expr,typeEnv,errormessages);
		if(!(expr.typeOf(typeEnv).isCompatibleToBoolean())){
			errormessages.add("Wrong type (" + expr.typeOf(typeEnv) + "). The expression should be of type Boolean" );
		}
	}
}
	