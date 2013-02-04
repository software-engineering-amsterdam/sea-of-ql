module lang::qls::syntax::QLS

start syntax FormStyle 
   = @Foldable style: "stylesheet" Ident name ";" StyleRule* rules;

syntax StyleRule
  = @Foldable typed: Type type "{" Rule+ "}"
  | @Foldable id: Variable name "{" Rule+ "}"
  | @Foldable group: "group" Label name "{" Ident+ questions "}";

syntax Rule 
  = color: "color:"  Color color // color of the label text
  | font: "font:" Font font // font of the label text
  | widget: "widget:" WidgetType widget 
  | minInt: "minimum:" SignedInt val 
  | maxInt: "maximum:" SignedInt val 
  | stepInt: "stepSize:" Int val
  | minFloat: "minimum:" SignedFloat val 
  | maxFloat: "maximum:" SignedFloat val 
  | stepFloat: "stepSize:" Float val
  | minDate: "minimum:" Date val 
  | maxDate: "maximum:" Date val; 
  
syntax WhitespaceOrComment 
  = whitespace: Whitespace
  | comment: Comment;     
   
lexical Type 
  = @category="Type" \bool: "bool" 
  | @category="Type" \int: "int" 
  | @category="Type" string: "string"
  | @category="Type" float: "float"
  | @category="Type" date: "date";

lexical WidgetType
  = @category="Variable" checkbox: "CheckBox" // bool
  | @category="Variable" combobox: "ComboBox" // bool
  | @category="Variable" radio: "RadioButton" // bool
  | @category="Variable" slider: "Slider" // int
  | @category="Variable" dial: "Dial" // int
  | @category="Variable" spinbox: "SpinBox"; // int
  
lexical Variable = @category="Type" Ident;

lexical Ident = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical Label = @category="Variable" String;

lexical Color = @category="Variable" String; // see http://doc.qt.digia.com/stable/stylesheet-reference.html

lexical Font = @category="Variable" String; // see http://doc.qt.digia.com/stable/stylesheet-reference.html

lexical SignedInt = Int | "-" Int;

lexical Int = [0-9]+ !>> [0-9];

lexical SignedFloat = Float | "-" Float;

lexical Float = [0-9]* "." [0-9]+ !>> [0-9];

lexical Date = Day "." Month "." Year;

lexical Day = "0"?[1-9] | [12][0-9] | "3" [01];

lexical Month = "0"?[1-9] | "1"[0-2];

lexical Year = Int; 

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


keyword Keywords = "group" | "stylesheet" |
					"bool" | "int" | "string" | "float" | "date";


layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";



