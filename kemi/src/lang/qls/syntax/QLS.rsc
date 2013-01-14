module lang::qls::syntax::QLS

start syntax QLS
  = qls: Statement+ statements
  ;

syntax Statement
  = @Foldable classDefinition: ClassDefinition
  | @Foldable typeStyleDefinition: TypeStyleDefinition
  | @Foldable classStyleDefinition: ClassStyleDefinition
  | @Foldable identStyleDefinition: IdentStyleDefinition
  ;

syntax ClassDefinition
  = classDefinition: "class" ClassIdent "{" QuestionIdent+ "}"
  ;

syntax TypeStyleDefinition
  = typeStyleDefinition: Type "{" StyleRule+ "}"
  ;

syntax ClassStyleDefinition
  = classStyleDefinition: ClassIdent "{" StyleRule+ "}"
  ;

syntax IdentStyleDefinition
  = identStyleDefinition: QuestionIdent "{" StyleRule+ "}"
  ;

syntax StyleRule
  = styleRule: StyleAttr StyleAttrValue
  ; 

lexical ClassIdent
  = [.]Ident
  ; 

lexical QuestionIdent
  = Ident
  ;

lexical Ident
  = @category="Variable" ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical Type
  = @category="Type" "boolean"
  | @category="Type" "integer"
  | @category="Type" "money"
  | @category="Type" "date"
  | @category="Type" "string"
  ; 

lexical StyleAttr
  = @category="Constant" "type"
  | @category="Constant" "width"
  ;

syntax StyleAttrValue
  = styleAttrValue: StyleTypeValue
  | styleAttrValue: Int
  ;

lexical StyleTypeValue
  = @category="Constant" "radio"
  | @category="Constant" "checkbox"
  ;

lexical Int
  = [0-9]+ !>> [0-9]
  ;
