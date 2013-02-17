stylesheet nestedIfElseIfElseCondition {
  page "Page one" {
    section "Section one" {
      question numberOne
    }
    
    section "Section two" {
      question theDate
      
      section "Subsection one" {
     	  question anotherDate
     	  question aoeu {
     	    widget slider
     	  }
     	}
     	
     	default integer {
     	  width 100
     	}
 	  }
  }
  
  page "Page two" {
    section "Section three" {
      question aText
 	  }
  }
  
  page "Page three" {
    question bText
    question numberOneAgain
  	question myFunding
  }
  
  page "Page four" {
    question cText {
      width 400
    }
  }
  
  default string {
    width 300
  }
  
  default money {
    width 200
  }
}
