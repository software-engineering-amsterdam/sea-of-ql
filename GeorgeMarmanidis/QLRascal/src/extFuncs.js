function validString(input){
    return !(/[\\/&;]/.test(input));}

function validInteger(input){
		if(input==""){return true;}
		return /(^-?\d\d*$)/.test(input);}

function validBoolean(input){
		return true;
		}

function validDate(input){
		if(input==""){return true;}
		return /^(0?[1-9]|[12][0-9]|3[01])[\/\-](0?[1-9]|1[012])[\/\-]\d{4}$/.test(input);}

function validMoney(input){
		if(input==""){return true;}
		return /^-{0,1}\d+[,]?\d{0,2}$/.test(inpt);}

function validFloat(input){
		if(input==""){return true;}
		return /^-{0,1}\d+[.]?\d{0,2}$/.test(inpt);}

function exportToCsv(form) {
 var myCsv = "";
 for(i=0; i<form.elements.length-1; i++){
   if(form.elements[i].getAttribute("type")!="radio"){
      myCsv+=form.elements[i].name +" : " +form.elements[i].value + ";\n" ;
   }
   else {
      if(form.elements[i].checked){
         if(form.elements[i].value==="true"){
            myCsv+=form.elements[i].name + " : true\n" ;
         }
         if(form.elements[i].value==="false"){
            myCsv+=form.elements[i].name + " : false \n" ;
         }
      }
      else{
	      myCsv+=form.elements[i].name + " :  \n" ;
      }
   }
 }
 window.open('data:text/csv;charset=utf-8,' + escape(myCsv));
}
			