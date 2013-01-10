module lang::ql::syntax::QL


start syntax Form = form: "form" Ident name "{" Statements body "}";

syntax Statements = @Foldable Statement+;

syntax Statement 
  = regular: Type type QuestionName name "=" String label
  | computed: Type type QuestionName name "=" String label Expr expr 
  | conditional:  IfPart ElseIfPart* ElsePart?;

syntax IfPart = "if" "(" Expr condition ")" "{" Statements body "}";

syntax ElseIfPart = "else" IfPart;

syntax ElsePart = "else" "{" Statements body "}"; 
 
syntax Expr
  = ident: Ident name
  | \int: Int
  | bracket "(" Expr arg ")"
  | pos: "+" Expr
  | neg: "-" Expr
  | not: "!" Expr
  > left (
      mul: Expr "*" Expr
    | div: Expr "/" Expr)
  > left (
      add: Expr "+" Expr
    | sub: Expr "-" Expr)
  > non-assoc (
      lt: Expr "\<" Expr
    | leq: Expr "\<=" Expr
    | gt: Expr "\>" Expr
    | geq: Expr "\>=" Expr
    | eq: Expr "==" Expr
    | neq: Expr "!=" Expr)
  > left and: Expr "&&" Expr
  > left or: Expr "||" Expr;
     
syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment;     
   
lexical Type 
  = @category="Type" "bool" 
  | @category="Type" "int" 
  | @category="Type" "string"
  | @category="Type" "money"
  | @category="Type" "float"
  | @category="Type" "date";

lexical QuestionName = @category="Variable" Ident;

lexical Ident = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical Bool = "true" | "false";

lexical Int = [0-9]+ !>> [0-9];

lexical String = @category="Identifier" "\"" StringChar* [\\] !<< "\"" ;
  
lexical StringChar = ![\"] | [\\] << [\"];

lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  | @category="Comment" "//" ![\n\r]*  NewLine;

lexical CommentChar = ![*] | [*] !>> [/];

lexical NewLine = "\n" | "\r" | "\r\n";

lexical Whitespace 
  = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E 
     \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]; 


keyword Keywords = "form" | "if" | "bool" | "int" | "string" | "money" | "float" | "date" | "true" | "false";

layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";



