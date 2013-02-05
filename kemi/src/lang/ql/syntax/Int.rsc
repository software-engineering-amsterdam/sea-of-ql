module lang::ql::syntax::Int

lexical Int =
  @category="Constant" [0-9]+ !>> [0-9]
  ;
  