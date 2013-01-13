module lang::ql::compiler::PrettyPrinter

import lang::ql::ast::AST;
import lang::ql::util::Parse;
import lang::ql::util::Implode;

import IO;
import util::ValueUI;

private Form p(loc f) = implode(parse(readFile(f), |file:///-|));

public void main() {
  f = p(|project://QL-R-kemi/forms/uglyFormatted.q|);
  println("Form: <f>");
  pf = prettyPrint(f);
  println("Pretty: ");
  iprintln(pf);
  text(pf);
  writeFile(|tmp:///out|, pf);
  
  f2 = p(|tmp:///out|);
  println(f == f2);
}

// The root note of the form
public str prettyPrint(Form form) {
  return 
    "form <form.formName> { <for (e <- form.formElements) {>
    '  <prettyPrint(e)><}>
    '}
    '";
}

public str prettyPrint(Statement item: question(Question question)) = prettyPrint(question);

public str prettyPrint(Question q: 
  question(questionText, answerDataType, answerIdentifier)) {
  return
  "<questionText>
  '  <answerDataType> <answerIdentifier>";
}

public str prettyPrint(Question q: 
  question(questionText, answerDataType, answerIdentifier, calculatedField)) {
  return
  "<questionText>
  '  <answerDataType> <answerIdentifier> = <prettyPrint(calculatedField)>";
}

public str prettyPrint(Statement item: 
  ifCondition(Conditional ifPart, [], [])) {
  return 
    "if ( <prettyPrint(ifPart.condition)> ) { <for (e <- ifPart.body) {>
    '  <prettyPrint(e)><}>
    '}";
}

public str prettyPrint(Statement item: 
  ifCondition(Conditional ifPart, [], list[Statement] elsePart)) {
  return 
    "if ( <prettyPrint(ifPart.condition)> ) { <for (e <- ifPart.body) {>
    '  <prettyPrint(e)><}>
    '} else { <for (e <- elsePart) {>
    '  <prettyPrint(e)><}>
    '}";
}

public str prettyPrint(Statement item: 
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, [])) {
  return
    "if ( <prettyPrint(ifPart.condition)> ) { <for (e <- ifPart.body) {>
    '  <prettyPrint(e)><}> <for (elsePart <- elseIfs) {>
    '} elseif ( <prettyPrint(elsePart.condition)> ) { <for (ee <- elsePart.body) {>
    '  <prettyPrint(ee)><}><}>
    '}";
}

public str prettyPrint(Statement item: 
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[Statement] elsePart)) {
  return 
    "if ( <prettyPrint(ifPart.condition)> ) { <for (e <- ifPart.body) {>
    '  <prettyPrint(e)><}> <for (elseifPart <- elseIfs) {>
    '} elseif ( <prettyPrint(elseifPart.condition)> ) { <for (e <- elseifPart.body) {>
    '  <prettyPrint(e)><}><}>
    '} else { <for (e <- elsePart) {>
    '  <prettyPrint(e)><}>
    '}";
}

// And all Expr's to wrap up

public str prettyPrint(pos(Expr posValue)) {
  return "+<prettyPrint(posValue)>";
}

public str prettyPrint(neg(Expr negValue)) {
  return "-<prettyPrint(negValue)>)";
}

public str prettyPrint(not(Expr notValue)) {
  return "!<prettyPrint(notValue)>";
}

public str prettyPrint(mul(multiplicand, multiplier)) {
  return "<prettyPrint(multiplicand)> * <prettyPrint(multiplier)>";
}

public str prettyPrint(div(numerator, denominator)) {
  return "<prettyPrint(numerator)> / <prettyPrint(denominator)>";
}

public str prettyPrint(add(leftAddend, rightAddend)) {
  return "<prettyPrint(leftAddend)> + <prettyPrint(rightAddend)>";
}

public str prettyPrint(sub(minuend, subtrahend)) {
  return "<prettyPrint(minuend)> - <prettyPrint(subtrahend)>";
}

public str prettyPrint(lt(left, right)) {
  return "<prettyPrint(left)> \< <prettyPrint(right)>";
}

public str prettyPrint(leq(left, right)) {
  return "<prettyPrint(left)> \<= <prettyPrint(right)>";
}

public str prettyPrint(gt(left, right)) {
  return "<prettyPrint(left)> \> <prettyPrint(right)>";
}

public str prettyPrint(geq(left, right)) {
  return "<prettyPrint(left)> \>= <prettyPrint(right)>";
}

public str prettyPrint(eq(left, right)) {
  return "<prettyPrint(left)> == <prettyPrint(right)>";
}

public str prettyPrint(neq(left, right)) {
  return "<prettyPrint(left)> != <prettyPrint(right)>";
}

public str prettyPrint(and(left, right)) {
  return "<prettyPrint(left)> && <prettyPrint(right)>";
}

public str prettyPrint(or(left, right)) {
  return "<prettyPrint(left)> || <prettyPrint(right)>";
}

public str prettyPrint(ident(name)) {
  return "<name>";
}

public str prettyPrint(\int(intValue)) {
  return "<intValue>";
}

public str prettyPrint(money(moneyValue)) {
  return "<moneyValue>";
}

public str prettyPrint(boolean(booleanValue)) {
  return "<booleanValue>";
}

public str prettyPrint(date(dateValue)) {
  return "<dateValue>";
}

public str prettyPrint(string(text)) {
  return "<text>";
}
