@license{
  Copyright (c) 2013 
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
}
@contributor{Kevin van der Vlist - kevin@kevinvandervlist.nl}
@contributor{Jimi van der Woning - Jimi.vanderWoning@student.uva.nl}

module lang::ql::compiler::web::PHPExpressionPrinter

import String;
import lang::ql::\ast::AST;

// Note: Because this is generated code, we add parentheses anyway. 
// It is not worthwile to minimize those as we do in the normal prettyprinter.
public str phpPrint(pos(Expr posValue)) = 
  "(+<phpPrint(posValue)>)";

public str phpPrint(neg(Expr negValue)) =
  "(-<phpPrint(negValue)>)";

public str phpPrint(not(Expr notValue)) =
  "(!<phpPrint(notValue)>)";

public str phpPrint(mul(multiplicand, multiplier)) =
  "(<phpPrint(multiplicand)> * <phpPrint(multiplier)>)";

public str phpPrint(div(numerator, denominator)) =
  "(<phpPrint(numerator)> / <phpPrint(denominator)>)";

public str phpPrint(add(leftAddend, rightAddend)) =
  "(<phpPrint(leftAddend)> + <phpPrint(rightAddend)>)";

public str phpPrint(sub(minuend, subtrahend)) =
  "(<phpPrint(minuend)> - <phpPrint(subtrahend)>)";

public str phpPrint(lt(left, right)) =
  "(<phpPrint(left)> \< <phpPrint(right)>)";

public str phpPrint(leq(left, right)) =
  "(<phpPrint(left)> \<= <phpPrint(right)>)";

public str phpPrint(gt(left, right)) =
  "(<phpPrint(left)> \> <phpPrint(right)>)";

public str phpPrint(geq(left, right)) =
  "(<phpPrint(left)> \>= <phpPrint(right)>)";

public str phpPrint(eq(left, right)) =
  "(<phpPrint(left)> == <phpPrint(right)>)";

public str phpPrint(neq(left, right)) =
  "(<phpPrint(left)> != <phpPrint(right)>)";

public str phpPrint(and(left, right)) =
  "(<phpPrint(left)> && <phpPrint(right)>)";

public str phpPrint(or(left, right)) =
  "(<phpPrint(left)> || <phpPrint(right)>)";

public str phpPrint(ident(name)) =
  "<name>";

public str phpPrint(\int(intValue)) =
  "<intValue>";

public str phpPrint(money(moneyValue)) =
  "<moneyValue>";

public str phpPrint(boolean(booleanValue)) =
  "<booleanValue>";

public str phpPrint(date(dateValue)) =
  "\"<substring(dateValue, 1)>\"";

public str phpPrint(string(text)) =
  "<text>";
