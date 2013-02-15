module template::CSS

import template::StringTemplate;
import template::File;
import Prelude;

public str cssEndLabels(str id){
	str res = "p.<id>Paragraph {
 		  padding-left: 10px;
   		  font-weight: bold;
 		} ";
 
	return res;
}

public void cssDiv(str id){
	println("in CSS DIV : <id>Div");
	str res = "div.<id>Div {
	text-align: center;
	} ";
	println("res : <res>");
	appendToCssFile(id, res);
}