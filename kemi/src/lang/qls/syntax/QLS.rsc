module lang::qls::syntax::QLS

start syntax Stylesheet
  = stylesheet: "stylesheet" Ident "{" Statement* statements "}"
  ;


lexical Ident
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords
  ;


syntax Statement
  = @Foldable statement: PageDefinition
  | @Foldable statement: SectionDefinition
  | @Foldable statement: QuestionDefinition
  | @Foldable statement: DefaultDefinition
  ;


syntax PageDefinition
  = pageDefinition: "page" Ident "{" PageRule* "}"
  ;


syntax PageRule
  = pageRule: SectionDefinition
  | pageRule: QuestionDefinition
  | pageRule: DefaultDefinition
  ;

syntax SectionDefinition
  = sectionDefinition: "section" Ident "{" SectionRule* "}"
  ;

syntax SectionRule
  = sectionRule: SectionDefinition
  | sectionRule: QuestionDefinition
  | sectionRule: DefaultDefinition
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

syntax TypeStyleValue
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
