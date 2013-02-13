module template::File

import IO;
import template::StringTemplate;
import template::CSS;
import template::JavaScript;

/** Method to generate a directory for the JavaScript Program
* @return l the location of the directory
* @ author Philipp
*/
loc generateQLDirectory(){
	l = |home:///TestQLJavaScript|;
	if(isDirectory(l)){
		println("NO CREATE");
		return l;
	}else{
		println("create L : <l>");
		mkDirectory(l);
		return l;
	}
}

/** Method 
*/
void generateHTMLFile(str id, str program, loc l){
	l += "<id>.html";
	println("LOC : <l>");
	writeFile(l,program);
}

void generateJavaScriptFile(str id, str func, loc l){
	l += "<id>.js";
	println("create empty js file");
	writeFile(l, func);
}

void generateCSSFile(str id, str css, loc l){
	l += "<id>.css";
	if(isFile(l)){
		println("append to file : <l>");
		appendToFile(l, "\n <css>");
	}else{
		writeFile(l,css);
	}
}

public void generateQLProgram(str id, str program, str func){
	loc dir = generateQLDirectory();
	generateHTMLFile(id,program,dir);
	generateJavaScriptFile(id,func,dir);
	//s = cssEndLabels();
	//generateCSSFile(id,s,dir);
}

public void generateCSSFile(str formId, str id){
	loc dir = generateQLDirectory();
	s = cssEndLabels(id);
	println("s : <s>");
	generateCSSFile(formId,s,dir);
}

