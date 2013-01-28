module lang::qls::ast::AST

data FormStyle = style(list[StyleRule] rules); 

data StyleRule
  = typed(Type \type, list[Rule] rules)
  | id(str name, list[Rule] rules)
  | group(str name, list[str] questions);
 
 
data Rule
  = color(str name)
  | widget(Widget \type)
  | font(str name)
  | width(int size)
  | min(real val)
  | max(real val)
  | step(real val);
 
data Widget
  = checkbox(str name)
  | radio(str name);

data Type
  = \bool(str name)
  | \int(str name)
  | string(str name)
  | float(str name)
  | date(str name);


anno loc FormStyle@location;
anno loc StyleRule@location;
anno loc Rule@location;  
  