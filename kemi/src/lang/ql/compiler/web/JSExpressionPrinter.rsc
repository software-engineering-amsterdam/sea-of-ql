module lang::ql::compiler::web::JSExpressionPrinter

import String;
import lang::ql::ast::AST;

// Until we work how to reconstruct priorities (doNotNest stuff)
// we should include parenthesis just in case. 

public str jsPrint(pos(Expr posValue)) = 
  "(+<jsPrint(posValue)>)";

public str jsPrint(neg(Expr negValue)) =
  "(-<jsPrint(negValue)>)";

public str jsPrint(not(Expr notValue)) =
  "(!<jsPrint(notValue)>)";

public str jsPrint(mul(multiplicand, multiplier)) =
  "(<jsPrint(multiplicand)> * <jsPrint(multiplier)>)";

public str jsPrint(div(numerator, denominator)) =
  "(<jsPrint(numerator)> / <jsPrint(denominator)>)";

public str jsPrint(add(leftAddend, rightAddend)) =
  "(<jsPrint(leftAddend)> + <jsPrint(rightAddend)>)";

public str jsPrint(sub(minuend, subtrahend)) =
  "(<jsPrint(minuend)> - <jsPrint(subtrahend)>)";

public str jsPrint(lt(left, right)) =
  "(<jsPrint(left)> \< <jsPrint(right)>)";

public str jsPrint(leq(left, right)) =
  "(<jsPrint(left)> \<= <jsPrint(right)>)";

public str jsPrint(gt(left, right)) =
  "(<jsPrint(left)> \> <jsPrint(right)>)";

public str jsPrint(geq(left, right)) =
  "(<jsPrint(left)> \>= <jsPrint(right)>)";

public str jsPrint(eq(left, right)) =
  "(<jsPrint(left)> == <jsPrint(right)>)";

public str jsPrint(neq(left, right)) =
  "(<jsPrint(left)> != <jsPrint(right)>)";

public str jsPrint(and(left, right)) =
  "(<jsPrint(left)> && <jsPrint(right)>)";

public str jsPrint(or(left, right)) =
  "(<jsPrint(left)> || <jsPrint(right)>)";

public str jsPrint(ident(name)) =
  "<name>";

public str jsPrint(\int(intValue)) =
  "<intValue>";

public str jsPrint(money(moneyValue)) =
  "<moneyValue>";

public str jsPrint(boolean(booleanValue)) =
  "<booleanValue>";

public str jsPrint(date(dateValue)) =
  "\"<substring(dateValue, 1)>\"";

public str jsPrint(string(text)) =
  "<text>";
