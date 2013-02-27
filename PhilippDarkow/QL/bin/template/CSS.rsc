module template::CSS

import template::StringTemplate;
import template::File;
import Prelude;

/** Method to create css code for a question paragraph
* @id the id of the question
* @return str a string with css code
* @author Philipp
*/
public void cssEndLabels(str formId, str id){
	str res = "p.<id>Paragraph { 
		' padding-left: 10px; 
		' font-weight: bold; 
		'}"; 
	appendToCssFile(formId, res);
}

/** Method to create css code for a the div section
* @id the id of the questionaire
* @return str a string with css code
* @author Philipp
*/
public void cssDiv(str id){
	str res = "div.<id>Div {
		' background: rgb(103, 111, 128);
		' text-align: center;
		'}";
	appendToCssFile(id, res);
}

/** Method to append code to a css file
* @param formId the name of the questionaire used as Filename
* @param text the css code to append
* @author Philipp
*/
void appendToCssFile(str formId, str text){
	loc l = |file:///wamp/www/<formId>|;
	l += "<formId>.css";
	appendToFile(l, "\n <text>");
}