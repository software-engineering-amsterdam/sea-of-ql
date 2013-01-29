stylesheet testStylesheet {
  page "Page one" {
    section "section one" {
      section "section two" {
        question questionTen
        default boolean {
          width 200
        }
        
      }
      
      question questionFive {
        width 50
      }
      
    }
    
    section "section three!" {
      question questionFour
      question questionSix
      question questionSeven
      default boolean {
        type checkbox
      }
      
    }
    
    question questionOne {
      type checkbox
    }
    
  }
  
  page "page 2" {
    question questionTwo
  }
  
  default boolean {
    type radio
  }
  
  question questionThree {
    width 200
  }
  
}
