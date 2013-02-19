stylesheet proposedSyntax {
  page "Page one" {
    section "section one" {
      section "section two" {
        question questionTen
        default boolean {
          widget select
        }
        
      }
      
      question questionFive {
        width 50
      }
      
    }
    
    section "section three!" {
      question questionFour {
        widget number[0., 2.5, 0.05]
      }
      
      question questionSix
      question questionSeven
      default boolean {
        widget checkbox
      }
      
    }
    
    question questionOne {
      widget checkbox
    }
    
    default boolean {
      widget radio
    }
    
    default date {
      widget datepicker
    }
    
  }
  
  page "page 2" {
    question questionTwo
  }
  
  default boolean {
    widget radio
  }
  
  default integer {
    widget slider[0., 100., 10.]
  }
  
  question questionThree {
    width 200
  }
  
}
