module lang::ql::syntax::TestSyntax

layout Layout = WhitespaceOrComment* 
     !>> [\ \t\n\f\r] 
     !>> "//" !>> "/*"
     ;

lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  ;

lexical CommentChar
  = ![*]
  | [*] !>> [/]
  ;

syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment
  ;   

lexical Whitespace 
  = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]
  ; 

  

lexical Numbers = [0-9]+;
lexical Letters = [a-z]+ \ Keywords;

keyword Keywords = "form" | "int" | "bool" | "string" | "if" | "else" | "true" | "false";

start syntax Test2
	= Numbers
//	| Letters
  > left Test2 "*" Test2        
  > left Test2 "+" Test2        
  ;