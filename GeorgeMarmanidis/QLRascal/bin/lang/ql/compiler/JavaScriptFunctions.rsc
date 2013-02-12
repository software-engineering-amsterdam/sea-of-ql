module lang::ql::compiler::JavaScriptFunctions

//Forms
public str createFormStatmn()=createStartFormStatmn() + createEndFormStatmn();


public str createStartFormStatmn(str formName)=	"\<form name=\"<formName>\"\>";


public str createEndFormStatmn()= "\</form\>";
//Form Body

public str createBodyStatmn(){
	return "BODY";
}

public str createItemmStatmn(){

}

public str createIdentItemStatmn(){

}

public str createInputItemStatmn(){

}

public str createTypeItemStatmn(){

}

public str createIdItemStatmn(){

}

public str createValueItemStatmn(){

}

public str createOnChangeItemStatmn(){

}

//General
public str createBreakLineStatmn()= "\</br\>";

public str createGroupStatmn(){

}

public str createStartGroupStatmn(){

}

public str createGroupEndStatmn(){

}