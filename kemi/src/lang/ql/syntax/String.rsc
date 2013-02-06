module lang::ql::syntax::String

lexical String
  = @category="Variable" "\"" TextChar* "\"";

lexical TextChar
  = [\\] << [\"]
  | ![\"]
  ;
