stylesheet complexForm {
  page "A page" {
    section "A section" {
      question abool {
        type checkbox
      }
    }
    
    section "Another section" {
      question abool2
      question abool3
      
      default boolean {
        type radio
      }
    }
  }
  
  page "Another page" {
    section "Why not have another section?" {
      question abool4
      question abool5 {
        type radio
      }
    }
  }
  
  default boolean {
    width 100
  }
}
