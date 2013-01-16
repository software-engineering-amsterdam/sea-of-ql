module lang::qls::ast::AST


data Stylesheet
  = stylesheet(list[Statement] statements)
  ;

data Statement
  = classDefinition(str ident, list[ClassRule] questionIdent)
  | typeStyleDefinition(str \type, list[StyleRule] styleRules)
  | classStyleDefinition(str ident, list[StyleRule] styleRules)
  | identStyleDefinition(str ident, list[StyleRule] styleRules)
  ;

data ClassRule
  = classRule(str ident)
  ;

data StyleRule
  = styleRule(str attr, StyleAttrValue \value)
  ;

data StyleAttrValue
  = styleAttrValue(str \value)
  ;

anno loc Stylesheet@location;
anno loc Statement@location;
anno loc ClassRule@location;
anno loc StyleRule@location;
anno loc StyleAttrValue@location;
