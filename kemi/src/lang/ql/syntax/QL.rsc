module lang::ql::syntax::QL


start syntax Form
  = form: "form" Ident "{" FormItem+ "}"
  ;


start syntax Conditional
  // TODO: else if? I say no, if you want this: else { if ( ... ) {
  = conditional: Expr
  //= conditional: "if" /*Expr*/ "{" FormItem+ "}"// ("else" "{" FormItem+ "}")?
  ;


start syntax Question
  = question: String "," Type "," Ident (":" Expr)?
  ;


start syntax Expr
  = ident: Ident name
  | \int: Int
  | money: Money
  | boolean: Boolean
  | date: Date
  | string: String
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



syntax FormItem
  = question: Question
  //| conditional: Conditional
  | conditional: Expr
  ;

syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment
  ;   



lexical Ident 
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
  ;

lexical Type
  = "boolean"
  | "integer"
  | "money"
  | "date"
  | "string"
  ;

lexical String 
  = "\"" TextChar* "\""
  ;

lexical TextChar
  = [\\] << [\"]
  | ![\"]
  ;

lexical Int
  = [0-9]+ !>> [0-9]
  ;

lexical Boolean
  = "true"
  | "false"
  ;

// Somhehow [0-9]+ "." [0-9]? [0-9]? does not work
lexical Money
  = [0-9]+ "." ([0-9]?[0-9])?
  ;

lexical Date
  = "$" Year "-" Month "-" Day
  ;

// Only valid from 1000 to 2999
lexical Year
  = [1-2][0-9][0-9][0-9]
  ;

lexical Month
  = [0][0-9]
  | [1][0-2]
  ;

lexical Day
  = [0-2][0-9]
  | [3][0-1]
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
  = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";



keyword Keywords 
  = boolean: "boolean"
  | \int: "integer"
  | money: "money"
  | date: "date"
  | string: "string"
  | \true: "true"
  | \false: "false"
  | form: "form"
  ;