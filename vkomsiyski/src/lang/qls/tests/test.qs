stylesheet test;   

hasSoldHouse  {  
	color: "rgba(255, 128, 128, 80%)"
	widget: RadioButton 
}  


bool {
	color: "pink"
	widget: ComboBox
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



DateQ { 
	maximum: 4.2.2013 
}
 
float {
	minimum: 20.0 
	maximum: 10000.0
	stepSize: 7.1
} 


group "Birthday stuff" {  
	DateQ
	over 
}    

group "Sold House Questions" { 
	sellingPrice
	privateDebt
	valueResidue
}

over {
	widget: RadioButton
	font: "italic bold 20px Times New Roman"
	color: "red" 
}
