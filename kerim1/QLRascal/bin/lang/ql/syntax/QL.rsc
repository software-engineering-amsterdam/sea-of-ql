module lang::ql::syntax::QL

keyword Keywords = "form" | "int" | "bool" | "string" | "if" | "else" | "true" | "false";

lexical Ident = @category="Identifier" ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;
lexical Int = [0-9]+ !>> [0-9];
lexical Bool = "true" | "false";
lexical String = "\"" ![\"]* "\"";

layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";
  
lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  | @category="Comment" "//" ![\n]* $;

lexical CommentChar
  = ![*]
  | [*] !>> [/];

syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment;   

lexical Whitespace = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]; 

start syntax Form 
  = @Foldable form: "form" Ident name "{" Statement* body "}";

syntax Statement 
  = question: Question question
  | @Foldable ifThenElse: "if" Expr condition "{" Statement+ thenPart "}" ElseIf* elseIfs "else" "{" Statement+ elsePart "}"
  | @Foldable ifThen: "if" Expr condition "{" Statement+ thenPart "}" ElseIf* elseIfs;

syntax ElseIf 
  = @Foldable elseIf: "else" "if" Expr condition "{" Statement+ thenPart "}";

syntax Question 
  = computed: Ident identifier ":" String label Type tp Expr expression
  | noncomputed: Ident identifier ":" String label Type tp;
  
syntax Type
  = intType: "int"
  | boolType: "bool"
  | stringType: "string";
	
syntax Expr
  = ident: Ident name
  | \int: Int integer
  | \bool: Bool boolean
  | string: String string
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
  