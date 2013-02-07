@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::PrettyPrinter

import Node;
import lang::ql::ast::AST;
import lang::ql::compiler::parentheses;

private str PAREN_ANNO = "parentheses";

public str prettyPrint(Form form) =
  "form <form.formName.ident> { <for(e <- form.formElements) {>
  '  <prettyPrint(e)><}>
  '}
  '";

public str prettyPrint(Statement item: question(Question question)) = 
  prettyPrint(question);

public str prettyPrint(Question q: 
    question(questionText, answerDataType, answerIdentifier)) =
  "<questionText.text>
  '  <answerDataType.name> <answerIdentifier.ident>";

public str prettyPrint(Question q: 
    question(questionText, answerDataType, answerIdentifier, cf)) =
  "<questionText.text>
  '  <answerDataType.name> <answerIdentifier.ident> = <prettyPrint(cf)>";

public str prettyPrint(Statement item: 
    ifCondition(Conditional ifPart, list[Conditional] elseIfs, 
    list[ElsePart] elsePart)) = 
    "if(<prettyPrint(ifPart.condition)>) { <for(e <- ifPart.body) {>
    '  <prettyPrint(e)><}><for(ei <- elseIfs) { >
    '} else if(<prettyPrint(ei.condition)>) { <for(e <- ei.body) {>
    '  <prettyPrint(e)><}><}><for(ep <- elsePart) { >
    '} else { <for(e <- ep.body) {>
    '  <prettyPrint(e)><}><}>
    '}";
    
public str prettyPrint(Expr e) =
  prettyPrintParen(parenExpr(e));

private str parenPrint(Expr p, str print) {
  if(PAREN_ANNO in getAnnotations(p)) {
    return "(<print>)";
  } else {
    return print;
  }
}    

private str prettyPrintParen(p:pos(Expr posValue)) = 
  parenPrint(p, "+<prettyPrintParen(posValue)>");

private str prettyPrintParen(p:neg(Expr negValue)) =
  parenPrint(p, "-<prettyPrintParen(negValue)>");

private str prettyPrintParen(p:not(Expr notValue)) =
  parenPrint(p, "!<prettyPrintParen(notValue)>");

private str prettyPrintParen(p:mul(multiplicand, multiplier)) =
  parenPrint(p, "<prettyPrintParen(multiplicand)> * <prettyPrintParen(multiplier)>");

private str prettyPrintParen(p:div(numerator, denominator)) =
  parenPrint(p, "<prettyPrintParen(numerator)> / <prettyPrintParen(denominator)>");

private str prettyPrintParen(p:add(leftAddend, rightAddend)) =
  parenPrint(p, "<prettyPrintParen(leftAddend)> + <prettyPrintParen(rightAddend)>");

private str prettyPrintParen(p:sub(minuend, subtrahend)) =
  parenPrint(p, "<prettyPrintParen(minuend)> - <prettyPrintParen(subtrahend)>");

private str prettyPrintParen(p:lt(left, right)) =
  parenPrint(p, "<prettyPrintParen(left)> \< <prettyPrintParen(right)>");

private str prettyPrintParen(p:leq(left, right)) =
  parenPrint(p, "<prettyPrintParen(left)> \<= <prettyPrintParen(right)>");

private str prettyPrintParen(p:gt(left, right)) =
  parenPrint(p, "<prettyPrintParen(left)> \> <prettyPrintParen(right)>");

private str prettyPrintParen(p:geq(left, right)) =
  parenPrint(p, "<prettyPrintParen(left)> \>= <prettyPrintParen(right)>");

private str prettyPrintParen(p:eq(left, right)) =
  parenPrint(p, "<prettyPrintParen(left)> == <prettyPrintParen(right)>");

private str prettyPrintParen(p:neq(left, right)) =
  parenPrint(p, "<prettyPrintParen(left)> != <prettyPrintParen(right)>");

private str prettyPrintParen(p:and(left, right)) =
  parenPrint(p, "<prettyPrintParen(left)> && <prettyPrintParen(right)>");

private str prettyPrintParen(p:or(left, right)) =
  parenPrint(p, "<prettyPrintParen(left)> || <prettyPrintParen(right)>");

private str prettyPrintParen(ident(name)) =
  "<name>";

private str prettyPrintParen(\int(intValue)) =
  "<intValue>";

private str prettyPrintParen(money(moneyValue)) =
  "<moneyValue>";

private str prettyPrintParen(boolean(booleanValue)) =
  "<booleanValue>";

private str prettyPrintParen(date(dateValue)) =
  "<dateValue>";

private str prettyPrintParen(string(text)) =
  "<text>";
