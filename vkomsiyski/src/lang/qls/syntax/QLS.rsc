module lang::qls::syntax::QLS

start syntax FormStyle 
   = @Foldable style: "stylesheet" Ident name ";" StyleRule* rules;

syntax StyleRule
  = @Foldable typed: Type type "{" Rule+ "}"
  | @Foldable id: Ident name "{" Rule+ "}"
  | @Foldable group: "group" Label name "{" Ident+ questions "}";

syntax Rule 
  = color: "color:"  Color color // color of the label text
  | font: "font:" Font font // font of the label text
  | widget: "widget:" Widget widget 
  | minInt: "minimum:" Int val 
  | maxInt: "maximum:" Int val 
  | stepInt: "stepSize:" Int val
  | minFloat: "minimum:" Float val 
  | maxFloat: "maximum:" Float val 
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

lexical Widget
  = @category="Variable" checkbox: "checkbox" // bool
  | @category="Variable" combobox: "combobox" // bool
  | @category="Variable" radio: "radio" // bool
  | @category="Variable" slider: "slider" // numeric
  | @category="Variable" dial: "dial" // numeric
  | @category="Variable" spinbox: "spinbox"; // numeric
  

lexical Ident = ([a-z A-Z 0-9 _] !<< [a-z A-Z][a-z A-Z 0-9 _]* !>> [a-z A-Z 0-9 _]) \ Keywords;

lexical Label = @category="Variable" String;

lexical Color = @category="Variable" String;

lexical Font = @category="Variable" String;

lexical Int = IntNumber | "-" IntNumber;

lexical IntNumber = [0-9]+ !>> [0-9];

lexical Float = FloatNumber | "-" FloatNumber;

lexical FloatNumber = [0-9]* "." [0-9]+ !>> [0-9];

lexical Date = Day "." Month "." Year;

lexical Day = "0"?[1-9] | [12][0-9] | "3" [01];

lexical Month = "0"?[1-9] | "1"[0-2];

lexical Year = IntNumber; 

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


keyword Keywords = "group" | "page" | "stylesheet" |
					"bool" | "int" | "string" | "float" | "date" |
					"true" | "false" |
					"color" | "widget" | "font" | "minimum" | "maximum" | "width" | "stepSize" |
					"checkbox" | "radio";


layout Standard = WhitespaceOrComment* !>> [\ \t\n\f\r] !>> "//" !>> "/*";



