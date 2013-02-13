module template::CSS

import template::StringTemplate;

public str cssEndLabels(str id){
	str res = "p.<id>Paragraph {
 		  padding-left: 10px;
   		  font-weight: bold;
 		} ";
 
	return res;
}



//boughtHouseEndClass