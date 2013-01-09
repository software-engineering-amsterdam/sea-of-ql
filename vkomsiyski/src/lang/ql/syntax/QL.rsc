module lang::ql::syntax::QL


start syntax Form = form: "form" Ident name "{" Questions questions "}";


syntax Questions = @Foldable Question+;


syntax Question
  = regular: Type type QuestionName name "for" Label label 
  | computed: Type type QuestionName name "=" Expr expr "for" Label label 
  | conditional: "if" "(" Expr condition ")" "{" Questions questions "}"; 
 
 
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
    
    
keyword Keywords = "form" | "if" | "for" | Type;


layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";
  

lexical QuestionName = @category="Variable" Ident;

lexical Ident = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical Int = [0-9]+ !>> [0-9];

lexical Label = @category="Identifier" "\"" LabelChar* [\\] !<< "\"" ;
  
lexical LabelChar = ![\"] | [\\] << [\"];

lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  | @category="Comment" "//" ![\n\r]*; 

lexical CommentChar = ![*] | [*] !>> [/];

lexical Type 
  = @category="Type" "boolean" 
  | @category="Type" "integer" 
  | @category="Type" "string";

lexical Whitespace 
  = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E 
     \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]; 

 