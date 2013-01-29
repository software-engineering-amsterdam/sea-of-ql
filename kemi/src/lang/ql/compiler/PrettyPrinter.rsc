module lang::ql::compiler::PrettyPrinter

import lang::ql::ast::AST;

public str prettyPrint(Form form) =
  "form <form.formName> { <for(e <- form.formElements) {>
  '  <prettyPrint(e)><}>
  '}
  '";

public str prettyPrint(Statement item: question(Question question)) = 
  prettyPrint(question);

public str prettyPrint(Question q: 
  question(questionText, answerDataType, answerIdentifier)) =
    "<questionText>
    '  <answerDataType> <answerIdentifier>";

public str prettyPrint(Question q: 
  question(questionText, answerDataType, answerIdentifier, calculatedField)) =
    "<questionText>
    '  <answerDataType> <answerIdentifier> = <prettyPrint(calculatedField)>";

public str prettyPrint(Statement item: 
  ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)) = 
    "if(<prettyPrint(ifPart.condition)>) { <for(e <- ifPart.body) {>
    '  <prettyPrint(e)><}><for(ei <- elseIfs) { >
    '} else if(<prettyPrint(ei.condition)>) { <for(e <- ei.body) {>
    '  <prettyPrint(e)><}><}><for(ep <- elsePart) { >
    '} else { <for(e <- ep.body) {>
    '  <prettyPrint(e)><}><}>
    '}";

public str prettyPrint(pos(Expr posValue)) = 
  "+<prettyPrint(posValue)>";

public str prettyPrint(neg(Expr negValue)) =
  "-<prettyPrint(negValue)>)";

public str prettyPrint(not(Expr notValue)) =
  "!<prettyPrint(notValue)>";

public str prettyPrint(mul(multiplicand, multiplier)) =
  "<prettyPrint(multiplicand)> * <prettyPrint(multiplier)>";

public str prettyPrint(div(numerator, denominator)) =
  "<prettyPrint(numerator)> / <prettyPrint(denominator)>";

public str prettyPrint(add(leftAddend, rightAddend)) =
  "<prettyPrint(leftAddend)> + <prettyPrint(rightAddend)>";

public str prettyPrint(sub(minuend, subtrahend)) =
  "<prettyPrint(minuend)> - <prettyPrint(subtrahend)>";

public str prettyPrint(lt(left, right)) =
  "<prettyPrint(left)> \< <prettyPrint(right)>";

public str prettyPrint(leq(left, right)) =
  "<prettyPrint(left)> \<= <prettyPrint(right)>";

public str prettyPrint(gt(left, right)) =
  "<prettyPrint(left)> \> <prettyPrint(right)>";

public str prettyPrint(geq(left, right)) =
  "<prettyPrint(left)> \>= <prettyPrint(right)>";

public str prettyPrint(eq(left, right)) =
  "<prettyPrint(left)> == <prettyPrint(right)>";

public str prettyPrint(neq(left, right)) =
  "<prettyPrint(left)> != <prettyPrint(right)>";

public str prettyPrint(and(left, right)) =
  "<prettyPrint(left)> && <prettyPrint(right)>";

public str prettyPrint(or(left, right)) =
  "<prettyPrint(left)> || <prettyPrint(right)>";

public str prettyPrint(ident(name)) =
  "<name>";

public str prettyPrint(\int(intValue)) =
  "<intValue>";

public str prettyPrint(money(moneyValue)) =
  "<moneyValue>";

public str prettyPrint(boolean(booleanValue)) =
  "<booleanValue>";

public str prettyPrint(date(dateValue)) =
  "<dateValue>";

public str prettyPrint(string(text)) =
  "<text>";
