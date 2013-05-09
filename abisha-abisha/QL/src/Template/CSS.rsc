module Template::CSS

import Template::JSStringTemplate;
import syntax::Abstract;
import TypeCheck::QuestionChecker;
import load::Load;
import String;
import IO;
import Prelude;
import util::Math;
import TypeCheck::QuestionChecker;

//Generate and save CSS
public void generateAndSaveCSS(str qId)
{
	str result ="root 
	{ 
    	display: block;
	}
	.questionnaireContainer
	{
		background-color: grey;
		width: 800px;
	}
	.questionContainer
	{
		height: 50px;
		width: 800px;
	}

	.ifBlockContainer
	{
		background-color: green;
		border-width:1px;
		border-style: solid;
	}
	.elseBlockContainer
	{
		background-color: red;
		border-width:1px;
		border-style: solid;
	}
	.questionLabel
	{
		background-color: yellow;
		width: 200px;
		float: left;
	}

	.booleanType
	{
		background-color: red;
		width: 70px;
		float: left;
	}";
writeFile(|file:///C:/queL/|+"<qId>.css",result);
}

private void appendToCSSFile(str qId, str toAppend)
{
	appendToFile(|file:///C:/queL/|+"<qId>.css", toAppend); 
}

