module lang::ql::analysis::Expression

import Node;
import Set;
import lang::ql::analysis::Messages;
import lang::ql::analysis::State;
import lang::ql::ast::AST;
import util::IDE;

private Type i() = integerType("integer");
private Type m() = moneyType("money");
private Type b() = booleanType("boolean");
private Type d() = dateType("date");
private Type s() = stringType("string");
private Type err() = invalidType("invalid");
private Type undef() = undefinedType("undefined");

// This table contains all the expression types, 
// and shows which type can be used in conjunction with 
// that operator.
// For example: A 'mul' operation is allowed on both integers and money. 
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

private alias Types = map[str, set[Type]];

public set[Message] analyzeExpression(SAS sas, Expr expression) {
  types = (key.ident : {sas.definitions[key]} | key <- sas.definitions) + typesByOperator;
  <t, messages> = analyze(types, expression);
  return messages;
}

public set[Message] analyzeAssignmentExpression(SAS sas, Type \type, Expr expression) {
  types = (key.ident : {sas.definitions[key]} | key <- sas.definitions) + typesByOperator;
  <t, messages> = analyze(types, expression);

  if(t != \type) 
    messages += {invalidAssignmentMessage(\type, t, expression@location)};

  return messages;
}

// The following block contains all Expr patterns that are available.
private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: pos(Expr posValue)) =
    analyzeUnary(types, e, posValue);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: neg(Expr negValue)) =
    analyzeUnary(types, e, negValue);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: not(Expr notValue)) =
    analyzeUnary(types, e, notValue);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: lt(Expr left, Expr right)) =
    analyzeRelational(types, e, left, right);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: leq(Expr left, Expr right)) =
    analyzeRelational(types, e, left, right);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: gt(Expr left, Expr right)) =
    analyzeRelational(types, e, left, right);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: geq(Expr left, Expr right)) =
    analyzeRelational(types, e, left, right);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: eq(Expr left, Expr right)) =
    analyzeRelational(types, e, left, right);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: neq(Expr left, Expr right)) =
    analyzeRelational(types, e, left, right);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: and(Expr left, Expr right)) =
    analyzeAndOr(types, e, left, right);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: or(Expr left, Expr right)) =
    analyzeAndOr(types, e, left, right);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: mul(Expr multiplicand, Expr multiplier)) =
    analyzeBinaryCalculation(types, e, multiplicand, multiplier);
  
private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: div(Expr numerator, Expr denominator)) =
    analyzeBinaryCalculation(types, e, numerator, denominator);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: add(Expr leftAddend, Expr rightAddend)) =
    analyzeBinaryCalculation(types, e, leftAddend, rightAddend);

private tuple[Type, set[Message]] analyze(Types types, 
  Expr e: sub(Expr minuend, Expr subtrahend)) =
    analyzeBinaryCalculation(types, e, minuend, subtrahend);
    
// In this block are the analysis functions for each of the Expr categories 
private tuple[Type, set[Message]] analyze(Types types, Expr e: ident(str name)) {
  if(name notin types) {
    return <undef(), {undeclaredIdentifierMessage(name, e@location)}>;
  } else {
    return <getOneFrom(types[name]), {}>;
  }
}

private tuple[Type, set[Message]] analyze(Types types, Expr e) =
  <getOneFrom(types[getName(e)]), {}>;

// This function checks whether the usage of a unary expression is correct.
// There are no special cases, other then the used value not being undeclared and 
// being a member of the type table above.
private tuple[Type, set[Message]] analyzeUnary(Types types, Expr parent, Expr val) {
  <ltype, lm> = analyze(types, val);
  
  if(ltype is undef())
    return <err(), lm>;

  if(ltype notin types[getName(parent)])
    return <err(), lm + {invalidTypeMessage(parent@location)}>;
  
  return <ltype, lm>;
}

// This function checks whether the usage of a relational expression is correct.
// Usage is correct if: 
// - Neither of the members are undefined
// - Members are of allowed type of operator in question
// - Left and right hand side are of same type
// - An exception of the above rule is mingling integers and money. The resulting tye will be money.
private tuple[Type, set[Message]] analyzeRelational(Types types, Expr parent, Expr lhs, Expr rhs) {
  <ltype, lm> = analyze(types, lhs);
  <rtype, rm> = analyze(types, rhs);
  
  if(ltype == undef() || rtype == undef())
    return <err(), rm + lm>;

  if(ltype notin types[getName(parent)] && rtype notin types[getName(parent)])
    return <err(), lm + rm + {invalidTypeMessage(parent@location)}>;
  
  if(ltype == rtype)
    return <b(), lm + rm>;
    
  if(ltype in {m(), i()} &&
    rtype in {m(), i()}) 
    return <b(), lm + rm>;

  return <err(), lm + rm>;
}

// This function checks whether the usage of a and/or expression is correct.
// Usage is correct if: 
// - Neither of the members are undefined
// - Members are of allowed type of operator in question
// - Left and right hand side are booleans
private tuple[Type, set[Message]] analyzeAndOr(Types types, Expr parent, Expr lhs, Expr rhs) {
  <ltype, lm> = analyze(types, lhs);
  <rtype, rm> = analyze(types, rhs);

  if(ltype == undef() || rtype == undef())
    return <err(), lm + rm>;

  if(ltype notin types[getName(parent)] || rtype notin types[getName(parent)])
    return <err(), lm + rm + {invalidTypeMessage(parent@location)}>;
  
  if(ltype == b() && rtype == b())
    return <b(), lm + rm>;
  
  return <err(), lm + rm>;
}

// This function checks whether the usage of a relational expression is correct.
// Usage is correct if: 
// - Neither of the members are undefined
// - Members are of allowed type of operator in question
// - Left and right hand side are integers: result will be an integer
// - Left and right hand side contain one or two moneys. The result will be money.
private tuple[Type, set[Message]] analyzeBinaryCalculation(Types types, Expr parent, Expr lhs, Expr rhs) {
  <ltype, lm> = analyze(types, lhs);
  <rtype, rm> = analyze(types, rhs);
  
  if(ltype == undef() || rtype == undef())
    return <err(), lm + rm>;

  if(ltype notin types[getName(parent)] || rtype notin types[getName(parent)])
    return <err(), lm + rm + {invalidTypeMessage(parent@location)}>;
  
  if(ltype == i() && rtype == i())
    return <i(), lm + rm>;
  
  if(ltype in types[getName(parent)] && rtype in types[getName(parent)])
    return <m(), lm + rm>;

  return <err(), lm + rm>;
}
