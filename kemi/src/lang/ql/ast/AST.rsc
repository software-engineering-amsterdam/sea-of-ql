module lang::ql::ast::AST

data Form
  = form(IdentDefinition formName, list[Statement] formElements);

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
  = question(QuestionText questionText, Type answerDataType, IdentDefinition answerIdentifier)
  | question(QuestionText questionText, Type answerDataType, IdentDefinition answerIdentifier, Expr calculatedField)
  ;

data QuestionText
  = questionText(str text)
  ;

data Type
  = booleanType(str name)
  | integerType(str name)
  | moneyType(str name)
  | dateType(str name)
  | stringType(str name)
  ;

data IdentDefinition
  = identDefinition(str ident)
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
anno loc Conditional@location;
anno loc ElsePart@location;
anno loc Expr@location;
anno loc Form@location;
anno loc Question@location;
anno loc Statement@location;
