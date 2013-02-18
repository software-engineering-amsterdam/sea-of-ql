package ast.statement;

import ast.Form;

public interface Visitor<T> {
	T visit(Assignment ast);
	T visit(Else ast);
	T visit(Form ast);
	T visit(If ast);
	T visit(QuestionVar ast);
	T visit(QuestionComputed ast);
	T visit(Var ast);
	T visit(Block ast);
}
