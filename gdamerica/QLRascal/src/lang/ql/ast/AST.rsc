module lang::ql::ast::AST

data Expr
  = ident(str name)
  | \int(int iValue)
  | boolean(bool bValue)
  | money(real mnValue)
  | string(str strValue)
  | date(int dtValue)
  | decimal(real decValue)
  | pos(Expr posValue)
  | neg(Expr negValue)
  | not(Expr notValue)
  | mul(Expr mulLftValue, Expr mulRgtValue)
  | div(Expr divLftValue, Expr divRgtValue)
  | add(Expr addLftValue, Expr addRgtValue)
  | lt(Expr ltLftValue, Expr ltRgtValue)
  | leg(Expr legLftValue, Expr legRgtValue)
  | gt(Expr gtLftValue, Expr gtRgtValue)
  | geq(Expr geqLftValue, Expr geqRgtValue)
  | eq(Expr eqLftValue, Expr eqRgtValue)
  | neq(Expr neqLftValue, Expr neqRgtValue)
  | and(Expr andLftValue, Expr andRgtValue)
  | or(Expr orLftValue, Expr orRgtValue)
  ;

data DataType
  = \int()
  | boolean()
  | money()
  | string()
  | date()
  | decimal()
  ;
 
data Form
  = form(str fIdent, list[Element] fElements )
  ;

data Element
  = question(Question qstn)
  | condition(Condition cond)
  ;
  
data Question
  = singleQuestion(str qstnIdent, str qstnDescr, DataType qstnDataType)
  | computableQuestion(str cqstnIdent, str cqstnDescr, DataType cqstnDataType, Expr cqstnExpr)
  ;
  
data Condition
  = singleIfCondition(Expr ifEval, list[Question] ifQstns)
  | ifElseCondition(Expr ifEval, list[Question] ifQstns, list[Question] elseQstns)
  | ifElseIfCondition(Expr ifEval, list[Question] ifQstns, list[ElseIf] elseifs, list[Question] elseQstns)
  ;
  
data ElseIf
  = elseifCondition(Expr elseifEval, list[Question] elseifQstns)
  ; 
