module lang::qls::gen::Groups

public str addGroup(str name, list[str] members) {
	src = declareGroup(name);
	for (member <- members)
		src += addGroupWidget(member);
	src += makeLayout();
	return src;
}



private str declareGroup(str name) = "
\t\tgroupBox = new QGroupBox(<name>);
\t\tgroupBoxLayout = new QGridLayout();
\t\tgroupBox.setLayout(groupBoxLayout);
";


private str addGroupWidget(str name) = "
\t\tgroupLabels.add(<name>Label);";


private str makeLayout() = "
\t\tfor (int i = 0; i \< groupLabels.size(); i++) {
\t\t\tgroupBoxLayout.addWidget(groupLabels.get(i), i, 0,  Qt.AlignmentFlag.AlignRight);
\t\t\tgroupBoxLayout.addWidget(groupLabels.get(i).buddy(), i, 1,  Qt.AlignmentFlag.AlignLeft);
\t\t}
\t\tgroupBoxLayout.setColumnMinimumWidth(0, labelMinWidth);
\t\tgroupBoxLayout.setColumnMinimumWidth(1, widgetMinWidth);
\t\tlayout.addWidget(groupBox, labels.indexOf(groupBoxLayout.itemAtPosition(0, 0).widget()), 0, 1, 2);
\t\tgroupLabels.clear(); 
"; 	
