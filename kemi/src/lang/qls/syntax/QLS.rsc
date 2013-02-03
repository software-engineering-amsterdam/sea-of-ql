module lang::qls::syntax::QLS

start syntax Stylesheet
  = stylesheet: "stylesheet" Ident "{" Definition* definitions "}"
  ;


lexical Ident
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
  ;


syntax Definition
  = @Foldable definition: PageDefinition
  | @Foldable definition: SectionDefinition
  | @Foldable definition: QuestionDefinition
  | @Foldable definition: DefaultDefinition
  ;


syntax PageDefinition
  = pageDefinition: "page" String "{" PageRule* "}"
  ;


syntax PageRule
  = @Foldable pageRule: SectionDefinition
  | @Foldable pageRule: QuestionDefinition
  | @Foldable pageRule: DefaultDefinition
  ;

syntax SectionDefinition
  = sectionDefinition: "section" String "{" SectionRule* "}"
  ;

syntax SectionRule
  = @Foldable sectionRule: SectionDefinition
  | @Foldable sectionRule: QuestionDefinition
  | @Foldable sectionRule: DefaultDefinition
  ;

syntax QuestionDefinition
  = questionDefinition: "question" Ident
  | questionDefinition: "question" Ident "{" StyleRule* "}"
  ;

syntax DefaultDefinition
  = defaultDefinition: "default" Type "{" StyleRule* "}"
  ;

lexical Type
  = @category="Type" "boolean"
  | @category="Type" "integer"
  | @category="Type" "money"
  | @category="Type" "date"
  | @category="Type" "string"
  ; 

syntax StyleRule
  = typeStyleRule: TypeStyleAttr TypeStyleValue
  | widthStyleRule: WidthStyleAttr Int
  ;

lexical TypeStyleValue
  = radio: "radio"
  | checkbox: "checkbox"
  ;

lexical TypeStyleAttr
  = @category="Constant" "type"
  ;

lexical WidthStyleAttr
  = @category="Constant" "width"
  ;

lexical Int
  = [0-9]+ !>> [0-9]
  ;

lexical String
  = @category="Variable" "\"" TextChar* "\"";

lexical TextChar
  = [\\] << [\"]
  | ![\"]
  ;

syntax WhitespaceOrComment 
  = whitespace: Whitespace whitespace
  | comment: Comment comment
  ;
  
lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  | @category="Comment" "//" ![\n]* $
  ;

lexical CommentChar
  = ![*]
  | [*] !>> [/]
  ;

lexical Whitespace = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000];

layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";

keyword Keywords 
  = stylesheet: "stylesheet"
  | page: "page"
  | section: "section"
  | question: "question"
  | \default: "default"
  | boolean: "boolean"
  | \int: "integer"
  | money: "money"
  | date: "date"
  | string: "string"
  | \type: "type"
  | width: "width"
  | radio: "radio"
  | checkbox: "checkbox"
  ;
