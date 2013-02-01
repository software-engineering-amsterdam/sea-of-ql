module lang::qls::syntax::QLS

start syntax Stylesheet
  = stylesheet: Statement+ statements
  ;

syntax Statement
  = @Foldable PageDefinition
  | @Foldable SectionDefinition
  | @Foldable StyleDefinition
  ;

syntax PageDefinition
  = pageDefinition: "page" PageIdent "{" PageRule+ "}"
  ;

syntax PageRule
  = pageRule: SectionIdent
  | pageRule: QuestionIdent
  ;

syntax SectionDefinition
  = sectionDefinition: "section" SectionIdent "{" SectionRule+ "}"
  ;

syntax SectionRule
  = sectionRule: "section" SectionIdent "{" SectionRule+ "}"
  | sectionRule: QuestionIdent
  ;

syntax StyleDefinition
  = styleDefinition: StyleIdent "{" StyleRule+ "}"
  ;

syntax StyleRule
  = typeStyleRule: TypeStyleAttr TypeStyleValue
  | widthStyleRule: WidthStyleAttr Int
  ;

syntax TypeStyleValue
  = radio: "radio"
  | checkbox: "checkbox"
  ;

syntax StyleIdent
  = typeIdent: TypeIdent
  | pageIdent: PageIdent
  | sectionIdent: SectionIdent
  | questionIdent: QuestionIdent
  ;

lexical PageIdent
  = @category="NonterminalLabel" [.]BaseIdent
  ; 

lexical SectionIdent
  = @category="MetaVariable" [$]BaseIdent
  ;

lexical QuestionIdent
  = @category="Variable" [#]BaseIdent
  ;

lexical BaseIdent
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical TypeIdent
  = @category="Type" "boolean"
  | @category="Type" "integer"
  | @category="Type" "money"
  | @category="Type" "date"
  | @category="Type" "string"
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
  = boolean: "boolean"
  | \int: "integer"
  | money: "money"
  | date: "date"
  | string: "string"
  | page: "page"
  | section: "section"
  | \type: "type"
  | width: "width"
  | radio: "radio"
  | checkbox: "checkbox"
  ;
