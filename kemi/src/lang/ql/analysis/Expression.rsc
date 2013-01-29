module lang::ql::analysis::Expression

import Node;
import Set;
import lang::ql::analysis::State;
import lang::ql::ast::AST;
import util::IDE;

import IO;
import util::ValueUI;

private Type i() = integerType("integer");
private Type m() = moneyType("money");
private Type b() = booleanType("boolean");
private Type d() = dateType("date");
private Type s() = stringType("string");
private Type err() = invalidType("invalid");

private alias Types = map[str, set[Type]];

public set[Message] analyzeAssignmentExpression(SAS sas, Type \type, Expr expression) {
  types = (key.ident : {sas.definitions[key]} | key <- sas.definitions) + typesByOperator;
  <t, messages> = analyze(types, expression);
  if(t != \type) {
    return messages += {invalidAssignmentMessage(\type, t, expression@location)};
  }
  return messages;
}

private map[str, set[Type]] typesByOperator = (
  "int": {i()}, 
  "money": {m()},
  "boolean": {b()},
  "date": {d()},
  "string": {s()},
  
  "pos": {i(), m()},
  "neg": {i(), m()},
  "not": {b()},
  
  "mul": {i(), m()},
  "div": {i(), m()},
  "add": {i(), m()},
  "sub": {i(), m()},
  
  "lt": {i(), m(), d(), s()},
  "leq": {i(), m(), d(), s()},
  "gt": {i(), m(), d(), s()},
  "geq": {i(), m(), d(), s()},
  "eq": {i(), m(), b(), d(), s()},
  "neq": {i(), m(), b(), d(), s()},
  
  "and": {b()},
  "or": {b()}
);
  
private Message invalidAssignmentMessage(Type decl, Type eval, \loc) 
  = error("Declared type is <decl.name>, evaluates to <eval.name>.", \loc);

private Message invalidTypeMessage(loc \loc) 
  = error("Invalid types in expression.", \loc);
  
private Message undeclaredIdentifierMessage(loc \loc) 
  = error("Identifier undeclared.", \loc);

private tuple[Type, set[Message]] analyze(Types types, Expr e: pos(Expr posValue)) {
  throw "pos() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: neg(Expr negValue)) {
  throw "neg() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: not(Expr notValue)) {
  throw "not() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: lt(Expr left, Expr right)) {
  throw "lt() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: leq(Expr left, Expr right)) {
  throw "leq() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: gt(Expr left, Expr right)) {
  throw "gt() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: geq(Expr left, Expr right)) {
  throw "geq() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: eq(Expr left, Expr right)) {
  throw "eq() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: neq(Expr left, Expr right)) {
  throw "neq() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: and(Expr left, Expr right)) {
  throw "and() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: or(Expr left, Expr right)) {
  throw "or() not yet implemented!";
}

private tuple[Type, set[Message]] analyze(Types types, Expr e: mul(Expr multiplicand, Expr multiplier)) =
  analyze(types, e, multiplicand, multiplier);
  
private tuple[Type, set[Message]] analyze(Types types, Expr e: div(Expr numerator, Expr denominator)) =
  analyze(types, e, numerator, denominator);

private tuple[Type, set[Message]] analyze(Types types, Expr e: add(Expr leftAddend, Expr rightAddend)) =
  analyze(types, e, leftAddend, rightAddend);

private tuple[Type, set[Message]] analyze(Types types, Expr e: sub(Expr minuend, Expr subtrahend)) =
  analyze(types, e, minuend, subtrahend);

private tuple[Type, set[Message]] analyze(Types types, Expr parent, Expr lhs, Expr rhs) {
  <ltype, lm> = analyze(types, lhs);
  <rtype, rm> = analyze(types, rhs);

  if(ltype notin types[getName(parent)] && rtype notin types[getName(parent)]) {
    return <i(), {invalidTypeMessage(parent@location)}>;
  } 
  
  if(ltype == i() && rtype == i())
    return <i(), lm + rm>;
  
  if(ltype in types[getName(parent)] && rtype in types[getName(parent)])
    return <m(), lm + rm>;

  return <err(), lm + rm>;
}

// Base cases:
private tuple[Type, set[Message]] analyze(Types types, Expr e: ident(str name)) {
  if(name notin types) {
    return <err(), {undeclaredIdentifierMessage(e@location)}>;
  } else {
    return <getOneFrom(types[name]), {}>;
  }
}

private tuple[Type, set[Message]] analyze(Types types, Expr e) {
  return <getOneFrom(types[getName(e)]), {}>;
}
