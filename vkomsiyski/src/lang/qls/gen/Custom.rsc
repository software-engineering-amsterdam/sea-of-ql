module lang::qls::gen::Custom

import lang::ql::gen::Widgets;
import lang::qls::ast::AST;
import lang::qls::util::Environment;

import lang::ql::ast::AST;
import lang::ql::util::Unparse;
import String;

public str localDeclarations() = "
		QLabel valueLabel;
		QRadioButton noButton;
		QHBoxLayout widgetBoxLayout;
		QVBoxLayout buttonBoxLayout;
		QGroupBox groupBox;
		QGridLayout groupBoxLayout;
		List\<QLabel\> groupLabels = new ArrayList\<QLabel\>();
";
   
   
public str declareCustomWidget(str name, str widget) 
  = "\tQ<widget> <name>Widget = new Q<widget>();\n"; 


public str addCustomWidget(Widget w, WidgetType wt:combobox(_)) = "
\t\t<w.name>Widget.addItem(\"No\");
\t\t<w.name>Widget.addItem(\"Yes\");
\t\t<w.name>Widget.currentIndexChanged.connect(this, \"onChanged(int)\");"
+ genericWidget(w.name, w.visibility, w.enabled);	
  

public str addCustomWidget(Widget w, WidgetType wt) 
  = addWidget(w);
   
     
public str customizeLabel(str name, VarRules rules) {
	deco = "";
	if (name in rules) 
		for (r <- rules[name])
			deco += getLabelDecoration(name, r);
	return "\n\t\t<name>Label.setStyleSheet(\"<deco>\");\n";
} 

public str customizeWidget(str name, WidgetType wt, VarRules rules) {
	deco = "";
	if (name in rules) 
		for (r <- rules[name])
			deco += getWidgetDecoration(name, wt, r);
	return deco;
}

private str getLabelDecoration(str name, Rule rule:color(cname)) 
	=  "color : <replaceAll(cname, "\"", "")>;";

private str getLabelDecoration(str name, Rule rule:font(fname)) 
	=  "font : <replaceAll(fname, "\"", "")>;";
		
private str getLabelDecoration(str name, Rule rule) =  "";


private str getWidgetDecoration(str name, WidgetType wt, Rule rule:minInt(val)) 
	=  "\t\t<name>Widget.setMinimum(<val>);\n";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:minInt(val)) 
	=  "\t\t<name>Widget.setMinimum(<val>);\n";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:maxInt(val)) 
	=  "\t\t<name>Widget.setMaximum(<val>);\n";

private str getWidgetDecoration(str name, WidgetType wt:slider(_), Rule rule:stepInt(val)) 
	=  "\t\t<name>Widget.setSingleStep(<val>);
	   '\t\t<name>Widget.setPageStep(<val>);\n";

private str getWidgetDecoration(str name, WidgetType wt:dial(_), Rule rule:stepInt(val)) 
	=  "\t\t<name>Widget.setSingleStep(<val>);
	   '\t\t<name>Widget.setPageStep(<val>);\n";
	   
private str getWidgetDecoration(str name, WidgetType wt, Rule rule:stepInt(val)) 
	=  "\t\t<name>Widget.setSingleStep(<val>);\n";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:minFloat(val)) 
	=  "\t\t<name>Widget.setMinimum(<val>);\n";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:maxFloat(val)) 
	=  "\t\t<name>Widget.setMaximum(<val>);\n";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:stepFloat(val)) 
	=  "\t\t<name>Widget.setSingleStep(<val>);\n";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:minDate(val)) 
	=  "\t\t<name>Widget.setMinimumDate(<unparse(dateConst(val), ())>);\n";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:maxDate(val)) 
	=  "\t\t<name>Widget.setMaximumDate(<unparse(dateConst(val), ())>);\n";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:widget(dial(_))) = "
\t\tvalueLabel = new QLabel(Integer.toString(<name>Widget.value()));
\t\t<name>Widget.valueChanged.connect(valueLabel, \"setNum(int)\");
\t\tgroupBox = new QGroupBox();
\t\twidgetBoxLayout = new QHBoxLayout();
\t\tgroupBox.setLayout(widgetBoxLayout);
\t\twidgetBoxLayout.addWidget(<name>Widget);
\t\twidgetBoxLayout.addWidget(valueLabel);
\t\tgroupBox.setVisible(true);
\t\tgroupBox.setFixedHeight(groupBox.height());
\t\t<name>Label.setBuddy(groupBox);
";		  

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:widget(slider(_))) = "
\t\t<name>Widget.setOrientation(Qt.Orientation.Horizontal);
\t\tvalueLabel = new QLabel(Integer.toString(<name>Widget.value()));
\t\t<name>Widget.valueChanged.connect(valueLabel, \"setNum(int)\");
\t\tgroupBox = new QGroupBox();
\t\twidgetBoxLayout = new QHBoxLayout();
\t\tgroupBox.setLayout(widgetBoxLayout);
\t\twidgetBoxLayout.addWidget(<name>Widget);
\t\twidgetBoxLayout.addWidget(valueLabel);
\t\tgroupBox.setVisible(true);
\t\tgroupBox.setFixedHeight(groupBox.height());
\t\t<name>Label.setBuddy(groupBox);
";	

private str getWidgetDecoration(str name, WidgetType wt, Rule rule:widget(radio(_))) = "
\t\t<name>Widget.setText(\"Yes\");
\t\tnoButton = new QRadioButton(\"No\");
\t\tnoButton.setChecked(!<name>Widget.isChecked());
\t\tnoButton.setEnabled(<name>Widget.isEnabled());
\t\tgroupBox = new QGroupBox();
\t\tbuttonBoxLayout = new QVBoxLayout();
\t\tgroupBox.setLayout(buttonBoxLayout);
\t\tbuttonBoxLayout.addWidget(<name>Widget);
\t\tbuttonBoxLayout.addWidget(noButton);
\t\tgroupBox.setVisible(true);
\t\tgroupBox.setFixedHeight(groupBox.height());
\t\t<name>Label.setBuddy(groupBox);
";	


private str getWidgetDecoration(str name, WidgetType wt, Rule rule:widget(_)) =  "";

private str getWidgetDecoration(str name, WidgetType wt, Rule rule) =  "";







