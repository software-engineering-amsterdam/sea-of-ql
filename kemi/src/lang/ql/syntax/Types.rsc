module lang::ql::syntax::Types

lexical Type
  = @category="Type" booleanType: "boolean"
  | @category="Type" integerType: "integer"
  | @category="Type" moneyType: "money"
  | @category="Type" dateType: "date"
  | @category="Type" stringType: "string"
  ;
