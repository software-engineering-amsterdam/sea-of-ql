module lang::ql::generator::Pretty

import lang::ql::ast::AST;

public str pretty(form(str name, list[Statement] body)) = 
	"form <name> { <for (s <- body) {>
	'	<pretty(s)><}>
	'}";

public str pretty(question(Question question)) = pretty(question);
 
public str pretty(ifThenElse(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs, list[Statement] elsePart)) =
	"
	'if <pretty(condition)> { <for (s <- thenPart) {>
	'	<pretty(s)><}>
	'} <for (elseIf <- elseIfs) {>
 	'<pretty(elseIf)><}>
 	'else { <for (s <- elsePart) {>
 	'	<pretty(s)><}>
 	'}";
 
public str pretty(ifThen(Expr condition, list[Statement] thenPart, list[ElseIf] elseIfs)) = 
	"
	'if <pretty(condition)> { <for (s <- thenPart) {>
 	'	<pretty(s)><}>
 	'} <for (elseIf <- elseIfs) {>
 	'<pretty(elseIf)><}>";
 
public str pretty(elseIf(Expr condition, list[Statement] thenPart)) = 
	"else if <pretty(condition)> { <for (s <- thenPart) {>
	'	<pretty(s)><}>
	'}";

public str pretty(computed(str identifier, str label, Type tp, Expr expression)) = "<identifier>: <label> <pretty(tp)> <pretty(expression)>";

public str pretty(noncomputed(str identifier, str label, Type tp)) = "<identifier>: <label> <pretty(tp)>";

public str pretty(intType()) = "int";
public str pretty(boolType()) = "bool";
public str pretty(stringType()) = "string";

public str pretty(ident(str name)) = name;
public str pretty(\int(int integer)) = "<integer>";
public str pretty(\bool(bool boolean)) = "<boolean>";
public str pretty(string(str string)) = string;
public str pretty(pos(Expr val)) = "+<pretty(val)>";
public str pretty(neg(Expr val)) = "-<pretty(val)>";
public str pretty(not(Expr val)) = "!<pretty(val)>";
public str pretty(mul(Expr lhs, Expr rhs)) = "(<pretty(lhs)> * <pretty(rhs)>)";
public str pretty(div(Expr lhs, Expr rhs)) = "(<pretty(lhs)> / <pretty(rhs)>)";
public str pretty(add(Expr lhs, Expr rhs)) = "(<pretty(lhs)> + <pretty(rhs)>)";
public str pretty(sub(Expr lhs, Expr rhs)) = "(<pretty(lhs)> - <pretty(rhs)>)";
public str pretty(lt(Expr lhs, Expr rhs)) = "(<pretty(lhs)> \< <pretty(rhs)>)";
public str pretty(leq(Expr lhs, Expr rhs)) = "(<pretty(lhs)> \<= <pretty(rhs)>)";
public str pretty(gt(Expr lhs, Expr rhs)) = "(<pretty(lhs)> \> <pretty(rhs)>)";
public str pretty(geq(Expr lhs, Expr rhs)) = "(<pretty(lhs)> \>= <pretty(rhs)>)";
public str pretty(eq(Expr lhs, Expr rhs)) = "(<pretty(lhs)> == <pretty(rhs)>)";
public str pretty(neq(Expr lhs, Expr rhs)) = "(<pretty(lhs)> != <pretty(rhs)>)";
public str pretty(and(Expr lhs, Expr rhs)) = "(<pretty(lhs)> && <pretty(rhs)>)";
public str pretty(or(Expr lhs, Expr rhs)) = "(<pretty(lhs)> || <pretty(rhs)>)";
 