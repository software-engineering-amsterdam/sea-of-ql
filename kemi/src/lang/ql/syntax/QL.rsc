module lang::ql::syntax::QL

start syntax Form = @Foldable form: "form" Ident formName "{" Statement+ formElements "}";

syntax Statement 
  = question: Question question
  | ifCondition: IfPart ifPart ElsIfPart* elseIfs ElsePart? elsePart
  ;


//TODO: this is needed for the AST, however, now it seems kinda vague / ambiguous (maybe?)
syntax Conditional 
  = conditional: Expr condition "{" Statement+ body "}"
  ;

syntax IfPart = @Foldable "if" Conditional ifPart;

syntax ElsIfPart = @Foldable "else" "if" Conditional elsePart;

syntax ElsePart = @Foldable elsePart: "else" "{" Statement+ body "}";

// What the ...?! Colons don't work, but equals signs do...
start syntax Question 
  = question: String questionText Type answerDataType Ident answerIdentifier
  | question: String questionText Type answerDataType Ident answerIdentifier "=" Expr calculatedField
  ;

//start syntax Expr
syntax Expr
  = ident: Ident name
  | @category="Constant" \int: Int number
  | @category="Constant" money: Money monetaryValue
  | @category="Constant" boolean: Boolean truthValue
  | @category="Constant" date: Date date
  | @category="Constant" string: String text
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

lexical Ident = @category="Variable" ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical Type
  = @category="Type" "boolean"
  | @category="Type" "integer"
  | @category="Type" "money"
  | @category="Type" "date"
  | @category="Type" "string"
  ;

lexical String = "\"" TextChar* "\"";

lexical TextChar
  = [\\] << [\"]
  | ![\"]
  ;

lexical Int = [0-9]+ !>> [0-9];

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

lexical Date = "$" Year "-" Month "-" Day;

// Note: We assume that dates are valid in domain [1000 to 2999]
lexical Year = [1-2][0-9][0-9][0-9];

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

lexical Whitespace = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000];

layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";

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