module lang::ql::ast::AST

data Form = form(str formName, list[Statement] formElements);

data Conditional
  = conditional(Expr condition, list[Statement] body)
  ;

data ElsePart
  = elsePart(list[Statement] body)
  ;

data Statement 
  = question(Question question)
  | ifCondition(Conditional ifPart, list[Conditional] elseIfs, list[ElsePart] elsePart)
  ;

data Question
  // How standard implode returns it
  = question(str, str, str)
  | question(str, str, str, Expr e)
  | question(str, str, str, str)
  | question(str, str, str, Expr e, str)
  // How we want it
  //| question(Expr questionText, Type answerDataType, Expr answerIdentifier)
  //| question(Expr questionText, Type answerDataType, Expr answerIdentifier, Expr calculatedField)
  ;

data Type
  = \type(str typeName)
  ;

/* Nevermind, thought this would help but probably won't
data Ident
  = ident(str name)
  ;

data String
  = string(str stringValue)
  ;

data Int
  = integer(int intValue)
  ;

data Boolean
  = boolean(bool booleanValue)
  ;

data Money
  = money(real moneyValue)
  ;

data Date
  = date(str dateValue)
  ;
*/

data Expr
  = ident(str name)
  | \int(int intValue)
  | money(real moneyValue)
  | boolean(bool booleanValue)
  | date(str dateValue)
  | string(str text)
  
  | pos(Expr posValue)
  | neg(Expr negValue)
  | not(Expr notValue)
  
  | mul(Expr multiplicand, Expr multiplier)
  | div(Expr numerator, Expr denominator)
  | add(Expr leftAddend, Expr rightAddend)
  | sub(Expr minuend, Expr subtrahend)
  
  | lt(Expr left, Expr right)
  | leq(Expr left, Expr right)
  | gt(Expr left, Expr right)
  | geq(Expr left, Expr rigt)
  | eq(Expr left, Expr right)
  | neq(Expr left, Expr right)
  
  | and(Expr left, Expr right)
  | or(Expr left, Expr right)
  ;
  
// Some annotation for language integration
anno loc Form@location;
anno loc Statement@location;
anno loc Question@location;
anno loc Conditional@location;
anno loc ElsePart@location;
