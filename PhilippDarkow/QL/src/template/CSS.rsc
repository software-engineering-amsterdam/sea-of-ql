module template::CSS

import template::StringTemplate;

public str cssEndLabels(str id){
	return "p.<id>Paragraph {
   padding-left: 10px;
   font-weight: bold;
 } ";
}



//boughtHouseEndClass