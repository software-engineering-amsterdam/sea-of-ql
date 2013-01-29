stylesheet testStylesheet {
  page pageOne {
    section sectionOne {
      section sectionTwo {
        question questionTen
        
        default boolean {
          width 200
        }
      }
      
      question questionFive {
        width 50
      }
    }
    
    section sectionThree {
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
  
  page pageTwo {
    question questionTwo
  }
  
  default boolean {
    type radio
  }
  
  question questionThree {
    width 200
  }
}
