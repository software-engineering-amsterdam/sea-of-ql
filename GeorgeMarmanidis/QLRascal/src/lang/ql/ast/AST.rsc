module lang::ql::ast::AST

//data Form

//data FormBody

//data ConditionalStatement

//data ElseIf

//data Question
data Question
	=simpleQuestion(str,str,str)
	|computedQuestion(str,str,str,Expr cond)
	|testQuestion(str);
//data Type..it doesn't have it in Pico example

//data WhitespaceOrComment 

//data Expr
data Expr
  = ident(str name)
  | \int(int ivalue)
  | add(Expr leftAddend, Expr rightAddend)
  | mul(Expr multiplicand, Expr multiplier);