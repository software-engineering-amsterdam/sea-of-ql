module lang::qls::ast::AST

data Stylesheet
  = stylesheet(list[Statement] statements)
  ;

data Statement
  = classDefinition(str className, list[ClassRule] questionIdent)
  | styleDefinition(Ident ident, list[StyleRule] styleRules)
  ;

data Ident
  = typeIdent(str typeName)
  | classIdent(str className)
  | questionIdent(str questionName)
  ;

data ClassRule
  = classRule(str ident)
  ;

data StyleRule
  = typeStyleRule(str attr, TypeStyleValue typeValue)
  | widthStyleRule(str attr, int widthValue)
  ;

data TypeStyleValue
  = radio()
  | checkbox()
  ;

anno loc Stylesheet@location;
anno loc Statement@location;
anno loc ClassRule@location;
anno loc StyleRule@location;


//public list[StyleRule] getStyleRules(