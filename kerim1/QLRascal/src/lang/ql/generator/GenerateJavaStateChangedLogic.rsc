module lang::ql::generator::GenerateJavaStateChangedLogic

import List;
import lang::ql::ast::AST;
import lang::ql::ast::TypeEnvironment;

import lang::ql::generator::GenerateJava;
import lang::ql::generator::GenerateJavaExpressions;

public str generateStateChangedLogic(Form form, TypeEnv env) {
	str out = "";
	
	visit (form) {
		case Statement s:ifThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart):
			out += generateIfThenElseLogic(condition, thenPart, elseIfs, elsePart, s@id, env);
  		case Statement s:ifThen(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs):
  			out += generateIfThenElseLogic(condition, thenPart, elseIfs, [], s@id, env);
		case Question q:computed(_, _, _, _): 
			out += generateComputedLogic(q, env);
	}
	
	return out;
}

str generateComputedLogic(computed(str identifier, _, intType(), Expr expression), TypeEnv env) = 
	"<identifier>Model.setValue(<generateExpr(expression, env)>.intValue());";
	
str generateComputedLogic(computed(str identifier, _, boolType(), Expr expression), TypeEnv env) = 
	"<identifier>Question.setSelected(<generateExpr(expression, env)>.booleanValue());";

str generateComputedLogic(computed(str identifier, _, stringType(), Expr expression), TypeEnv env) = 
	"<identifier>Question.setText(<generateExpr(expression, env)>);";

str generateIfThenElseLogic(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart, str id, TypeEnv env) {
	str out = 	"
				'if<id>.setVisible(false);\n";
	
	for (ElseIf elseIf <- elseIfs) {
		out += "elseIf<elseIf@id>.setVisible(false);\n";
	}
	
	if (!isEmpty(elsePart)) {
		out += "else<id>.setVisible(false);\n";
	}
	
	out += 	"if (<generateExpr(condition, env)>.booleanValue()) {
			'	if<id>.setVisible(true);
			'}\n";
			
	for (ElseIf elseIf <- elseIfs) {
		out +=	"else if (<generateExpr(elseIf.condition, env)>.booleanValue()) {
				'	elseIf<elseIf@id>.setVisible(true);
				'}\n";
	}
	
	if (!isEmpty(elsePart)) {
		out +=	"else {
				'	else<id>.setVisible(true);
				'}";
	}
	
	return out;
}