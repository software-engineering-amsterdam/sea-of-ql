module lang::ql::syntax::QLLexicalDefn

/**
 * This module contains all the QL lexical definitions   
 * @author  Gerson Delgado
 * @version 1.0, 19/01/2013
 */
 
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
  = [0-3][0-9] "/" [0-1][0-2] "/" [0-9][0-9][0-9][0-9] "/"   //dd/mm/yyyy/ doesn't work without closing "/" 
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