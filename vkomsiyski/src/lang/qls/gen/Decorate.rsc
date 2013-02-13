module lang::qls::gen::Decorate

import lang::ql::ast::AST;
import lang::ql::gen::Widgets;
import lang::ql::util::Environment;
import lang::qls::ast::AST;
import lang::qls::util::Environment;


public Declarations decorateDeclarations(Declarations d, StyleEnvironment env) {
	for (name <- d) {
		d[name].\type = d[name].\type[@widget = defaultWidget(d[name].\type)];
	
		if (name in env.varRules)
			for (rule <- env.varRules[name], widget(t) := rule) 
				d[name].\type = d[name].\type[@widget = t];
		else if (d[name].\type in env.typeRules)
			for (rule <- env.typeRules[d[name].\type], widget(t) := rule)
				d[name].\type = d[name].\type[@widget = t];	
	}
	return d;
}

public list[Widget] decorateWidgets(list[Widget] widgets, StyleEnvironment env) {
	decoratedWidgets = [];
	for (w <- widgets) {
		w.\type = w.\type[@widget = defaultWidget(w.\type)];
	
		if (w.name in env.varRules)
			for (rule <- env.varRules[w.name], widget(t) := rule) 
				w.\type = w.\type[@widget = t];
		else if (w.\type in env.typeRules)
			for (rule <- env.typeRules[w.\type], widget(t) := rule)
				w.\type = w.\type[@widget = t];

		decoratedWidgets += w;
	}
	return decoratedWidgets;
}

 
private WidgetType defaultWidget(Type t:\bool(_)) = checkbox("CheckBox");
private WidgetType defaultWidget(Type t:\int(_)) = spinbox("SpinBox");
private WidgetType defaultWidget(Type t:float(_)) = doublespinbox("DoubleSpinBox");
private WidgetType defaultWidget(Type t:date(_)) = dateedit("DateEdit");
private WidgetType defaultWidget(Type t:string(_)) = lineedit("LineEdit");

