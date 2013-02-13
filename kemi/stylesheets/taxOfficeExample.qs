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
          font "sans-serif"
          fontsize 12
          color #FF0000
          label-font "serif"
          label-fontsize 24
          label-color #FFFF00
        }
        
      }
      
    }
    
    default boolean {
      widget radio
    }
    
  }
  
}
