module lang::qls::ast::AST

data Stylesheet
  = stylesheet(set[Statement] statements)
  ;

data Statement
  = classDefinition(str className, set[ClassRule] classRules)
  | styleDefinition(StyleIdent ident, set[StyleRule] styleRules)
  ;

data StyleIdent
  = typeStyleIdent(str typeName)
  | classStyleIdent(str className)
  | questionStyleIdent(str questionName)
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
