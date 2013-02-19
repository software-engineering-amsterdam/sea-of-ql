module Configuration

private loc projectName = |project://QL-R-kemi/|;

public loc getStaticSourceLoc() = 
  projectName + "static/";

public loc getCompileTarget() = 
  projectName + "output/";

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
