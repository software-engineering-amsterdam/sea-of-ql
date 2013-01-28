module lang::qls::syntax::QLS

start syntax FormStyle = @Foldable style: StyleRule* rules;

syntax StyleRule
  = @Foldable typed: Type type "{" Rule+ "}"
  | @Foldable id: Ident name "{" Rule+ "}"
  | @Foldable group: "group" Label name "{" Ident+ questions "}";

syntax Rule 
  = color: "color:"  Color color
  | widget: "widget:" Widget widget 
  | font: "font:" Font font
  | width: "width:" Width val
  | min: "minimum:" Numeric val
  | max: "maximum:" Numeric val
  | step: "stepSize:" Numeric val;
  
syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment;     
   
lexical Type 
  = @category="Type" \bool: "bool" 
  | @category="Type" \int: "int" 
  | @category="Type" string: "string"
  | @category="Type" float: "float"
  | @category="Type" date: "date";

lexical Widget
  = @category="Variable" checkbox: "checkbox"
  | @category="Variable" radio: "radio";

lexical Ident = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical Label = @category="Variable" String;

lexical Color = @category="Variable" String;

lexical Font = @category="Variable" String;

lexical Numeric 
  = @category="Variable" Int 
  | @category="Variable" Float;

lexical Int = [0-9]+ !>> [0-9];

lexical Float = [0-9]* "." [0-9]+ !>> [0-9];

lexical String = "\"" StringChar* [\\] !<< "\"" ; 
  
lexical StringChar = ![\"] | [\\] << [\"];

lexical Comment 
  = @category="Comment" "/*" CommentChar* "*/"
  | @category="Comment" "//" ![\n\r]*  NewLine;

lexical CommentChar = ![*] | [*] !>> [/];

lexical NewLine = "\n" | "\r" | "\r\n";

lexical Whitespace 
  = [\u0009-\u000D \u0020 \u0085 \u00A0 \u1680 \u180E 
     \u2000-\u200A \u2028 \u2029 \u202F \u205F \u3000]; 


keyword Keywords = "group" | "page" | 
					"bool" | "int" | "string" | "float" | "date" |
					"true" | "false" |
					"color" | "widget" | "font" | "minimum" | "maximum" | "width" | "stepSize" |
					"checkbox" | "radio";


layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";



