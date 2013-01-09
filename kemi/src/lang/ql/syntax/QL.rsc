module lang::ql::syntax::QL

start syntax Form = form: "form" Ident formName "{" FormItem+ formElements "}";

syntax FormItem 
  = question: Question question
  | ifCondition: "if" Expr condition "{" FormItem+ ifPart "}" ElsIfPart* elseIfs ElsePart? elsePart
  ;

syntax ElsIfPart = "else if" Expr condition "{" FormItem+ body "}";

syntax ElsePart = "else" "{" FormItem+ body "}";

//start syntax Question = question: String questionText "," Type answerDataType "," Ident answerIdentifier (":" Expr)?;
start syntax Question 
  = question: String questionText "," Type answerDataType "," Ident answerIdentifier
  | question: String questionText "," Type answerDataType "," Ident answerIdentifier ":" Expr calculatedField
  | question: String questionText "," Type answerDataType "," Ident answerIdentifier ":" Type calculatedField
  ;

start syntax Expr
  = ident: Ident name
  | \int: Int number
  | money: Money monetaryValue
  | boolean: Boolean truthValue
  | date: Date date
  | string: String text
  | bracket "(" Expr expression ")"
  | pos: "+" Expr pos
  | neg: "-" Expr neg
  | not: "!" Expr not
  > left (
      mul: Expr multiplicand "*" Expr multiplier
    | div: Expr numerator "/" Expr denominator
  )
  > left (
      add: Expr leftAddend "+" Expr rightAddend
    | sub: Expr minuend "-" Expr subtrahend
  )
  > non-assoc (
      lt: Expr left "\<" Expr right
    | leq: Expr left "\<=" Expr right
    | gt: Expr left "\>" Expr right
    | geq: Expr left "\>=" Expr right
    | eq: Expr left "==" Expr right
    | neq: Expr left "!=" Expr right
  )
  > left and: Expr left "&&" Expr right
  > left or: Expr left "||" Expr right
  ;

syntax WhitespaceOrComment 
  = whitespace: Whitespace whitespace
  | comment: Comment comment
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

// Somhehow [0-9]+ "." [0-9]? [0-9]? does not work,[0-9]+ "." ([0-9]?[0-9])? does 
lexical Money
  = [0-9]+ "."
  | [0-9]+ "." [0-9]
  | [0-9]+ "." [0-9][0-9]
  ;

lexical Date
  = "$" Year "-" Month "-" Day
  ;

// Note: We assume that dates are valid in domain [1000 to 2999]
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
  | @category="Comment" "//" ![\n]* $
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