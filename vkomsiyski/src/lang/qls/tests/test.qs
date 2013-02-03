stylesheet test;  

bool {
color: "rgba(255, 128, 128, 50%)"
}

int { 
minimum: -8
maximum: -4
//widget:SpinBox 
}    
  
sellingPrice {  
stepSize: 15000.0
} 

DateQ {
minimum: 20.1.2013
maximum: 20.2.2013
}
 
float {
minimum: -8.0
maximum: -4.0
//  stepSize: 7.1
} 


group "hi" { 
	over
	DateQ
}    

group "hdi" { 
hasMaintLoan
	
}



over {
//	widget: ComboBox
	font: "italic bold 20px Times New Roman"
	color: "red" 
}
