module lang::ql::ast::AST

data Form = form(str formName, list[FormItem] formElements);

alias ElseIf = tuple[Expr condition, list[FormItem] body];

data FormItem 
  = question(Question question)
  | ifCondition(Expr condition, list[FormItem] ifPart, list[ElseIf] elseIfs, list[FormItem] elsePart)
  ;

data Type
  = \type(str name)
  ;

data Question
  // How standard implode returns it
  = question(str, str, str)
  | question(str, str, str, Expr e)
  // How we want it
  //| question(Expr questionText, Type answerDataType, Expr answerIdentifier)
  //| question(Expr questionText, Type answerDataType, Expr answerIdentifier, Expr calculatedField)
  ;

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
anno loc FormItem@location;
anno loc Question@location;
