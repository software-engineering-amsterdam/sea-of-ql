@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::web::JSExpressionPrinter

import String;
import lang::ql::\ast::AST;

// Note: Because this is generated code, we add parentheses anyway. 
// It is not worthwile to minimize those as we do in the normal prettyprinter.
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
