module lang::ql::ast::AST

//data Form

//data FormBody

//data ConditionalStatement

//data ElseIf

//data Question
data Question
	=simpleQuestion(Expr,Expr,Type)
	|computedQuestion(str questionVar, str label, str Type, Expr computation)
	|testQ(str questionVar)
	;
//data Type..it doesn't have it in Pico example
data Type=\type (str);
data Ident=ident (str);
//data WhitespaceOrComment 


//data Expr
data Expr
  = ident(str name)
  | \int(int ivalue) 
  | \string (str strValue) //works needs more tests
  | boolean (str bValue) 
  | date(str dValue) // works..needs to set the days and month numbers correclty
  | money (real monValue)//works but problem with 1,22 two decimal digits
  | float (real fValue) 
  
  | add(Expr addLeft, Expr addRight)
  | mul(Expr multLeft, Expr multright)
  | div(Expr divLeft, Expr divRight)
  | sub(Expr subLeft, Expr subRight)
  
  | pos(Expr posValue)
  | neg(Expr negValue)
  | not(Expr notValue)
  
  | lt(Expr ltLeft, Expr ltRight)
  | leq(Expr leqLeft, Expr leqRight)
  | gt(Expr gtLeft, Expr gtRight)
  | geq(Expr getLeft, Expr getRight)
  | eq(Expr eqLeft, Expr eqRight)
  | neq(Expr neqLeft, Expr neqRight)
  
  | and(Expr andLeft, Expr andRight)
  | or(Expr orLeft, Expr orRight);