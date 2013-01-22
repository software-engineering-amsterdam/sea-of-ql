module lang::qls::syntax::QLS

start syntax Stylesheet
  = stylesheet: Statement+ statements
  ;

syntax Statement
  = @Foldable ClassDefinition
  | @Foldable StyleDefinition
  ;

syntax ClassDefinition
  = classDefinition: "class" BaseIdent "{" ClassRule+ "}"
  ;

syntax ClassRule
  = classRule: QuestionIdent
  ;

syntax StyleDefinition
  = styleDefinition: Ident "{" StyleRule+ "}"
  ;

syntax StyleRule
  = typeStyleRule: TypeStyleAttr TypeStyleValue
  | widthStyleRule: WidthStyleAttr Int
  ; 

syntax TypeStyleValue
  = radio: "radio"
  | checkbox: "checkbox"
  ;

syntax Ident
  = typeIdent: Type
  | classIdent: ClassIdent
  | questionIdent: QuestionIdent
  ;

lexical ClassIdent
  = @category="NonterminalLabel" [.]BaseIdent
  ; 

lexical QuestionIdent
  = @category="Variable" [#]BaseIdent
  ;

lexical BaseIdent
  = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical Type
  = @category="Type" "boolean"
  | @category="Type" "integer"
  | @category="Type" "money"
  | @category="Type" "date"
  | @category="Type" "string"
  ; 

lexical TypeStyleAttr
  = @category="Identifier" "type"
  ;

lexical WidthStyleAttr
  = @category="Identifier" "width"
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
  | form: "class"
  | \type: "type"
  | width: "width"
  | radio: "radio"
  | checkbox: "checkbox"
  ;
