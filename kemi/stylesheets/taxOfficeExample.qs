stylesheet taxOfficeExample {
  page "Housing" {
    section "Buying" {
      question hasBoughtHouse {
        widget checkbox
      }
      
    }
    
    section "Loaning" {
      question hasMaintLoan
    }
    
    section "Selling" {
      question hasSoldHouse {
        widget select
      }
      section "You sold a house" {
        question sellingPrice
        question privateDebt {
          widget slider
        }
        
        question valueResidue
        default money {
          width 150
          widget number
          font "Arial"
          fontsize 14
          color #999999
          label-font "Comic Sans MS"
          label-fontsize 16
          label-color #2E31C2
        }
        
      }
      
    }
    
    default boolean {
      widget radio
    }
    
  }
  
}
