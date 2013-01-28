module lang::qls::ast::AST

data Stylesheet
  = stylesheet(set[Statement] statements)
  ;

data Statement
  = pageDefinition(str pageName, set[PageRule] pageRules)
  | sectionDefinition(str sectionName, set[SectionRule] sectionRules)
  | styleDefinition(StyleIdent ident, set[StyleRule] styleRules)
  ;

data PageRule
  = pageRule(str ident)
  ;

data SectionRule
  = sectionRule(str ident)
  | sectionRule(str ident, set[SectionRule] sectionRules)
  // TODO: does not work... | sectionRule(Statement sectionDefinition)
  ;

data StyleIdent
  = typeIdent(str typeName)
  | pageIdent(str pageName)
  | sectionIdent(str sectionName)
  | questionIdent(str questionName)
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
anno loc PageRule@location;
anno loc SectionRule@location;
anno loc StyleRule@location;
