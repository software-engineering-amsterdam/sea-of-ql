module lang::qls::ast::AST

data Stylesheet
  = stylesheet(str ident, list[Statement] statements)
  ;

data Statement
  = statement(PageDefinition pageDefinition)
  | statement(SectionDefinition sectionDefinition)
  | statement(QuestionDefinition questionDefinition)
  | statement(DefaultDefinition defaultDefinition)
  ;

data PageDefinition
  = pageDefinition(str ident, list[PageRule] pageRules)
  ;

data PageRule
  = pageRule(SectionDefinition sectionDefinition)
  | pageRule(QuestionDefinition questionDefinition)
  | pageRule(DefaultDefinition defaultDefinition)
  ;

data SectionDefinition
  = sectionDefinition(str ident, list[SectionRule] sectionRules)
  ;

data SectionRule
  = sectionRule(SectionDefinition sectionDefinition)
  | sectionRule(QuestionDefinition questionDefinition)
  | sectionRule(DefaultDefinition defaultDefinition)
  ;

data QuestionDefinition
  = questionDefinition(str ident)
  | questionDefinition(str ident, list[StyleRule] styleRules)
  ;

data DefaultDefinition
  = defaultDefinition(str ident, list[StyleRule] styleRules)
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
anno loc PageDefinition@location;
anno loc PageRule@location;
anno loc SectionDefinition@location;
anno loc SectionRule@location;
anno loc QuestionDefinition@location;
anno loc DefaultDefinition@location;
anno loc StyleRule@location;

