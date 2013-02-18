module Configuration

private loc PROJECT_NAME = |project://QL-R-kemi/|;

public loc getJSSourceLoc() = 
  PROJECT_NAME + "js/";

public loc getCompileTarget() = 
  PROJECT_NAME + "output/";

public str getQLLangName() = 
  "QL-R";
  
public str getQLLangExt() = 
  "q";
  
public str getQLSLangName() = 
  "QLS-R";
  
public str getQLSLangExt() = 
  "qs";

public str getCSSStylesheetName() =
  "style.css";

public str getStylingJSName() =
  "styling.js";

public str getCheckingJSName() =
  "checking.js";

public str getHTMLName() =
  "index.html";

public str getPHPName() = 
  "form.php";
