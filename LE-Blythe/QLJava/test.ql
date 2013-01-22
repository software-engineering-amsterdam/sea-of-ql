form a{
	"question" q1:boolean
	"question" q2:q1 || true
	
	if(q1){ 
		"question" q3:boolean 	
	}
	else{
		"question" q3:q1 && (1+1)
	}
	if(q2){ 
		"question" q4:string
	}
}