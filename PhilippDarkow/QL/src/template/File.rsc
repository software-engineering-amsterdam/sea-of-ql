module template::File

import IO;

/** Method to generate a directory for the JavaScript Program
* @return l the location of the directory
* @ author Philipp
*/
loc generateJavaScriptDirectory(){
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
void generateJavaScriptFile(str id, str program, loc l){
	l += "<id>.html";
	println("LOC : <l>");
	writeFile(l,program);
}

public void generateJavaScript(str id, str program){
	loc dir = generateJavaScriptDirectory();
	generateJavaScriptFile(id,program,dir);
}