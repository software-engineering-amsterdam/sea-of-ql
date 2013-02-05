stylesheet complexForm {
  page "A page" {
    section "A section" {
      question abool {
        widget checkbox
      }
    }
    
    section "Another section" {
      question abool2
      question abool3
      
      default boolean {
        widget radio
      }
    }
  }
  
  page "Another page" {
    section "Why not have another section?" {
      question abool4
      question abool5 {
        widget radio
      }
    }
  }
  
  default integer {
    width 100
  }
}
