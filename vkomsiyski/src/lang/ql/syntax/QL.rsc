module lang::ql::syntax::QL


start syntax Form = form: "form" Ident? name "{" Question* questions "}";


syntax Question 
  = question: QuestionName name ":" Label label Type type Expr? expr
  | conditional: IfStatement;


syntax IfStatement 
  = ifStatementSingle: "if" "(" Expr condition ")" Question question 
                       ElseStatement? elseStatement
  | ifStatementMultiple: "if" "(" Expr condition ")" "{" Question+ questions "}" 
                       ElseStatement? elseStatement;


syntax ElseStatement
  = elseIfStatement: "else" IfStatement
  | elseStatementSingle: "else" Question question
  | elseStatementMultiple: "else" "{" Question+ questions "}";
  
 
syntax Expr
  = ident: Ident name
  | \int: Int
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
  > left or: Expr "||" Expr;
    
    
syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment;     
    
    
keyword Keywords = "form" | "if" | "else" | Type;


layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";
  

lexical QuestionName = @category="Variable" Ident;

lexical Ident =
  ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

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

  