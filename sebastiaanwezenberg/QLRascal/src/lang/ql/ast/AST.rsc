module lang::ql::ast::AST

data Expr
	= ident(str name)
  	| \int(int intValue)
  	| money(real moneyValue)
  	| boolean(bool booleanValue)
  	| label(str label)
  
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
 
 anno loc Expr@location;
  
data Form = 
  form(str formName, list[Statement] formElements);

anno loc Form@location;

data Conditional
  = conditional(Expr condition, list[Statement] body)
  ;

anno loc Conditional@location;

data Statement 
  = question(Question question)
  | ifCondition(Conditional ifClause, list[Conditional] elseClauses, list[ElseClause] elseClause)
  ;

anno loc Statement@location;
  
data ElseClause
  = elseClause(list[Statement] body)
  ;
 
anno loc ElseClause@location;

data Question
  = question(str questionLabel, str questionType, str answerIdentifier)
  | question(str questionLabel, str questionType, str answerIdentifier, Expr calculatedField)
  ;

anno loc Question@location;

data Type
  = \type(str typeName)
  ;

anno loc Type@location;







  