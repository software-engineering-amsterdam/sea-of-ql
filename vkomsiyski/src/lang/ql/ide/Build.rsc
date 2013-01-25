module lang::ql::ide::Build

import lang::ql::ast::AST;
import lang::ql::util::Implode;
import lang::ql::util::Message;
import util::IDE;
import ParseTree;
import Message;
import Set;
import List;
import IO;


private loc prefix_file = |project://QL-R/src/form/prefix.javapart|;
private loc internal_file = |project://QL-R/src/form/internal.javapart|;
private loc suffix_file = |project://QL-R/src/form/suffix.javapart|;

private loc generated_form = |project://QL-R/src/form/FormGUI.java|;


public Contribution getBuilder() 
  = builder(set[Message] (Tree input) {
	  writeFile(generated_form, readFile(prefix_file));
	  appendToFile(generated_form, declarations(implode(input)));
	  appendToFile(generated_form, readFile(internal_file));
	//  appendToFile(generated_form, build(implode(input)));
	  appendToFile(generated_form, readFile(suffix_file));
	  return {};
  });
    

public str declarations(Form f) = "";
  
  
public str build(Form f) {
	str ret = "
setWindowTitle(\"<f.name>\");
setToolTip(\"<f.name>\");";

	i = 0;
	for (Statement st <- f.statements) {
		ret += build(st, i);
		i+=1;
	}
	return ret;
}


private str addLabel(str name, int row) = "
label = new QLabel(<name>);
layout.addWidget(label, <row>, 0, Qt.AlignmentFlag.AlignRight);";


private str addCheckBox(bool checked, int row) = "
checkBox = new QCheckBox();
checkBox.setChecked(<checked>);
label.setBuddy(checkBox);
checkBox.toggled.connect(this, \"onChanged(boolean)\");
layout.addWidget(checkBox, <row>, 1, Qt.AlignmentFlag.AlignLeft);";


private str addLineEdit(str line, int row) = "
lineEdit = new QLineEdit(<line>);
label.setBuddy(lineEdit);
lineEdit.editingFinished.connect(this, \"onChanged()\");
layout.addWidget(lineEdit, <row>, 1, Qt.AlignmentFlag.AlignLeft);";

private str addSpinBox(int val, int row) = "
spinBox = new QSpinBox();
spinBox.setValue(<val>);
label.setBuddy(spinBox);
spinBox.editingFinished.connect(this, \"onChanged()\");
layout.addWidget(spinBox, <row>, 1, Qt.AlignmentFlag.AlignLeft);";

private str addDoubleSpinBox(real val, int row) = "
doubleSpinBox = new QDoubleSpinBox();
doubleSpinBox.setValue(<val>);
label.setBuddy(doubleSpinBox);
doubleSpinBox.editingFinished.connect(this, \"onChanged()\");
layout.addWidget(doubleSpinBox, <row>, 1, Qt.AlignmentFlag.AlignLeft);";

private str addDateEdit(int y, int m, int d, int row) = "
dateEdit = new QDateEdit(new QDate(<y>, <m>, <d>));
dateEdit.setDisplayFormat(\"d MMMM yyyy\");
label.setBuddy(dateEdit);
dateEdit.editingFinished.connect(this, \"onChanged()\");
layout.addWidget(dateEdit, <row>, 1, Qt.AlignmentFlag.AlignLeft);";



private str build(Statement s:regular("bool", name, label), row) 
  = addLabel(label, row) + addCheckBox(false, row);
  
private str build(Statement s:regular("int", name, label), row) 
  = addLabel(label, row) + addSpinBox(0, row);
 
private str build(Statement s:regular("float", name, label), row) 
  = addLabel(label, row) + addDoubleSpinBox(0.0, row);  
  
private str build(Statement s:regular("string", name, label), row) 
  = addLabel(label, row) + addLineEdit("", row);  
  
private str build(Statement s:regular("date", name, label), row) 
  = addLabel(label, row) + addDateEdit(0,0,0, row);  
  
 private str build(Statement s, int row) = "";
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  

