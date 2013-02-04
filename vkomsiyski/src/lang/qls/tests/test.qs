stylesheet test;   

hasSoldHouse  {    
color: "rgba(255, 128, 128, 50%)"
widget: RadioButton 
}  
 
int {     
minimum: -20
maximum: -4  
stepSize: 2  
widget: Dial   
}     
   
sellingPrice {    
maximum: 3000  
stepSize: 50  
widget: Slider   
} 

//DateQ { 
//minimum: 20.1.2013
//maximum: 20.2.2013 
//}
 
float {
minimum: 20.0 
maximum: 10000.0
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
	widget: ComboBox
	font: "italic bold 20px Times New Roman"
	color: "red" 
}
