module lang::ql::syntax::QL

start syntax Expr
  = ident: Ident name
  | \int: Int
  | boolean: Boolean
  > money: Money
  | string: String
  | date: Date
  | decimal: Decimal
  | bracket "(" Expr arg ")"
  | pos: "+" Expr
  | neg: "-" Expr
  | not: "!" Expr
  > left (
      mul: Expr "*" Expr
    | div: Expr "/" Expr
  )
  > left (
      add: Expr "+" Expr
    | sub: Expr "-" Expr
  )
  > non-assoc (
      lt: Expr "\<" Expr
    | leq: Expr "\<=" Expr
    | gt: Expr "\>" Expr
    | geq: Expr "\>=" Expr
    | eq: Expr "==" Expr
    | neq: Expr "!=" Expr
  )
  > left and: Expr "&&" Expr
  > left or: Expr "||" Expr
  ;
  
start syntax DataType
  = \int: "int"
  | boolean: "boolean"
  | money: "money"
  | string: "string"
  | date: "date"
  | decimal: "decimal" 
  ;  
        
start syntax Form
  = form: "form" Ident identification "{" Element+ formElement "}" 
  ;

start syntax Element
  = question: Question question
  | condition: Condition condition
  ;
    
start syntax Question
  = singleQuestion: Ident identification ":" String description DataType datatype 
  | computableQuestion: Ident identification ":" String description DataType datatype Expr computableExpression 
  ;
   
start syntax Condition
  = singleIfCondition: "if" Expr evaluation "{" Question+ questions "}" 
  | ifElseCondition: "if" Expr evaluation "{" Question+ questions "}" "else" "{" Question+ questions "}"
  | ifElseIfCondition: "if" Expr evaluation "{" Question+ questions "}" ElseIf+ elseif "else" "{" Question+ questions "}"   
  ;
      
start syntax ElseIf
  = elseifCondition: "else if" Expr evaluation "{" Question+ questions "}" 
  ; 
  
syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment
  ;   
   
lexical Ident 
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
  ;

lexical Int
  = [0-9]+ !>> [0-9]
  ;
  
lexical Boolean
  = "true"
  | "false"
  ;

lexical Decimal
  = [0-9]+ "." [0-9][0-9][0-9]
  ;  

lexical Money
  = [0-9]+ "." !>> [0-9] ? [0-9] ? [0-9]  
  ;  

lexical String
  = "\"" ![\"]* "\"" 
  ;

lexical Date
  = [0-3][0-9] "/" [0-1][0-2] "/" [0-9][0-9][0-9][0-9] "/"  //dd/mm/yyyy  
  ;
         
lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  ;

lexical CommentChar
  = ![*]
  | [*] !>> [/]
  ;

lexical Whitespace 
  = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]
  ; 
  
layout Standard 
  = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*"
  ; 
  
keyword Keywords 
  = "true"
  | "false"
  | "if"
  | "else"
  ; 

  