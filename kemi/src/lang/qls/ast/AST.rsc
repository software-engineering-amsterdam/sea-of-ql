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


public Statement getClassDefinition(str className, Stylesheet s) {
  visit(s) {
    case d:classDefinition(className, _): return d;
  }
  //TODO: not found
}

public Statement getStyleDefinition(StyleIdent ident, Stylesheet s) {
  visit(s) {
    case d:styleDefinition(ident, _): return d;
  }
  //TODO: not found
}

public set[StyleRule] getStyleRules(StyleIdent ident, Stylesheet s) =
  getTypeStyleRules(ident, s) +
  getClassStyleRules(ident, s) +
  getQuestionStyleRules(ident, s);

private set[StyleRule] getTypeStyleRules(StyleIdent ident, Stylesheet s) =
  {};

private set[StyleRule] getClassStyleRules(StyleIdent ident, Stylesheet s) =
  getStyleDefinition(ident, s).styleRules;

private set[StyleRule] getQuestionStyleRules(StyleIdent ident, Stylesheet s) =
  getStyleDefinition(ident, s).styleRules;
