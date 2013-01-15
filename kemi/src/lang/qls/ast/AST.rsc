module lang::qls::ast::AST


data QLS
  = qls(list[Statement] statements)
  ;

data Statement
  = statement(ClassStyleDefinition classStyleDefinition)
  | statement(TypeStyleDefinition typeStyleDefinition)
  | statement(ClassStyleDefinition classStyleDefinition)
  | statement(IdentStyleDefinition identStyleDefinition)
  ;

data ClassStyleDefinition
  = classDefinition(str ident, list[str] questionIdent)
  ;

data TypeStyleDefinition
  = typeStyleDefinition(str \type, list[StyleRule] styleRules)
  ;

data ClassStyleDefinition
  = classStyleDefinition(str ident, list[StyleRule] styleRules)
  ;

data IdentStyleDefinition
  = identStyleDefinition(str ident, list[StyleRule] styleRules)
  ;

data StyleRule
  = styleRule(str attr, StyleAttrValue \value)
  ;

data StyleAttrValue
  = styleAttrValue(str stringValue)
  ;

anno loc QLS@location;
anno loc Statement@location;
anno loc ClassStyleDefinition@location;
anno loc TypeStyleDefinition@location;
anno loc ClassStyleDefinition@location;
anno loc IdentStyleDefinition@location;
anno loc StyleRule@location;
anno loc StyleAttrValue@location;
