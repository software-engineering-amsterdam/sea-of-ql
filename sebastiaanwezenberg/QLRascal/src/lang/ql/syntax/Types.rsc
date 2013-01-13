module lang::ql::syntax::Types

import lang::ql::syntax::Expressions;
import lang::ql::syntax::Layout;
import lang::ql::syntax::Lexical;

syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment
  ;   


  