module lang::qls::ast::AST

import lang::ql::ast::AST;

data FormStyle = style(str name, list[StyleRule] rules); 

data StyleRule
  = typed(Type \type, list[Rule] rules)
  | id(str name, list[Rule] rules)
  | group(str name, list[str] questions);
 
 
data Rule
  = color(str name)
  | widget(WidgetType \type)
  | font(str name)
  | minInt(int ival)
  | maxInt(int ival)
  | stepInt(int ival)
  | minFloat(real rval)
  | maxFloat(real rval)
  | stepFloat(real rval)
  | minDate(str dval)
  | maxDate(str dval);
 
data WidgetType
  = checkbox(str name)
  | combobox(str name)
  | radio(str name)
  | slider(str name)
  | dial(str name)
  | spinbox(str name)
  | dateedit(str name)
  | lineedit(str name)
  | doublespinbox(str name);

data Type
  = \bool(str name)
  | \int(str name)
  | string(str name)
  | float(str name)
  | date(str name);


anno loc FormStyle@location;
anno loc StyleRule@location;
anno loc Rule@location;  
anno WidgetType Type@widget;